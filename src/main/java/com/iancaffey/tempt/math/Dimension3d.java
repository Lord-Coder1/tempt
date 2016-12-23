package com.iancaffey.tempt.math;

import com.iancaffey.tempt.coordinate.Cartesian2d;
import com.iancaffey.tempt.coordinate.Cartesian3d;

/**
 * Dimension3d
 * <p>
 * A representation of a bounding cube in 3-dimensions.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Dimension3d {
    private final double width;
    private final double height;
    private final double depth;

    /**
     * Constructs a new {@code Dimension3d} with specified width, height, and depth.
     *
     * @param width  the width
     * @param height the height
     * @param depth  the depth
     */
    public Dimension3d(double width, double height, double depth) {
        if (width < 0 || height < 0 || depth < 0)
            throw new IllegalArgumentException();
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    /**
     * Returns the width of the bounding cube.
     *
     * @return the bounding cube width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns the height of the bounding cube.
     *
     * @return the bounding cube width
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the depth of the bounding cube.
     *
     * @return the bounding cube depth
     */
    public double getDepth() {
        return depth;
    }

    /**
     * Returns whether the bounding cube contains the coordinate.
     *
     * @param coordinate the coordinate to check
     * @return {@code true} if the bounding box contains the coordinate
     */
    public boolean contains(Cartesian2d coordinate) {
        return coordinate != null && contains(coordinate.getX(), coordinate.getY(), 0);
    }

    /**
     * Returns whether the bounding cube contains the coordinate.
     *
     * @param coordinate the coordinate to check
     * @return {@code true} if the bounding box contains the coordinate
     */
    public boolean contains(Cartesian3d coordinate) {
        return coordinate != null && contains(coordinate.getX(), coordinate.getY(), coordinate.getZ());
    }

    /**
     * Returns whether the bounding box contains the coordinate.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     * @return {@code true} if the bounding box contains the coordinate
     */
    public boolean contains(double x, double y, double z) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight() && z >= 0 && z < getDepth();
    }

    @Override
    public int hashCode() {
        long bits = 7L;
        bits = 31L * bits + Double.doubleToLongBits(getWidth());
        bits = 31L * bits + Double.doubleToLongBits(getHeight());
        bits = 31L * bits + Double.doubleToLongBits(getDepth());
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Dimension3d &&
                getWidth() == ((Dimension3d) o).getWidth() &&
                getHeight() == ((Dimension3d) o).getHeight() &&
                getDepth() == ((Dimension3d) o).getDepth();
    }

    @Override
    public String toString() {
        return String.format("%s[width=%s, height=%s, depth=%s]",
                getClass().getCanonicalName(), getWidth(), getHeight(), getDepth());
    }
}
