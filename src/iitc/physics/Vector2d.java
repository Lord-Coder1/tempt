package iitc.physics;

/**
 * Vector2d
 *
 * @author Ian
 * @version 1.0
 */
public class Vector2d {
    private final double x;
    private final double y;
    public static final Vector2d ORIGIN = new Vector2d(0, 0);
    public static final Vector2d NORTH = new Vector2d(0, 1);
    public static final Vector2d NORTHWEST = new Vector2d(-1, 1);
    public static final Vector2d NORTHEAST = new Vector2d(1, 1);
    public static final Vector2d SOUTH = new Vector2d(0, -1);
    public static final Vector2d SOUTHWEST = new Vector2d(-1, -1);
    public static final Vector2d SOUTHEAST = new Vector2d(1, -1);
    public static final Vector2d WEST = new Vector2d(-1, 0);
    public static final Vector2d EAST = new Vector2d(1, 0);

    public Vector2d(Vector3d vector) {
        if (vector == null)
            throw new IllegalArgumentException();
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public Vector2d(Vector2d vector) {
        if (vector == null)
            throw new IllegalArgumentException();
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(getX());
        bits ^= Double.doubleToLongBits(getY()) * 31;
        return (((int) bits) ^ ((int) (bits >> 32)));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Vector2d && getX() == ((Vector2d) o).getX() && getY() == ((Vector2d) o).getY();
    }

    @Override
    public String toString() {
        return String.format("%s[x=%s, y=%s]", getClass().getCanonicalName(), getX(), getY());
    }
}
