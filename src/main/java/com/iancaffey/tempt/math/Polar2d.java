package com.iancaffey.tempt.math;

/**
 * Polar2d
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Polar2d {
    private final double radius;
    private final double theta;

    public Polar2d() {
        this(0, 0);
    }

    public Polar2d(double radius, double theta) {
        this.theta = theta;
        this.radius = radius;
    }

    public double getTheta() {
        return theta;
    }

    public double getRadius() {
        return radius;
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
