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

    public boolean contains(double x, double y, double width, double height) {
        double dw = this.width;
        double dh = this.height;
        double dx = 0;
        double dy = 0;
        if (x < dx || y < dy)
            return false;
        dw += dx;
        width += x;
        if (width <= x) {
            if (dw >= dx || width > dw) return false;
        } else {
            if (dw >= dx && width > dw) return false;
        }
        dh += dy;
        height += y;
        if (height <= y) {
            if (dh >= dy || height > dh) return false;
        } else {
            if (dh >= dy && height > dh) return false;
        }
        return true;
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

    @Override
    public String toString() {
        return String.format("%s[width=%s, height=%s]", getClass().getCanonicalName(), getWidth(), getHeight());
    }
}
