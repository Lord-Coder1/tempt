package iitc.game;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * SceneView
 *
 * @author Ian
 * @version 1.0
 */
public class SceneView {
    private BufferedImage image;
    private Color background;
    private final Scene scene;

    public SceneView(Scene scene) {
        this(scene, null);
    }

    public SceneView(Scene scene, Color background) {
        this.scene = scene;
        this.background = background;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void update() {
        scene.update();
    }

    public void invalidate() {
        image = null;
    }

    public BufferedImage render() {
        BufferedImage image = getImage();
        if (image != null)
            return image;
        iitc.physics.Rectangle bounds = scene.getBounds();
        if (bounds == null)
            return null;
        image = new BufferedImage((int) Math.round(bounds.getWidth()), (int) Math.round(bounds.getHeight()), BufferedImage.TYPE_INT_ARGB);
        Color background = getBackground();
        if (background != null) {
            Graphics graphics = image.getGraphics();
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        }
        for (SceneEntity2d entity : scene.getEntities())
            entity.render(image.getGraphics(), (int) Math.round(bounds.getX()), (int) Math.round(bounds.getY()));
        this.image = image;
        return image;
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
