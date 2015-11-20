package iitc.physics;

/**
 * Dimension2d
 *
 * @author Ian
 * @version 1.0
 */
public class Dimension2d {
    private final double width;
    private final double height;

    public Dimension2d(double width, double height) {
        if (width < 0 || height < 0)
            throw new IllegalArgumentException();
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean contains(Cartesian2d point) {
        return point != null && contains(point.getX(), point.getY());
    }


    public boolean contains(double x, double y) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
    }

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(getWidth());
        bits ^= Double.doubleToLongBits(getHeight()) * 31;
        return (((int) bits) ^ ((int) (bits >> 32)));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Dimension2d &&
                getWidth() == ((Dimension2d) o).getWidth() &&
                getHeight() == ((Dimension2d) o).getHeight();
    }
}
