package com.tempt.math;

/**
 * Motion3d
 *
 * @author Ian
 * @version 1.0
 */
public class Motion3d {
    private Cartesian3d position;
    private Vector3d velocity;
    private Vector3d acceleration;

    public Motion3d() {
        this(new Cartesian3d(0, 0), new Vector3d(0, 0), new Vector3d(0, 0));
    }

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

    public Motion3d(Motion3d movement) {
        if (movement == null)
            throw new IllegalArgumentException();
        this.position = movement.getPosition();
        this.velocity = movement.getVelocity();
        this.acceleration = movement.getAcceleration();
    }

    public Motion3d(Cartesian3d position, Vector3d velocity, Vector3d acceleration) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public Cartesian3d getPosition() {
        return position;
    }

    public void setPosition(Cartesian3d position) {
        this.position = position;
    }

    public void setPosition(double x, double y) {
        setPosition(new Cartesian3d(x, y));
    }

    public void setPosition(double x, double y, double z) {
        setPosition(new Cartesian3d(x, y, z));
    }

    public Vector3d getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector3d velocity) {
        this.velocity = velocity;
    }

    public void setVelocity(double x, double y) {
        setVelocity(new Vector3d(x, y));
    }

    public void setVelocity(double x, double y, double z) {
        setVelocity(new Vector3d(x, y, z));
    }

    public Vector3d getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector3d acceleration) {
        this.acceleration = acceleration;
    }

    public void setAcceleration(double x, double y) {
        setAcceleration(new Vector3d(x, y));
    }

    public void setAcceleration(double x, double y, double z) {
        setAcceleration(new Vector3d(x, y, z));
    }
}
