package com.iancaffey.tempt.shape;

import com.iancaffey.tempt.coordinate.Cartesian2d;
import com.iancaffey.tempt.coordinate.Cartesian3d;

/**
 * Rectangle
 * <p>
 * A representation of a 3-dimensional rectangular shape.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RectangularPrism implements Shape3d {
    private final double x;
    private final double y;
    private final double z;
    private final double width;
    private final double height;
    private final double depth;
    private final double maxX;
    private final double maxY;
    private final double maxZ;
    private final double centerX;
    private final double centerY;
    private final double centerZ;

    /**
     * Constructs a new {@code RectangularPrism} at the origin with specified width, height, and depth.
     *
     * @param width  the width
     * @param height the height
     * @param depth  the depth
     */
    public RectangularPrism(double width, double height, double depth) {
        this(Cartesian3d.ORIGIN, width, height, depth);
    }

    /**
     * Constructs a new {@code RectangularPrism} with specified base coordinate and dimension.
     *
     * @param base   the base coordinate
     * @param width  the width
     * @param height the height
     * @param depth  the depth
     */
    public RectangularPrism(Cartesian3d base, double width, double height, double depth) {
        this(base.getX(), base.getY(), base.getZ(), width, height, depth);
    }

    /**
     * Constructs a new {@code Rectangle} with specified coordinates and dimension.
     *
     * @param x      the x-coordinate
     * @param y      the y-coordinate
     * @param z      the z-coordinate
     * @param width  the width
     * @param height the height
     * @param depth  the depth
     */
    public RectangularPrism(double x, double y, double z, double width, double height, double depth) {
        if (width < 0 || height < 0 || depth < 0)
            throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.maxX = x + width;
        this.maxY = y + height;
        this.maxZ = z + depth;
        this.centerX = x + (width / 2.0d);
        this.centerY = y + (height / 2.0d);
        this.centerZ = z + (depth / 2.0d);
    }

    /**
     * Returns the x-coordinate.
     *
     * @return the x-coordinate
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return the y-coordinate
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * Returns the z-coordinate.
     *
     * @return the z-coordinate
     */
    @Override
    public double getZ() {
        return z;
    }

    /**
     * Returns the width of the rectangular prism.
     *
     * @return the rectangular prism width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns the height of the rectangular prism.
     *
     * @return the rectangular prism height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the depth of the rectangular prism.
     *
     * @return the rectangular prism depth
     */
    public double getDepth() {
        return depth;
    }

    /**
     * Returns the maximum x-coordinate of the rectangular prism.
     *
     * @return the rectangular prism maximum x-coordinate
     */
    public double getMaxX() {
        return maxX;
    }

    /**
     * Returns the maximum y-coordinate of the rectangular prism.
     *
     * @return the rectangular prism maximum y-coordinate
     */
    public double getMaxY() {
        return maxY;
    }

    /**
     * Returns the maximum z-coordinate of the rectangular prism.
     *
     * @return the rectangular prism maximum z-coordinate
     */
    public double getMaxZ() {
        return maxZ;
    }

    /**
     * Returns the center x-coordinate of the rectangular prism.
     *
     * @return the rectangular prism center x-coordinate
     */
    public double getCenterX() {
        return centerX;
    }

    /**
     * Returns the center y-coordinate of the rectangular prism.
     *
     * @return the rectangular prism center y-coordinate
     */
    public double getCenterY() {
        return centerY;
    }

    /**
     * Returns the center z-coordinate of the rectangular prism.
     *
     * @return the rectangular prism center z-coordinate
     */
    public double getCenterZ() {
        return centerZ;
    }

    /**
     * Returns whether the rectangular prism contains the specified coordinate.
     *
     * @param coordinate the coordinate to check
     * @return {@code true} if the rectangular prism absolutely contains the specified coordinate
     */
    @Override
    public boolean contains(Cartesian2d coordinate) {
        return coordinate != null && contains(coordinate.getX(), coordinate.getY(), 0);
    }

    /**
     * Returns whether the rectangular prism contains the specified coordinate.
     *
     * @param coordinate the coordinate to check
     * @return {@code true} if the rectangular prism absolutely contains the specified coordinate
     */
    @Override
    public boolean contains(Cartesian3d coordinate) {
        return coordinate != null && contains(coordinate.getX(), coordinate.getY(), coordinate.getZ());
    }

    /**
     * Returns whether the rectangular prism contains the specified coordinate.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     * @return {@code true} if the rectangular prism absolutely contains the specified coordinate
     */
    @Override
    public boolean contains(double x, double y, double z) {
        return x >= getX() && x < getMaxX() && y >= getY() && y < getMaxY() && z >= getZ() && z < getMaxZ();
    }

    @Override
    public int hashCode() {
        long bits = 7L;
        bits = 31L * bits + Double.doubleToLongBits(getX());
        bits = 31L * bits + Double.doubleToLongBits(getY());
        bits = 31L * bits + Double.doubleToLongBits(getZ());
        bits = 31L * bits + Double.doubleToLongBits(getWidth());
        bits = 31L * bits + Double.doubleToLongBits(getHeight());
        bits = 31L * bits + Double.doubleToLongBits(getDepth());
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof RectangularPrism &&
                getX() == ((RectangularPrism) o).getX() &&
                getY() == ((RectangularPrism) o).getY() &&
                getZ() == ((RectangularPrism) o).getZ() &&
                getWidth() == ((RectangularPrism) o).getWidth() &&
                getHeight() == ((RectangularPrism) o).getHeight() &&
                getDepth() == ((RectangularPrism) o).getDepth();
    }

    @Override
    public String toString() {
        return String.format("%s[x=%s, y=%s, z=%s, width=%s, height=%s, depth=%s]",
                getClass().getCanonicalName(), getX(), getY(), getZ(), getWidth(), getHeight(), getDepth());
    }
}
