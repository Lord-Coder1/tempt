package com.iancaffey.tempt.coordinate;

/**
 * Polar2d
 * <p>
 * A representation of a coordinate in 3-dimensional polar coordinate space.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Polar3d {
    private final double radius;
    private final double theta;
    private final double phi;

    /**
     * Constructs a new {@code Polar3d} with 0 radius, theta, and phi.
     */
    public Polar3d() {
        this(0, 0, 0);
    }

    /**
     * Constructs a new {@code Polar3d} with specified radius and angles.
     *
     * @param radius the radius
     * @param theta  the angle theta
     * @param phi    the angle phi
     */
    public Polar3d(double radius, double theta, double phi) {
        this.radius = radius;
        this.theta = theta;
        this.phi = phi;
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
     * Returns the angle theta of the coordinate.
     *
     * @return the coordinate angle theta
     */
    public double getTheta() {
        return theta;
    }

    /**
     * Returns the angle phi of the coordinate.
     *
     * @return the coordinate angle phi
     */
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

    @Override
    public String toString() {
        return String.format("%s[radius=%s, theta=%s, phi=%s]", getClass().getCanonicalName(), getRadius(), getTheta(), getPhi());
    }
}
