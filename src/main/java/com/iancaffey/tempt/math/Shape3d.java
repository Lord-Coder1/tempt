package com.iancaffey.tempt.math;

/**
 * Shape2d
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface Shape3d {
    public double getX();

    public double getY();

    public double getZ();

    public boolean contains(Cartesian2d point);

    public boolean contains(Cartesian3d point);

    public boolean contains(double x, double y, double z);
}
