package com.iancaffey.tempt.coordinate;

/**
 * Cartesian2d
 * <p>
 * A representation of a 2-dimensional coordinate in the cartesian space.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Cartesian2d {
    public static final Cartesian2d ORIGIN = new Cartesian2d(0, 0);
    private final double x;
    private final double y;

    /**
     * Constructs a new {@code Cartesian2d} at 0,0.
     */
    public Cartesian2d() {
        this(0, 0);
    }

    /**
     * Constructs a new {@code Cartesian2d} representing a copy of the specified coordinate.
     *
     * @param coordinate the specified coordinate to copy
     */
    public Cartesian2d(Cartesian2d coordinate) {
        this(coordinate.getX(), coordinate.getY());
    }

    /**
     * Constructs a new {@code Cartesian2d} representing a copy of the specified coordinate.
     * <p>
     * The z-coordinate is ignored from the specified coordinate.
     *
     * @param coordinate the specified coordinate to copy
     */
    public Cartesian2d(Cartesian3d coordinate) {
        this(coordinate.getX(), coordinate.getY());
    }

    /**
     * Constructs a new {@code Cartesian2d} with specified x and y coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Cartesian2d(double x, double y) {
        this.x = x;
        this.y = y;
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

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(getX());
        bits ^= Double.doubleToLongBits(getY()) * 31;
        return (((int) bits) ^ ((int) (bits >> 32)));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Cartesian2d && getX() == ((Cartesian2d) o).getX() && getY() == ((Cartesian2d) o).getY();
    }

    @Override
    public String toString() {
        return String.format("%s[x=%s, y=%s]", getClass().getCanonicalName(), getX(), getY());
    }
}
