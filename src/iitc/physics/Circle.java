package iitc.physics;

/**
 * Circle
 *
 * @author Ian
 * @version 1.0
 */
public class Circle implements Shape2d {
    private final double x;
    private final double y;
    private final double radius;

    public Circle(Cartesian2d center, double radius) {
        this(center.getX(), center.getY(), radius);
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean contains(Cartesian2d point) {
        return point != null && contains(point.getX(), point.getY());
    }

    @Override
    public boolean contains(double x, double y) {
        return Coordinates.distance(getX(), getY(), x, y) < getRadius();
    }

    @Override
    public int hashCode() {
        long bits = 7L;
        bits = 31L * bits + Double.doubleToLongBits(getX());
        bits = 31L * bits + Double.doubleToLongBits(getY());
        bits = 31L * bits + Double.doubleToLongBits(getRadius());
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Circle && getX() == ((Circle) o).getX() && getY() == ((Circle) o).getY() && getRadius() == ((Circle) o).getRadius();
    }
}
