package com.iancaffey.tempt.math;

/**
 * Polar2d
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Polar3d {
    private final double theta;
    private final double phi;
    private final double radius;

    public Polar3d() {
        this(0, 0, 0);
    }

    public Polar3d(double radius, double theta, double phi) {
        this.radius = radius;
        this.theta = theta;
        this.phi = phi;
    }

    public double getRadius() {
        return radius;
    }

    public double getTheta() {
        return theta;
    }

    public double getPhi() {
        return phi;
    }

    @Override
    public int hashCode() {
        long bits = 7L;
        bits = 31L * bits + Double.doubleToLongBits(getRadius());
        bits = 31L * bits + Double.doubleToLongBits(getTheta());
        bits = 31L * bits + Double.doubleToLongBits(getPhi());
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Polar3d && getRadius() == ((Polar3d) o).getRadius() && getTheta() == ((Polar3d) o).getTheta() && getPhi() == ((Polar3d) o).getPhi();
    }
}
