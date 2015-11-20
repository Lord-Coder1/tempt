package iitc.physics;

/**
 * Motion2d
 *
 * @author Ian
 * @version 1.0
 */
public class Motion2d {
    private Cartesian2d position;
    private Vector2d velocity;
    private Vector2d acceleration;

    public Motion2d() {
        this(new Cartesian2d(0, 0), new Vector2d(0, 0), new Vector2d(0, 0));
    }

    public Motion2d(Motion2d movement) {
        if (movement == null)
            throw new IllegalArgumentException();
        this.position = movement.getPosition();
        this.velocity = movement.getVelocity();
        this.acceleration = movement.getAcceleration();
    }

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

    public Motion2d(Cartesian2d position, Vector2d velocity, Vector2d acceleration) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public Cartesian2d getPosition() {
        return position;
    }

    public void setPosition(double x, double y) {
        setPosition(new Cartesian2d(x, y));
    }

    public void setPosition(Cartesian2d position) {
        this.position = position;
    }

    public Vector2d getVelocity() {
        return velocity;
    }

    public void setVelocity(double x, double y) {
        setVelocity(new Vector2d(x, y));
    }

    public void setVelocity(Vector2d velocity) {
        this.velocity = velocity;
    }

    public Vector2d getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double x, double y) {
        setAcceleration(new Vector2d(x, y));
    }

    public void setAcceleration(Vector2d acceleration) {
        this.acceleration = acceleration;
    }
}
