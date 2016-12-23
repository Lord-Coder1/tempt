package com.iancaffey.tempt.shape;

import com.iancaffey.tempt.coordinate.Cartesian2d;
import com.iancaffey.tempt.math.Dimension2d;

/**
 * Rectangle
 * <p>
 * A representation of a 2-dimensional rectangular shape.
 *
 * @author Ian Caffey
 * @since 1.0
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

    /**
     * Constructs a new {@code Rectangle} at the origin with specified width and height.
     *
     * @param width  the width
     * @param height the height
     */
    public Rectangle(double width, double height) {
        this(Cartesian2d.ORIGIN, width, height);
    }

    /**
     * Constructs a new {@code Rectangle} with specified base coordinate and dimension.
     *
     * @param base   the base coordinate
     * @param width  the width
     * @param height the height
     */
    public Rectangle(Cartesian2d base, double width, double height) {
        this(base.getX(), base.getY(), width, height);
    }

    /**
     * Constructs a new {@code Rectangle} with specified base coordinate and dimension.
     *
     * @param base      the base coordinate
     * @param dimension the dimension
     */
    public Rectangle(Cartesian2d base, Dimension2d dimension) {
        this(base.getX(), base.getY(), dimension.getWidth(), dimension.getHeight());
    }

    /**
     * Constructs a new {@code Rectangle} with specified coordinates and dimension.
     *
     * @param x      the x-coordinate
     * @param y      the y-coordinate
     * @param width  the width
     * @param height the height
     */
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

    /**
     * Returns the x-coordinate.
     *
     * @return the x-coordinate
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return the y-coordinate
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return the rectangle width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return the rectangle height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the maximum x-coordinate of the rectangle.
     *
     * @return the rectangle maximum x-coordinate
     */
    public double getMaxX() {
        return maxX;
    }

    /**
     * Returns the maximum y-coordinate of the rectangle.
     *
     * @return the rectangle maximum y-coordinate
     */
    public double getMaxY() {
        return maxY;
    }

    /**
     * Returns the center x-coordinate of the rectangle.
     *
     * @return the rectangle center x-coordinate
     */
    public double getCenterX() {
        return centerX;
    }

    /**
     * Returns the center y-coordinate of the rectangle.
     *
     * @return the rectangle center y-coordinate
     */
    public double getCenterY() {
        return centerY;
    }

    /**
     * Returns whether the rectangle contains the specified coordinate.
     *
     * @param coordinate the coordinate to check
     * @return {@code true} if the rectangle absolutely contains the specified coordinate
     */
    @Override
    public boolean contains(Cartesian2d coordinate) {
        return coordinate != null && contains(coordinate.getX(), coordinate.getY());
    }

    /**
     * Returns whether the rectangle contains the specified coordinate.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return {@code true} if the rectangle absolutely contains the specified coordinate
     */
    @Override
    public boolean contains(double x, double y) {
        return x >= getX() && x < getMaxX() && y >= getY() && y < getMaxY();
    }

    /**
     * Returns whether the rectangle contains the specified rectangle (represented as base and dimension).
     *
     * @param base the base of the rectangle
     * @param size the dimension of the rectangle
     * @return {@code true} if the rectangle absolutely contains the specified rectangle
     */
    public boolean contains(Cartesian2d base, Dimension2d size) {
        return base != null && size != null && contains(base.getX(), base.getY(), size.getWidth(), size.getHeight());
    }

    /**
     * Returns whether the rectangle contains the specified rectangle.
     *
     * @param rectangle the rectangle to check
     * @return {@code true} if the rectangle absolutely contains the specified rectangle
     */
    public boolean contains(Rectangle rectangle) {
        return rectangle != null && contains(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    /**
     * Returns whether the rectangle contains the specified rectangle.
     *
     * @param x      the rectangle x-coordinate
     * @param y      the rectangle y-coordinate
     * @param width  the rectangle width
     * @param height the rectangle height
     * @return {@code true} if the rectangle absolutely contains the specified rectangle
     */
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

    /**
     * Returns whether the rectangle intersects the specified rectangle.
     *
     * @param rectangle the rectangle to check
     * @return {@code true} if the rectangle intersects the specified rectangle
     */
    public boolean intersects(Rectangle rectangle) {
        return rectangle != null && intersects(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    /**
     * Returns whether the rectangle intersects the specified rectangle (represented as base and dimension).
     *
     * @param base the base of the rectangle
     * @param size the dimension of the rectangle
     * @return {@code true} if the rectangle intersects the specified rectangle
     */
    public boolean intersects(Cartesian2d base, Dimension2d size) {
        return base != null && size != null && intersects(base.getX(), base.getY(), size.getWidth(), size.getHeight());
    }

    /**
     * Returns whether the rectangle intersects the specified rectangle.
     *
     * @param x      the rectangle x-coordinate
     * @param y      the rectangle y-coordinate
     * @param width  the rectangle width
     * @param height the rectangle height
     * @return {@code true} if the rectangle intersects the specified rectangle
     */
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
