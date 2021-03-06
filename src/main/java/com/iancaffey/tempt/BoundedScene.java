package com.iancaffey.tempt;

import com.iancaffey.tempt.math.Dimension2d;
import com.iancaffey.tempt.shape.Rectangle;

import java.util.Arrays;

/**
 * BoundedScene
 * <p>
 * A representation of a bounded scene composed of scene entities surrounded by walls on all four sides.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BoundedScene extends Scene {
    private final SceneEntity2d[] walls;

    /**
     * Constructs a new {@code BoundedScene} with specified bounds.
     *
     * @param x      the x-coordinate
     * @param y      the y-coordinate
     * @param width  the width
     * @param height the height
     */
    public BoundedScene(double x, double y, double width, double height) {
        super(x, y, width, height);
        double halfHeight = height / 2.0d;
        double halfWidth = width / 2.0d;
        this.walls = new SceneEntity2d[]{new SceneEntity2d(Double.MAX_VALUE, new Dimension2d(halfWidth, height)),
                new SceneEntity2d(Double.MAX_VALUE, new Dimension2d(width, halfHeight)),
                new SceneEntity2d(Double.MAX_VALUE, new Dimension2d(halfWidth, height)),
                new SceneEntity2d(Double.MAX_VALUE, new Dimension2d(width, halfHeight))};
        walls[0].setPosition(x - halfWidth, y);
        walls[1].setPosition(x, y - halfHeight);
        walls[2].setPosition(x + width, 0);
        walls[3].setPosition(0, y + height);
        add(walls);

    }

    /**
     * Constructs a new {@code BoundedScene} with specified bounds.
     *
     * @param bounds the scene bounds
     */
    public BoundedScene(Rectangle bounds) {
        super(bounds);
        double x = bounds.getX();
        double y = bounds.getY();
        double width = bounds.getWidth();
        double height = bounds.getHeight();
        double halfHeight = height / 2.0d;
        double halfWidth = width / 2.0d;
        this.walls = new SceneEntity2d[]{new SceneEntity2d(Double.MAX_VALUE, new Dimension2d(halfWidth, height)),
                new SceneEntity2d(Double.MAX_VALUE, new Dimension2d(width, halfHeight)),
                new SceneEntity2d(Double.MAX_VALUE, new Dimension2d(halfWidth, height)),
                new SceneEntity2d(Double.MAX_VALUE, new Dimension2d(width, halfHeight))};
        walls[0].setPosition(x - halfWidth, y);
        walls[1].setPosition(x, y - halfHeight);
        walls[2].setPosition(x + width, 0);
        walls[3].setPosition(0, y + height);
        add(walls);
    }

    /**
     * Returns the enclosing walls for the scene.
     *
     * @return the enclosing walls
     */
    public SceneEntity2d[] getWalls() {
        return Arrays.copyOf(walls, walls.length);
    }
}
