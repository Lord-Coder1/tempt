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
