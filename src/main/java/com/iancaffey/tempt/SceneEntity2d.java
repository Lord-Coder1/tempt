package com.iancaffey.tempt;

import com.iancaffey.tempt.coordinate.Cartesian2d;
import com.iancaffey.tempt.entity.Entity2d;
import com.iancaffey.tempt.math.Dimension2d;
import com.iancaffey.tempt.math.Motion2d;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * SceneEntity2d
 * <p>
 * A representation of a renderable, locatable entity within a scene.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SceneEntity2d extends Entity2d {
    private BufferedImage image;

    /**
     * Constructs a new {@code SceneEntity2d} with specified mass and size.
     *
     * @param mass the mass of the scene entity
     * @param size the size of the scene entity
     */
    public SceneEntity2d(double mass, Dimension2d size) {
        super(mass, size);
    }

    /**
     * Constructs a new {@code SceneEntity2d} with specified mass, motion, and size.
     *
     * @param mass   the mass of the scene entity
     * @param motion the motion of the scene entity
     * @param size   the size of the scene entity
     */
    public SceneEntity2d(double mass, Motion2d motion, Dimension2d size) {
        super(mass, motion, size);
    }

    /**
     * Constructs a new {@code SceneEntity2d} with specified mass, size, and image.
     *
     * @param mass  the mass of the scene entity
     * @param size  the size of the scene entity
     * @param image the image of the scene entity
     */
    public SceneEntity2d(double mass, Dimension2d size, BufferedImage image) {
        super(mass, size);
        this.image = image;
    }

    /**
     * Constructs a new {@code SceneEntity2d} with specified mass, motion, size, and image.
     *
     * @param mass   the mass of the scene entity
     * @param motion the motion of the scene entity
     * @param size   the size of the scene entity
     * @param image  the image of the scene entity
     */
    public SceneEntity2d(double mass, Motion2d motion, Dimension2d size, BufferedImage image) {
        super(mass, motion, size);
        this.image = image;
    }

    /**
     * Returns the image which graphically represents the scene entity within a scene.
     *
     * @return the display image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Updates the image which is displayed at the scene entities coordinates.
     *
     * @param image the display image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Renders the scene entity at the specified offset.
     *
     * @param graphics the graphics context
     * @param dx       the x-offset
     * @param dy       the y-offset
     */
    public void render(Graphics graphics, int dx, int dy) {
        Cartesian2d position = getMotion().getPosition();
        if (position == null)
            return;
        Dimension2d size = getSize();
        if (size == null)
            return;
        int x = (int) Math.round(position.getX()) - dx;
        int y = (int) Math.round(position.getY()) - dy;
        int width = (int) Math.round(size.getWidth());
        int height = (int) Math.round(size.getHeight());
        graphics.setClip(x, y, width, height);
        Image image = getImage();
        graphics.drawImage(image, x, y, null);
    }
}
