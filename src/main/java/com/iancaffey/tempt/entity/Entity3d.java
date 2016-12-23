package com.iancaffey.tempt.entity;

import com.iancaffey.tempt.coordinate.Cartesian3d;
import com.iancaffey.tempt.coordinate.Vector3d;
import com.iancaffey.tempt.math.Dimension3d;
import com.iancaffey.tempt.math.Motion3d;

/**
 * Entity3d
 * <p>
 * A representation of an entity which has mass and motion in 3-dimensions.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Entity3d extends Entity {
    private final Motion3d motion;
    private final Dimension3d size;

    /**
     * Constructs a new {@code Entity2d} with specified mass and size.
     * <p>
     * The entity will begin stationary, having 0 motion.
     *
     * @param mass the mass
     * @param size the size
     */
    public Entity3d(double mass, Dimension3d size) {
        this(mass, new Motion3d(), size);
    }

    /**
     * Constructs a new {@code Entity2d} with specified mass, motion, and size.
     *
     * @param mass   the mass
     * @param motion the motion
     * @param size   the size
     */
    public Entity3d(double mass, Motion3d motion, Dimension3d size) {
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
    public Motion3d getMotion() {
        return motion;
    }

    /**
     * Returns the size of the entity.
     *
     * @return the entity size
     */
    public Dimension3d getSize() {
        return size;
    }

    /**
     * Returns the position of the entity.
     *
     * @return the entity position
     */
    public Cartesian3d getPosition() {
        return getMotion().getPosition();
    }

    /**
     * Updates the position of the entity.
     *
     * @param position the entity position
     */
    public void setPosition(Cartesian3d position) {
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
     * Updates the position of the entity.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     */
    public void setPosition(double x, double y, double z) {
        getMotion().setPosition(x, y, z);
    }

    /**
     * Returns the velocity of the entity.
     *
     * @return the entity velocity
     */
    public Vector3d getVelocity() {
        return getMotion().getVelocity();
    }

    /**
     * Updates the velocity of the entity.
     *
     * @param velocity the entity velocity
     */
    public void setVelocity(Vector3d velocity) {
        getMotion().setVelocity(velocity);
    }

    /**
     * Updates the velocity of the entity.
     * <p>
     * The z component defaults to 0.
     *
     * @param x the x component of velocity
     * @param y the y component of velocity
     */
    public void setVelocity(double x, double y) {
        getMotion().setVelocity(x, y);
    }

    /**
     * Updates the velocity of the entity.
     *
     * @param x the x component of velocity
     * @param y the y component of velocity
     * @param z the z component of velocity
     */
    public void setVelocity(double x, double y, double z) {
        getMotion().setVelocity(x, y, z);
    }

    /**
     * Returns the acceleration of the entity.
     *
     * @return the entity acceleration
     */
    public Vector3d getAcceleration() {
        return getMotion().getAcceleration();
    }

    /**
     * Updates the acceleration of the entity.
     *
     * @param acceleration the entity acceleration
     */
    public void setAcceleration(Vector3d acceleration) {
        getMotion().setAcceleration(acceleration);
    }

    /**
     * Updates the acceleration of the entity.
     * <p>
     * The z component defaults to 0.
     *
     * @param x the x component of acceleration
     * @param y the y component of acceleration
     */
    public void setAcceleration(double x, double y) {
        getMotion().setAcceleration(x, y);
    }

    /**
     * Updates the acceleration of the entity.
     *
     * @param x the x component of acceleration
     * @param y the y component of acceleration
     * @param z the z component of acceleration
     */
    public void setAcceleration(double x, double y, double z) {
        getMotion().setAcceleration(x, y, z);
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
        return o instanceof Entity3d && getMass() == ((Entity3d) o).getMass() && getMotion().equals(((Entity3d) o).getMotion()) && getSize().equals(((Entity3d) o).getSize());
    }

    @Override
    public String toString() {
        return String.format("%s[mass=%s, motion=%s, size=%s]", getClass().getCanonicalName(), getMass(), getMotion(), getSize());
    }
}
