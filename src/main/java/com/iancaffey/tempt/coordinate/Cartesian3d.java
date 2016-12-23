package com.iancaffey.tempt.coordinate;

/**
 * Cartesian3d
 * <p>
 * A representation of a 3-dimensional coordinate in the cartesian space.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Cartesian3d {
    public static final Cartesian3d ORIGIN = new Cartesian3d(0, 0);
    private final double x;
    private final double y;
    private final double z;

    /**
     * Constructs a new {@code Cartesian3d} at 0,0,0.
     */
    public Cartesian3d() {
        this(0, 0);
    }

    /**
     * Constructs a new {@code Cartesian3d} representing a copy of the specified coordinate.
     * <p>
     * The z-coordinate is set to 0.
     *
     * @param coordinate the specified coordinate to copy
     */
    public Cartesian3d(Cartesian2d coordinate) {
        this(coordinate.getX(), coordinate.getY());
    }

    /**
     * Constructs a new {@code Cartesian3d} representing a copy of the specified coordinate.
     *
     * @param coordinate the specified coordinate to copy
     */
    public Cartesian3d(Cartesian3d coordinate) {
        this(coordinate.getX(), coordinate.getY(), coordinate.getZ());
    }

    /**
     * Constructs a new {@code Cartesian3d} with specified x and y coordinates.
     * <p>
     * The z-coordinate is set to 0.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Cartesian3d(double x, double y) {
        this(x, y, 0);
    }

    /**
     * Constructs a new {@code Cartesian3d} with specified x, y, and z coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     */
    public Cartesian3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns the x-coordinate.
     *
     * @return the x-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return the y-coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the z-coordinate.
     *
     * @return the z-coordinate
     */
    public double getZ() {
        return z;
    }

    @Override
    public int hashCode() {
        long bits = 7L;
        bits = 31L * bits + Double.doubleToLongBits(getX());
        bits = 31L * bits + Double.doubleToLongBits(getY());
        bits = 31L * bits + Double.doubleToLongBits(getZ());
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Cartesian3d && getX() == ((Cartesian3d) o).getX() && getY() == ((Cartesian3d) o).getY() && getZ() == ((Cartesian3d) o).getZ();
    }

    @Override
    public String toString() {
        return String.format("%s[x=%s, y=%s, z=%s]", getClass().getCanonicalName(), getX(), getY(), getZ());
    }
}
