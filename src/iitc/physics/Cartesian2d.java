package iitc.physics;

/**
 * Cartesian2d
 *
 * @author Ian
 * @version 1.0
 */
public class Cartesian2d {
    public static final Cartesian2d ORIGIN = new Cartesian2d(0, 0);
    private final double x;
    private final double y;

    public Cartesian2d() {
        this(0, 0);
    }

    public Cartesian2d(Cartesian2d point) {
        this(point.getX(), point.getY());
    }

    public Cartesian2d(Cartesian3d point) {
        this(point.getX(), point.getY());
    }

    public Cartesian2d(double x, double y) {
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
        return o instanceof Cartesian2d && getX() == ((Cartesian2d) o).getX() && getY() == ((Cartesian2d) o).getY();
    }

    @Override
    public String toString() {
        return String.format("%s[x=%s, y=%s]", getClass().getCanonicalName(), getX(), getY());
    }
}
