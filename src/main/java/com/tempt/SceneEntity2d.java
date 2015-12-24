package com.tempt;

import com.tempt.math.Cartesian2d;
import com.tempt.math.Dimension2d;
import com.tempt.math.Entity2d;
import com.tempt.math.Motion2d;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * SceneEntity2d
 *
 * @author Ian
 * @version 1.0
 */
public class SceneEntity2d extends Entity2d {
    private BufferedImage image;

    public SceneEntity2d(double mass, Dimension2d size) {
        super(mass, size);
    }

    public SceneEntity2d(double mass, Motion2d motion, Dimension2d size) {
        super(mass, motion, size);
    }

    public SceneEntity2d(double mass, Dimension2d size, BufferedImage image) {
        super(mass, size);
        this.image = image;
    }

    public SceneEntity2d(double mass, Motion2d motion, Dimension2d size, BufferedImage image) {
        super(mass, motion, size);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

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
