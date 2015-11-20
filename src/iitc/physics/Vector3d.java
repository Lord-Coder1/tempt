package iitc.physics;

/**
 * Vector3d
 *
 * @author Ian
 * @version 1.0
 */
public class Vector3d {
    private final double x;
    private final double y;
    private final double z;
    public static final Vector3d ORIGIN = new Vector3d(0, 0);
    public static final Vector3d NORTH = new Vector3d(0, 1);
    public static final Vector3d SOUTH = new Vector3d(0, -1);
    public static final Vector3d WEST = new Vector3d(-1, 0);
    public static final Vector3d EAST = new Vector3d(1, 0);

    public Vector3d(Vector2d vector) {
        if (vector == null)
            throw new IllegalArgumentException();
        this.x = vector.getX();
        this.y = vector.getY();
        this.z = 0;
    }

    public Vector3d(Vector3d vector) {
        if (vector == null)
            throw new IllegalArgumentException();
        this.x = vector.getX();
        this.y = vector.getY();
        this.z = vector.getZ();
    }

    public Vector3d(double x, double y) {
        this(x, y, 0);
    }

    public Vector3d(double x, double y, double z) {
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
        return o instanceof Vector3d && getX() == ((Vector3d) o).getX() && getY() == ((Vector3d) o).getY();
    }
}
