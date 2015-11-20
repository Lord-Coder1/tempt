package iitc.game;

import iitc.physics.*;
import iitc.physics.Rectangle;
import iitc.physics.Vector;

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
        this.walls = new Wall[]{new Wall(new Dimension2d(width, halfHeight)), new Wall(new Dimension2d(halfWidth, height)), new Wall(new Dimension2d(width, halfHeight)), new Wall(new Dimension2d(halfWidth, height))};
        walls[0].setPosition(0, -halfHeight);
        walls[1].setPosition(width, 0);
        walls[2].setPosition(width, -halfHeight);
        walls[3].setPosition(-halfWidth, 0);
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

    public void clear() {
        entities.clear();
        updateTimes.clear();
    }

    //TODO:Do some pruning to the entity sets for collisions to optimize larger entity sets
    public synchronized void update() {
        synchronized (entities) {
            Map<SceneEntity2d, List<SceneEntity2d>> visited = new HashMap<SceneEntity2d, List<SceneEntity2d>>();
            for (SceneEntity2d entity : entities) {
                Cartesian2d entityPosition = entity.getPosition();
                Vector2d entityVelocity = entity.getVelocity();
                Dimension2d entitySize = entity.getSize();
                List<SceneEntity2d> entityVisits = visited.get(entity);
                double entityX = entityPosition.getX();
                double entityY = entityPosition.getY();
                double entityMaxX = entityX + entitySize.getWidth();
                double entityMaxY = entityY + entitySize.getHeight();
                Rectangle rectangle = new Rectangle(entity.getPosition(), entity.getSize());
                for (SceneEntity2d opposition : entities) {
                    if ((entityVisits != null && entityVisits.contains(opposition)) || opposition.equals(entity))
                        continue;
                    List<SceneEntity2d> oppositeVisits = visited.get(opposition);
                    if (oppositeVisits != null && oppositeVisits.contains(entity))
                        continue;
                    Cartesian2d oppositionPosition = opposition.getPosition();
                    Vector2d oppositionVelocity = opposition.getVelocity();
                    Dimension2d oppositionSize = opposition.getSize();
                    if (rectangle.intersects(oppositionPosition, oppositionSize)) {
                        double oppositionX = oppositionPosition.getX();
                        double oppositionY = oppositionPosition.getY();
                        double oppositionMaxX = oppositionX + oppositionSize.getWidth();
                        double oppositionMaxY = oppositionY + oppositionSize.getHeight();
                        if ((entityX < oppositionX && oppositionMaxX > entityMaxX && entityVelocity.getX() < 0 && oppositionVelocity.getX() > 0) || (entityY < oppositionY && oppositionMaxY > entityMaxY && entityVelocity.getY() < 0 && oppositionVelocity.getY() > 0))
                            continue;
                        //TODO:Actually get the proper collision calculating momentum and using proper angles
                        entity.setVelocity(Vector.inverse(entityVelocity));
                        opposition.setVelocity(Vector.inverse(oppositionVelocity));
                        if (entityVisits == null) {
                            entityVisits = new ArrayList<SceneEntity2d>();
                            visited.put(entity, entityVisits);
                        }
                        entityVisits.add(opposition);
                    }
                }
                for (SceneEntity2d opposition : walls) {
                    if ((entityVisits != null && entityVisits.contains(opposition)) || opposition.equals(entity))
                        continue;
                    Cartesian2d oppositionPosition = opposition.getPosition();
                    Vector2d oppositionVelocity = opposition.getVelocity();
                    Dimension2d oppositionSize = opposition.getSize();
                    if (rectangle.intersects(oppositionPosition, oppositionSize)) {
                        double oppositionX = oppositionPosition.getX();
                        double oppositionY = oppositionPosition.getY();
                        double oppositionMaxX = oppositionX + oppositionSize.getWidth();
                        double oppositionMaxY = oppositionY + oppositionSize.getHeight();
                        if ((entityX < oppositionX && oppositionMaxX > entityMaxX && entityVelocity.getX() < 0 && oppositionVelocity.getX() > 0) || (entityY < oppositionY && oppositionMaxY > entityMaxY && entityVelocity.getY() < 0 && oppositionVelocity.getY() > 0))
                            continue;
                        //TODO:Actually get the proper collision calculating momentum and using proper angles
                        entity.setVelocity(Vector.inverse(entityVelocity));
                        opposition.setVelocity(Vector.inverse(oppositionVelocity));
                        if (entityVisits == null) {
                            entityVisits = new ArrayList<SceneEntity2d>();
                            visited.put(entity, entityVisits);
                        }
                        entityVisits.add(opposition);
                    }
                }
            }
            long time = System.currentTimeMillis();
            for (SceneEntity2d entity : entities) {
                Long update = updateTimes.get(entity);
                if (update != null)
                    entity.getMotion().setPosition(Motion.getPosition((time - update) / 1000.0d, entity.getMotion().getPosition(), entity.getMotion().getVelocity(), entity.getMotion().getAcceleration()));
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
