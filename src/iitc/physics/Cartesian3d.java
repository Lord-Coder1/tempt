package iitc.physics;

/**
 * Cartesian2d
 *
 * @author Ian
 * @version 1.0
 */
public class Cartesian3d {
    private final double x;
    private final double y;
    private final double z;
    public static final Cartesian3d ORIGIN = new Cartesian3d(0, 0);

    public Cartesian3d() {
        this(0, 0);
    }

    public Cartesian3d(double x, double y) {
        this(x, y, 0);
    }

    public Cartesian3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public int hashCode() {
        long bits = 7L;
        bits = 31L * bits + Double.doubleToLongBits(getX());
        bits = 31L * bits + Double.doubleToLongBits(getY());
        bits = 31L * bits + Double.doubleToLongBits(getZ());
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Cartesian3d && getX() == ((Cartesian3d) o).getX() && getY() == ((Cartesian3d) o).getY() && getZ() == ((Cartesian3d) o).getZ();
    }
}
