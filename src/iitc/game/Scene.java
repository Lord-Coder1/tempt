package iitc.game;

import iitc.physics.*;
import iitc.physics.Rectangle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * Scene
 *
 * @author Ian
 * @version 1.0
 */
public class Scene {
    private final Set<SceneEntity2d> entities = new HashSet<SceneEntity2d>();
    private final Map<SceneEntity2d, List<SceneEntity2d>> visited = new HashMap<SceneEntity2d, List<SceneEntity2d>>();
    private final Map<SceneEntity2d, Long> updateTimes = new HashMap<SceneEntity2d, Long>();
    private final Rectangle bounds;
    private BufferedImage image;
    private Color background;
    private final Wall[] walls;

    public Scene(double x, double y, double width, double height) {
        this(new Rectangle(x, y, width, height));
    }

    public Scene(Rectangle bounds) {
        if (bounds == null)
            throw new IllegalArgumentException();
        this.bounds = bounds;
        double width = bounds.getWidth();
        double height = bounds.getHeight();
        double halfHeight = height / 2.0d;
        double halfWidth = width / 2.0d;
        this.walls = new Wall[]{new Wall(new Dimension2d(halfWidth, height), Wall.Side.LEFT),
                new Wall(new Dimension2d(width, halfHeight), Wall.Side.TOP),
                new Wall(new Dimension2d(halfWidth, height), Wall.Side.RIGHT),
                new Wall(new Dimension2d(width, halfHeight), Wall.Side.BOTTOM)};
        walls[0].setPosition(-halfWidth, 0);
        walls[1].setPosition(0, -halfHeight);
        walls[2].setPosition(width, 0);
        walls[3].setPosition(0, height);
        Collections.addAll(entities, walls);
    }

    public void add(SceneEntity2d entity) {
        entities.add(entity);
    }

    public void remove(SceneEntity2d entity) {
        entities.remove(entity);
        updateTimes.remove(entity);
    }

    public SceneEntity2d[] getEntities() {
        return entities.toArray(new SceneEntity2d[entities.size()]);
    }

    public Wall[] getWalls() {
        return Arrays.copyOf(walls, walls.length);
    }

    public void clear() {
        entities.clear();
        updateTimes.clear();
    }

    //TODO:Do some pruning to the entity sets for collisions to optimize larger entity sets
    public synchronized void update() {
        synchronized (entities) {
            for (SceneEntity2d entity : entities) {
                List<SceneEntity2d> entityVisits = visited.get(entity);
                Rectangle rectangle = new Rectangle(entity.getPosition(), entity.getSize());
                for (SceneEntity2d opposition : entities) {
                    Cartesian2d oppositionPosition = opposition.getPosition();
                    Dimension2d oppositionSize = opposition.getSize();
                    if ((entityVisits != null && entityVisits.contains(opposition)) || opposition.equals(entity)) {
                        if (entityVisits != null && !rectangle.intersects(oppositionPosition, oppositionSize))
                            entityVisits.remove(opposition);
                        continue;
                    }
                    List<SceneEntity2d> oppositeVisits = visited.get(opposition);
                    if (oppositeVisits != null && oppositeVisits.contains(entity))
                        continue;
                    if (rectangle.intersects(oppositionPosition, oppositionSize)) {
                        VectorPair2d pair = Motion.getCollisionVelocity(entity, opposition);
                        entity.setVelocity(pair.getLeft());
                        opposition.setVelocity(pair.getRight());
                        if (entityVisits == null) {
                            entityVisits = new ArrayList<SceneEntity2d>();
                            visited.put(entity, entityVisits);
                        }
                        entityVisits.add(opposition);
                    } else if (entityVisits != null) {
                        entityVisits.remove(opposition);
                    }
                }
            }
            long time = System.currentTimeMillis();
            for (SceneEntity2d entity : entities) {
                Long update = updateTimes.get(entity);
                if (update != null) {
                    double t = (time - update) / 1000.0d;
                    entity.setPosition(Motion.getPosition(t, entity));
                    Vector2d velocity = entity.getVelocity();
                    if (velocity != null) {
                        Vector2d acceleration = entity.getAcceleration();
                        if (acceleration != null)
                            entity.setVelocity(velocity.getX() + t * acceleration.getX(), velocity.getY() + t * acceleration.getY());
                    }
                }
                updateTimes.put(entity, time);
            }
            image = null;
        }
    }

    public boolean contains(SceneEntity2d entity) {
        if (entity == null)
            return false;
        Rectangle bounds = getBounds();
        return bounds != null && bounds.contains(entity.getMotion().getPosition());
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public BufferedImage getImage() {
        return image;
    }

    public BufferedImage render() {
        synchronized (entities) {
            BufferedImage image = getImage();
            if (image != null)
                return image;
            Rectangle bounds = getBounds();
            if (bounds == null)
                return null;
            image = new BufferedImage((int) Math.round(bounds.getWidth()), (int) Math.round(bounds.getHeight()), BufferedImage.TYPE_INT_ARGB);
            Color background = getBackground();
            if (background != null) {
                Graphics graphics = image.getGraphics();
                graphics.setColor(Color.BLACK);
                graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
            }
            for (SceneEntity2d entity : entities)
                entity.render(image.getGraphics(), (int) Math.round(bounds.getX()), (int) Math.round(bounds.getY()));
            this.image = image;
            return image;
        }
    }

    public void render(Graphics graphics) {
        BufferedImage image = render();
        if (image == null)
            return;
        graphics.drawImage(image, 0, 0, null);
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }
}
