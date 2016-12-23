package com.iancaffey.tempt.math;

import com.iancaffey.tempt.coordinate.Cartesian2d;
import com.iancaffey.tempt.coordinate.Cartesian3d;
import com.iancaffey.tempt.coordinate.Vector2d;
import com.iancaffey.tempt.coordinate.Vector3d;

import java.util.Objects;

/**
 * Motion2d
 * <p>
 * A representation of motion in 2-dimensions, providing position, velocity, and acceleration.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Motion2d {
    private Cartesian2d position;
    private Vector2d velocity;
    private Vector2d acceleration;

    /**
     * Constructs a new {@code Motion2d} with at the origin, with no velocity or acceleration.
     */
    public Motion2d() {
        this(new Cartesian2d(0, 0), new Vector2d(0, 0), new Vector2d(0, 0));
    }

    /**
     * Constructs a new {@code Motion2d} representing a copy of the specified motion.
     *
     * @param movement the movement
     */
    public Motion2d(Motion2d movement) {
        if (movement == null)
            throw new IllegalArgumentException();
        this.position = movement.getPosition();
        this.velocity = movement.getVelocity();
        this.acceleration = movement.getAcceleration();
    }

    /**
     * Constructs a new {@code Motion2d} representing a copy of the specified motion.
     * <p>
     * All z components are ignored when copying the specified motion.
     *
     * @param movement the movement
     */
    public Motion2d(Motion3d movement) {
        if (movement == null)
            throw new IllegalArgumentException();
        Cartesian3d location = movement.getPosition();
        Vector3d velocity = movement.getVelocity();
        Vector3d acceleration = movement.getAcceleration();
        this.position = location == null ? null : new Cartesian2d(location);
        this.velocity = velocity == null ? null : new Vector2d(velocity);
        this.acceleration = acceleration == null ? null : new Vector2d(acceleration);
    }

    /**
     * Constructs a new {@code Motion2d} with specified position, velocity, and acceleration.
     *
     * @param position     the position
     * @param velocity     the velocity
     * @param acceleration the acceleration
     */
    public Motion2d(Cartesian2d position, Vector2d velocity, Vector2d acceleration) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    /**
     * Returns the position component of the motion.
     *
     * @return the motion's position component
     */
    public Cartesian2d getPosition() {
        return position;
    }

    /**
     * Updates the position component of the motion.
     *
     * @param position the coordinate
     */
    public void setPosition(Cartesian2d position) {
        this.position = position;
    }

    /**
     * Updates the position component of the motion.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public void setPosition(double x, double y) {
        setPosition(new Cartesian2d(x, y));
    }

    /**
     * Returns the velocity component of the motion.
     *
     * @return the motion's velocity component
     */
    public Vector2d getVelocity() {
        return velocity;
    }

    /**
     * Updates the velocity component of the motion.
     *
     * @param velocity the velocity
     */
    public void setVelocity(Vector2d velocity) {
        this.velocity = velocity;
    }

    /**
     * Updates the velocity component of the motion.
     *
     * @param x the x component of the velocity
     * @param y the y component of the velocity
     */
    public void setVelocity(double x, double y) {
        setVelocity(new Vector2d(x, y));
    }

    /**
     * Returns the acceleration component of the motion.
     *
     * @return the motion's acceleration component
     */
    public Vector2d getAcceleration() {
        return acceleration;
    }

    /**
     * Updates the acceleration component of the motion.
     *
     * @param acceleration the acceleration
     */
    public void setAcceleration(Vector2d acceleration) {
        this.acceleration = acceleration;
    }

    /**
     * Updates the acceleration component of the motion.
     *
     * @param x the x component of the acceleration
     * @param y the y component of the acceleration
     */
    public void setAcceleration(double x, double y) {
        setAcceleration(new Vector2d(x, y));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition(), getVelocity(), getAcceleration());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Motion2d && Objects.equals(getPosition(), ((Motion2d) o).getPosition()) &&
                Objects.equals(getVelocity(), ((Motion2d) o).getVelocity()) &&
                Objects.equals(getAcceleration(), ((Motion2d) o).getAcceleration());
    }

    @Override
    public String toString() {
        return String.format("%s[position=%s, velocity=%s, acceleration=%s]",
                getClass().getCanonicalName(), getPosition(), getVelocity(), getAcceleration());
    }
}
