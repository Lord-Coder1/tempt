package com.iancaffey.tempt;

import com.iancaffey.tempt.shape.Rectangle;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * SceneView
 * <p>
 * A utility class which allows for controlling updating a scene and rendering it to an image.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SceneView {
    private final Scene scene;
    private BufferedImage image;
    private Color background;

    /**
     * Constructs a new {@code SceneView} with the specified scene.
     *
     * @param scene the scene to view
     */
    public SceneView(Scene scene) {
        this(scene, null);
    }

    /**
     * Constructs a new {@code SceneView} with the specified scene, and background color.
     *
     * @param scene      the scene to view
     * @param background the background color
     */
    public SceneView(Scene scene, Color background) {
        if (scene == null)
            throw new IllegalArgumentException();
        this.scene = scene;
        this.background = background;
    }

    /**
     * Returns an image which represents the last rendered scene frame.
     *
     * @return the image representing the last viewed scene frame
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Updates the scene and re-renders the scene.
     */
    public void update() {
        scene.update();
        invalidate();
    }

    /**
     * Clears the rendered scene view cache.
     */
    public void invalidate() {
        image = null;
    }

    /**
     * Renders the scene to an image.
     *
     * @return the newly rendered scene image
     */
    public BufferedImage render() {
        BufferedImage image = getImage();
        if (image != null)
            return image;
        Rectangle bounds = scene.getBounds();
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

    /**
     * Renders the lazily-rendered scene to the graphics context.
     *
     * @param graphics the graphics context
     */
    public void render(Graphics graphics) {
        BufferedImage image = render();
        if (image == null)
            return;
        graphics.drawImage(image, 0, 0, null);
    }

    /**
     * Returns the scene view background color.
     *
     * @return the background color
     */
    public Color getBackground() {
        return background;
    }

    /**
     * Updates the scene view background color.
     *
     * @param background the background color
     */
    public void setBackground(Color background) {
        this.background = background;
    }
}
