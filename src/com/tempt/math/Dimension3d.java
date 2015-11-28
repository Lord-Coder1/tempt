package com.tempt.math;

/**
 * Dimension3d
 *
 * @author Ian
 * @version 1.0
 */
public class Dimension3d {
    private final double width;
    private final double height;
    private final double depth;

    public Dimension3d(double width, double height, double depth) {
        if (width < 0 || height < 0 || depth < 0)
            throw new IllegalArgumentException();
        this.width = width;
        this.height = height;
        this.depth = depth;
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

    public boolean contains(Cartesian2d point) {
        return point != null && contains(point.getX(), point.getY(), 0);
    }

    public boolean contains(Cartesian3d point) {
        return point != null && contains(point.getX(), point.getY(), point.getZ());
    }

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

}
