package iitc.physics;

/**
 * Motion3d
 *
 * @author Ian
 * @version 1.0
 */
public class Motion3d {
    private Vector3d location;
    private Vector3d velocity;
    private Vector3d acceleration;

    public Motion3d() {
        this(new Vector3d(0, 0), new Vector3d(0, 0), new Vector3d(0, 0));
    }

    public Motion3d(Motion2d movement) {
        if (movement == null)
            throw new IllegalArgumentException();
        Vector2d location = movement.getLocation();
        Vector2d velocity = movement.getVelocity();
        Vector2d acceleration = movement.getAcceleration();
        this.location = location == null ? null : new Vector3d(location);
        this.velocity = velocity == null ? null : new Vector3d(velocity);
        this.acceleration = acceleration == null ? null : new Vector3d(acceleration);
    }

    public Motion3d(Motion3d movement) {
        if (movement == null)
            throw new IllegalArgumentException();
        this.location = movement.getLocation();
        this.velocity = movement.getVelocity();
        this.acceleration = movement.getAcceleration();
    }

    public Motion3d(Vector3d location, Vector3d velocity, Vector3d acceleration) {
        this.location = location;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public Vector3d getLocation() {
        return location;
    }

    public void setLocation(Vector3d location) {
        this.location = location;
    }

    public Vector3d getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector3d velocity) {
        this.velocity = velocity;
    }

    public Vector3d getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector3d acceleration) {
        this.acceleration = acceleration;
    }
}
