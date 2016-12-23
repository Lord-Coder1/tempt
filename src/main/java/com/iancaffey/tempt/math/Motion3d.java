package com.iancaffey.tempt.math;

import com.iancaffey.tempt.coordinate.Cartesian2d;
import com.iancaffey.tempt.coordinate.Cartesian3d;
import com.iancaffey.tempt.coordinate.Vector2d;
import com.iancaffey.tempt.coordinate.Vector3d;

import java.util.Objects;

/**
 * Motion3d
 * <p>
 * A representation of motion in 3-dimensions, providing position, velocity, and acceleration.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Motion3d {
    private Cartesian3d position;
    private Vector3d velocity;
    private Vector3d acceleration;

    /**
     * Constructs a new {@code Motion3d} with at the origin, with no velocity or acceleration.
     */
    public Motion3d() {
        this(new Cartesian3d(0, 0), new Vector3d(0, 0), new Vector3d(0, 0));
    }

    /**
     * Constructs a new {@code Motion3d} representing a copy of the specified motion.
     *
     * @param movement the movement
     */
    public Motion3d(Motion2d movement) {
        if (movement == null)
            throw new IllegalArgumentException();
        Cartesian2d location = movement.getPosition();
        Vector2d velocity = movement.getVelocity();
        Vector2d acceleration = movement.getAcceleration();
        this.position = location == null ? null : new Cartesian3d(location);
        this.velocity = velocity == null ? null : new Vector3d(velocity);
        this.acceleration = acceleration == null ? null : new Vector3d(acceleration);
    }

    /**
     * Constructs a new {@code Motion3d} representing a copy of the specified motion.
     *
     * @param movement the movement
     */
    public Motion3d(Motion3d movement) {
        if (movement == null)
            throw new IllegalArgumentException();
        this.position = movement.getPosition();
        this.velocity = movement.getVelocity();
        this.acceleration = movement.getAcceleration();
    }

    /**
     * Constructs a new {@code Motion3d} with specified position, velocity, and acceleration.
     *
     * @param position     the position
     * @param velocity     the velocity
     * @param acceleration the acceleration
     */
    public Motion3d(Cartesian3d position, Vector3d velocity, Vector3d acceleration) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    /**
     * Returns the position component of the motion.
     *
     * @return the motion's position component
     */
    public Cartesian3d getPosition() {
        return position;
    }

    /**
     * Updates the position component of the motion.
     *
     * @param position the coordinate
     */
    public void setPosition(Cartesian3d position) {
        this.position = position;
    }

    /**
     * Updates the position component of the motion.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public void setPosition(double x, double y) {
        setPosition(new Cartesian3d(x, y));
    }

    /**
     * Updates the position component of the motion.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param z the z-coordinate
     */
    public void setPosition(double x, double y, double z) {
        setPosition(new Cartesian3d(x, y, z));
    }

    /**
     * Returns the velocity component of the motion.
     *
     * @return the motion's velocity component
     */
    public Vector3d getVelocity() {
        return velocity;
    }

    /**
     * Updates the velocity component of the motion.
     *
     * @param velocity the velocity
     */
    public void setVelocity(Vector3d velocity) {
        this.velocity = velocity;
    }

    /**
     * Updates the velocity component of the motion.
     *
     * @param x the x component of the velocity
     * @param y the y component of the velocity
     */
    public void setVelocity(double x, double y) {
        setVelocity(new Vector3d(x, y));
    }

    /**
     * Updates the velocity component of the motion.
     *
     * @param x the x component of the velocity
     * @param y the y component of the velocity
     * @param z the z component of the velocity
     */
    public void setVelocity(double x, double y, double z) {
        setVelocity(new Vector3d(x, y, z));
    }

    /**
     * Returns the acceleration component of the motion.
     *
     * @return the motion's acceleration component
     */
    public Vector3d getAcceleration() {
        return acceleration;
    }

    /**
     * Updates the acceleration component of the motion.
     *
     * @param acceleration the acceleration
     */
    public void setAcceleration(Vector3d acceleration) {
        this.acceleration = acceleration;
    }

    /**
     * Updates the acceleration component of the motion.
     *
     * @param x the x component of the acceleration
     * @param y the y component of the acceleration
     */
    public void setAcceleration(double x, double y) {
        setAcceleration(new Vector3d(x, y));
    }

    /**
     * Updates the acceleration component of the motion.
     *
     * @param x the x component of the acceleration
     * @param y the y component of the acceleration
     * @param z the z component of the acceleration
     */
    public void setAcceleration(double x, double y, double z) {
        setAcceleration(new Vector3d(x, y, z));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition(), getVelocity(), getAcceleration());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Motion3d && Objects.equals(getPosition(), ((Motion3d) o).getPosition()) &&
                Objects.equals(getVelocity(), ((Motion3d) o).getVelocity()) &&
                Objects.equals(getAcceleration(), ((Motion3d) o).getAcceleration());
    }

    @Override
    public String toString() {
        return String.format("%s[position=%s, velocity=%s, acceleration=%s]",
                getClass().getCanonicalName(), getPosition(), getVelocity(), getAcceleration());
    }
}
