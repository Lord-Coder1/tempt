package com.iancaffey.tempt.coordinate;

/**
 * Polar2d
 * <p>
 * A representation of a coordinate in 2-dimensional polar coordinate space.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Polar2d {
    private final double radius;
    private final double theta;

    /**
     * Constructs a new {@code Polar2d} with 0 radius and angle.
     */
    public Polar2d() {
        this(0, 0);
    }

    /**
     * Constructs a new {@code Polar2d} with specified radius and angle.
     *
     * @param radius the radius
     * @param theta  the angle
     */
    public Polar2d(double radius, double theta) {
        this.theta = theta;
        this.radius = radius;
    }

    /**
     * Returns the radius of the coordinate.
     *
     * @return the coordinate radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns the angle of the coordinate.
     *
     * @return the coordinate angle
     */
    public double getTheta() {
        return theta;
    }

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(getRadius());
        bits ^= Double.doubleToLongBits(getTheta()) * 31;
        return (((int) bits) ^ ((int) (bits >> 32)));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Polar2d && getRadius() == ((Polar2d) o).getRadius() && getTheta() == ((Polar2d) o).getTheta();
    }

    @Override
    public String toString() {
        return String.format("%s[radius=%s, theta=%s]", getClass().getCanonicalName(), getRadius(), getTheta());
    }
}
