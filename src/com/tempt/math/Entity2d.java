package com.tempt.math;

/**
 * Entity2d
 *
 * @author Ian
 * @version 1.0
 */
public class Entity2d extends Entity {
    private final Motion2d motion;
    private final Dimension2d size;

    public Entity2d(double mass, Dimension2d size) {
        this(mass, new Motion2d(), size);
    }

    public Entity2d(double mass, Motion2d motion, Dimension2d size) {
        super(mass);
        if (motion == null || size == null)
            throw new IllegalArgumentException();
        this.motion = motion;
        this.size = size;
    }

    public Motion2d getMotion() {
        return motion;
    }

    public Dimension2d getSize() {
        return size;
    }

    public Cartesian2d getPosition() {
        return getMotion().getPosition();
    }

    public void setPosition(Cartesian2d position) {
        getMotion().setPosition(position);
    }

    public void setPosition(double x, double y) {
        getMotion().setPosition(x, y);
    }

    public Vector2d getVelocity() {
        return getMotion().getVelocity();
    }

    public void setVelocity(Vector2d velocity) {
        getMotion().setVelocity(velocity);
    }

    public void setVelocity(double x, double y) {
        getMotion().setVelocity(x, y);
    }

    public Vector2d getAcceleration() {
        return getMotion().getAcceleration();
    }

    public void setAcceleration(Vector2d acceleration) {
        getMotion().setAcceleration(acceleration);
    }

    public void setAcceleration(double x, double y) {
        getMotion().setAcceleration(x, y);
    }

    @Override
    public int hashCode() {
        long bits = 7L;
        bits = 31L * bits + Double.doubleToLongBits(getMass());
        bits = 31L * bits + getMotion().hashCode();
        bits = 31L * bits + getSize().hashCode();
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Entity2d && getMass() == ((Entity2d) o).getMass() && getMotion().equals(((Entity2d) o).getMotion()) && getSize().equals(((Entity2d) o).getSize());
    }
}
