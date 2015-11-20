package iitc.physics;

/**
 * Motion2d
 *
 * @author Ian
 * @version 1.0
 */
public class Motion2d {
    private Vector2d location;
    private Vector2d velocity;
    private Vector2d acceleration;

    public Motion2d() {
        this(new Vector2d(0, 0), new Vector2d(0, 0), new Vector2d(0, 0));
    }

    public Motion2d(Motion2d movement) {
        if (movement == null)
            throw new IllegalArgumentException();
        this.location = movement.getLocation();
        this.velocity = movement.getVelocity();
        this.acceleration = movement.getAcceleration();
    }

    public Motion2d(Motion3d movement) {
        if (movement == null)
            throw new IllegalArgumentException();
        Vector3d location = movement.getLocation();
        Vector3d velocity = movement.getVelocity();
        Vector3d acceleration = movement.getAcceleration();
        this.location = location == null ? null : new Vector2d(location);
        this.velocity = velocity == null ? null : new Vector2d(velocity);
        this.acceleration = acceleration == null ? null : new Vector2d(acceleration);
    }

    public Motion2d(Vector2d location, Vector2d velocity, Vector2d acceleration) {
        this.location = location;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public Vector2d getLocation() {
        return location;
    }

    public void setLocation(Vector2d location) {
        this.location = location;
    }

    public Vector2d getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2d velocity) {
        this.velocity = velocity;
    }

    public Vector2d getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2d acceleration) {
        this.acceleration = acceleration;
    }
}
