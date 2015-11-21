package iitc.physics;

/**
 * Entity3d
 *
 * @author Ian
 * @version 1.0
 */
public class Entity3d extends Entity {
    private final Motion3d motion;
    private final Dimension3d size;

    public Entity3d(double mass, Dimension3d size) {
        this(mass, new Motion3d(), size);
    }

    public Entity3d(double mass, Motion3d motion, Dimension3d size) {
        super(mass);
        if (motion == null || size == null)
            throw new IllegalArgumentException();
        this.motion = motion;
        this.size = size;
    }

    public Motion3d getMotion() {
        return motion;
    }

    public Dimension3d getSize() {
        return size;
    }

    public Cartesian3d getPosition() {
        return getMotion().getPosition();
    }

    public void setPosition(Cartesian3d position) {
        getMotion().setPosition(position);
    }

    public void setPosition(double x, double y) {
        getMotion().setPosition(x, y);
    }

    public void setPosition(double x, double y, double z) {
        getMotion().setPosition(x, y, z);
    }

    public Vector3d getVelocity() {
        return getMotion().getVelocity();
    }

    public void setVelocity(Vector3d velocity) {
        getMotion().setVelocity(velocity);
    }

    public void setVelocity(double x, double y) {
        getMotion().setVelocity(x, y);
    }

    public void setVelocity(double x, double y, double z) {
        getMotion().setVelocity(x, y, z);
    }

    public Vector3d getAcceleration() {
        return getMotion().getAcceleration();
    }

    public void setAcceleration(Vector3d acceleration) {
        getMotion().setAcceleration(acceleration);
    }

    public void setAcceleration(double x, double y) {
        getMotion().setAcceleration(x, y);
    }

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
}
