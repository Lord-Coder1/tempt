package com.iancaffey.tempt.shape;

import com.iancaffey.tempt.coordinate.Cartesian2d;

/**
 * Shape2d
 * <p>
 * A representation of a 2-dimensional shape.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface Shape2d {
    /**
     * Returns the x-coordinate.
     *
     * @return the x-coordinate
     */
    public double getX();

    /**
     * Returns the y-coordinate.
     *
     * @return the y-coordinate
     */
    public double getY();

    /**
     * Returns whether the shape contains the specified coordinate.
     *
     * @param coordinate the coordinate to check
     * @return {@code true} if the shape absolutely contains the specified coordinate
     */
    public boolean contains(Cartesian2d coordinate);

    /**
     * Returns whether the shape contains the specified coordinate.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return {@code true} if the shape absolutely contains the specified coordinate
     */
    public boolean contains(double x, double y);
}
