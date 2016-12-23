package com.iancaffey.tempt.shape;

import com.iancaffey.tempt.coordinate.Cartesian2d;
import com.iancaffey.tempt.util.Coordinate;

/**
 * Circle
 * <p>
 * A representation of a circle represented in cartesian coordinates.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Circle implements Shape2d {
    private final double x;
    private final double y;
    private final double radius;

    /**
     * Constructs a new {@code Circle} with specified center and radius.
     *
     * @param center the center coordinate
     * @param radius the radius of the circle
     */
    public Circle(Cartesian2d center, double radius) {
        this(center.getX(), center.getY(), radius);
    }

    /**
     * Constructs a new {@code Circle} with specified center and radius.
     *
     * @param x      the center x-coordinate
     * @param y      the center y-coordinate
     * @param radius the radius of the circle
     */
    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
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
     * Returns the radius.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns whether the circle contains the specified coordinate.
     *
     * @param coordinate the coordinate to check
     * @return {@code true} if the cicle absolutely contains the specified coordinate
     */
    @Override
    public boolean contains(Cartesian2d coordinate) {
        return coordinate != null && contains(coordinate.getX(), coordinate.getY());
    }

    /**
     * Returns whether the circle contains the specified coordinate.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return {@code true} if the cicle absolutely contains the specified coordinate
     */
    @Override
    public boolean contains(double x, double y) {
        return Coordinate.distance(getX(), getY(), x, y) < getRadius();
    }

    @Override
    public int hashCode() {
        long bits = 7L;
        bits = 31L * bits + Double.doubleToLongBits(getX());
        bits = 31L * bits + Double.doubleToLongBits(getY());
        bits = 31L * bits + Double.doubleToLongBits(getRadius());
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Circle && getX() == ((Circle) o).getX() && getY() == ((Circle) o).getY() && getRadius() == ((Circle) o).getRadius();
    }

    @Override
    public String toString() {
        return String.format("%s[x=%s, y=%s, radius=%s]", getClass().getCanonicalName(), getX(), getY(), getRadius());
    }
}
