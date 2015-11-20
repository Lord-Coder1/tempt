package iitc.physics;

/**
 * Rectangle
 *
 * @author Ian
 * @version 1.0
 */
public class Rectangle implements Shape2d {
    private final double x;
    private final double y;
    private final double width;
    private final double height;
    private final double maxX;
    private final double maxY;
    private final double centerX;
    private final double centerY;

    public Rectangle(double width, double height) {
        this(Cartesian2d.ORIGIN, width, height);
    }

    public Rectangle(Cartesian2d base, double width, double height) {
        this(base.getX(), base.getY(), width, height);
    }

    public Rectangle(Cartesian2d base, Dimension2d dimension) {
        this(base.getX(), base.getY(), dimension.getWidth(), dimension.getHeight());
    }

    public Rectangle(double x, double y, double width, double height) {
        if (width < 0 || height < 0)
            throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxX = x + width;
        this.maxY = y + height;
        this.centerX = x + (width / 2.0d);
        this.centerY = y + (height / 2.0d);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    @Override
    public boolean contains(Cartesian2d point) {
        return point != null && contains(point.getX(), point.getY());
    }

    @Override
    public boolean contains(double x, double y) {
        return x >= getX() && x < getMaxX() && y >= getY() && y < getMaxY();
    }

    public boolean contains(Cartesian2d base, Dimension2d size) {
        return base != null && size != null && contains(base.getX(), base.getY(), size.getWidth(), size.getHeight());
    }

    public boolean contains(Rectangle rectangle) {
        return rectangle != null && contains(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    public boolean contains(double x, double y, double width, double height) {
        double dw = this.width;
        double dh = this.height;
        double dx = getX();
        double dy = getY();
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

    public boolean intersects(Rectangle rectangle) {
        return rectangle != null && intersects(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    public boolean intersects(Cartesian2d base, Dimension2d size) {
        return base != null && size != null && intersects(base.getX(), base.getY(), size.getWidth(), size.getHeight());
    }

    public boolean intersects(double x, double y, double width, double height) {
        double tw = getWidth();
        double th = getHeight();
        double rw = width;
        double rh = height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0)
            return false;
        double tx = this.getX();
        double ty = this.getY();
        rw += x;
        rh += y;
        tw += tx;
        th += ty;
        return ((rw < x || rw > tx) &&
                (rh < y || rh > ty) &&
                (tw < tx || tw > x) &&
                (th < ty || th > y));
    }

    @Override
    public int hashCode() {
        long bits = 7L;
        bits = 31L * bits + Double.doubleToLongBits(getX());
        bits = 31L * bits + Double.doubleToLongBits(getY());
        bits = 31L * bits + Double.doubleToLongBits(getWidth());
        bits = 31L * bits + Double.doubleToLongBits(getHeight());
        return (int) (bits ^ (bits >> 32));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Rectangle &&
                getX() == ((Rectangle) o).getX() &&
                getY() == ((Rectangle) o).getY() &&
                getWidth() == ((Rectangle) o).getWidth() &&
                getHeight() == ((Rectangle) o).getHeight();
    }

    @Override
    public String toString() {
        return String.format("%s[x=%s, y=%s, width=%s, height=%s]", getClass().getCanonicalName(), getX(), getY(), getWidth(), getHeight());
    }
}
