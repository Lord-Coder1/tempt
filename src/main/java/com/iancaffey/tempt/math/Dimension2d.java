package com.iancaffey.tempt.math;

import com.iancaffey.tempt.coordinate.Cartesian2d;

/**
 * Dimension2d
 * <p>
 * A representation of a bounding box in 2-dimensions.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Dimension2d {
    private final double width;
    private final double height;

    /**
     * Constructs a new {@code Dimension2d} with specified width and height.
     *
     * @param width  the width
     * @param height the height
     */
    public Dimension2d(double width, double height) {
        if (width < 0 || height < 0)
            throw new IllegalArgumentException();
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the width of the bounding box.
     *
     * @return the bounding box width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns the height of the bounding box.
     *
     * @return the bounding box height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns whether the bounding box contains the coordinate.
     *
     * @param coordinate the coordinate to check
     * @return {@code true} if the bounding box contains the coordinate
     */
    public boolean contains(Cartesian2d coordinate) {
        return coordinate != null && contains(coordinate.getX(), coordinate.getY());
    }

    /**
     * Returns whether the bounding box contains the coordinate.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return {@code true} if the bounding box contains the coordinate
     */
    public boolean contains(double x, double y) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
    }

    /**
     * Returns whether the bounding box contains the specified bounding box.
     *
     * @param x      the x-coordinate
     * @param y      the y-coordinate
     * @param width  the bounding box width
     * @param height the bounding box height
     * @return {@code true} if the bounding box contains the bounding box
     */
    public boolean contains(double x, double y, double width, double height) {
        double dw = this.width;
        double dh = this.height;
        double dx = 0;
        double dy = 0;
        if (x < dx || y < dy)
            return false;
        dw += dx;
        width += x;
        if (width <= x) {
            if (dw >= dx || width > dw) return false;
        } else {
            if (dw >= dx && width > dw) return false;
        }
        dh += dy;
        height += y;
        if (height <= y) {
            if (dh >= dy || height > dh) return false;
        } else {
            if (dh >= dy && height > dh) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(getWidth());
        bits ^= Double.doubleToLongBits(getHeight()) * 31;
        return (((int) bits) ^ ((int) (bits >> 32)));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Dimension2d &&
                getWidth() == ((Dimension2d) o).getWidth() &&
                getHeight() == ((Dimension2d) o).getHeight();
    }

    @Override
    public String toString() {
        return String.format("%s[width=%s, height=%s]", getClass().getCanonicalName(), getWidth(), getHeight());
    }
}
