package com.tempt.math;

/**
 * Rectangle
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

    public RectangularPrism(double width, double height, double depth) {
        this(Cartesian3d.ORIGIN, width, height, depth);
    }

    public RectangularPrism(Cartesian3d base, double width, double height, double depth) {
        this(base.getX(), base.getY(), base.getZ(), width, height, depth);
    }

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

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getMaxZ() {
        return maxZ;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getCenterZ() {
        return centerZ;
    }

    @Override
    public boolean contains(Cartesian2d point) {
        return point != null && contains(point.getX(), point.getY(), 0);
    }

    @Override
    public boolean contains(Cartesian3d point) {
        return point != null && contains(point.getX(), point.getY(), point.getZ());
    }

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

}
