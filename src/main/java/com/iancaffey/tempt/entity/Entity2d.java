package com.iancaffey.tempt.entity;

import com.iancaffey.tempt.coordinate.Cartesian2d;
import com.iancaffey.tempt.coordinate.Vector2d;
import com.iancaffey.tempt.math.Dimension2d;
import com.iancaffey.tempt.math.Motion2d;

/**
 * Entity2d
 * <p>
 * A representation of an entity which has mass and motion in 2-dimensions.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Entity2d extends Entity {
    private final Motion2d motion;
    private final Dimension2d size;

    /**
     * Constructs a new {@code Entity2d} with specified mass and size.
     * <p>
     * The entity will begin stationary, having 0 motion.
     *
     * @param mass the mass
     * @param size the size
     */
    public Entity2d(double mass, Dimension2d size) {
        this(mass, new Motion2d(), size);
    }

    /**
     * Constructs a new {@code Entity2d} with specified mass, motion, and size.
     *
     * @param mass   the mass
     * @param motion the motion
     * @param size   the size
     */
    public Entity2d(double mass, Motion2d motion, Dimension2d size) {
        super(mass);
        if (motion == null || size == null)
            throw new IllegalArgumentException();
        this.motion = motion;
        this.size = size;
    }

    /**
     * Returns the current motion of the entity.
     *
     * @return the entity motion
     */
    public Motion2d getMotion() {
        return motion;
    }

    /**
     * Returns the size of the entity.
     *
     * @return the entity size
     */
    public Dimension2d getSize() {
        return size;
    }

    /**
     * Returns the position of the entity.
     *
     * @return the entity position
     */
    public Cartesian2d getPosition() {
        return getMotion().getPosition();
    }

    /**
     * Updates the position of the entity.
     *
     * @param position the entity position
     */
    public void setPosition(Cartesian2d position) {
        getMotion().setPosition(position);
    }

    /**
     * Updates the position of the entity.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public void setPosition(double x, double y) {
        getMotion().setPosition(x, y);
    }

    /**
     * Returns the velocity of the entity.
     *
     * @return the entity velocity
     */
    public Vector2d getVelocity() {
        return getMotion().getVelocity();
    }

    /**
     * Updates the velocity of the entity.
     *
     * @param velocity the entity velocity
     */
    public void setVelocity(Vector2d velocity) {
        getMotion().setVelocity(velocity);
    }

    /**
     * Updates the velocity of the entity.
     *
     * @param x the x component of velocity
     * @param y the y component of velocity
     */
    public void setVelocity(double x, double y) {
        getMotion().setVelocity(x, y);
    }

    /**
     * Returns the acceleration of the entity.
     *
     * @return the entity acceleration
     */
    public Vector2d getAcceleration() {
        return getMotion().getAcceleration();
    }

    /**
     * Updates the acceleration of the entity.
     *
     * @param acceleration the entity acceleration
     */
    public void setAcceleration(Vector2d acceleration) {
        getMotion().setAcceleration(acceleration);
    }

    /**
     * Updates the acceleration of the entity.
     *
     * @param x the x component of acceleration
     * @param y the y component of acceleration
     */
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

    @Override
    public String toString() {
        return String.format("%s[mass=%s, motion=%s, size=%s]", getClass().getCanonicalName(), getMass(), getMotion(), getSize());
    }
}
