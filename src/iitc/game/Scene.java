package iitc.game;

import iitc.physics.Motion;
import iitc.physics.Rectangle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public Scene(double x, double y, double width, double height) {
        this(new Rectangle(x, y, width, height));
    }

    public Scene(Rectangle bounds) {
        this.bounds = bounds;
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

    public synchronized void update() {
        synchronized (entities) {
            for (SceneEntity2d entity : entities) {
                Long update = updateTimes.get(entity);
                long time = System.currentTimeMillis();
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
