package com.iancaffey.tempt.util;

import com.iancaffey.tempt.coordinate.*;

/**
 * Coordinate
 * <p>
 * A utility class which allows for converting between different coordinate systems and dimensions.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Coordinate {
    private Coordinate() {
    }

    /**
     * Computes the distance between two 2-dimensional cartesian coordinates.
     *
     * @param a the first coordinate
     * @param b the second coordinate
     * @return the distance between the two coordinates
     */
    public static double distance(Cartesian2d a, Cartesian2d b) {
        return a == null || b == null ? Double.MAX_VALUE : distance(a.getX(), a.getY(), b.getX(), b.getY());
    }

    /**
     * Computes the distance between two 3-dimensional cartesian coordinates.
     *
     * @param a the first coordinate
     * @param b the second coordinate
     * @return the distance between the two coordinates
     */
    public static double distance(Cartesian3d a, Cartesian3d b) {
        return a == null || b == null ? Double.MAX_VALUE : distance(a.getX(), a.getY(), a.getZ(), b.getX(), b.getY(), b.getZ());
    }

    /**
     * Computes the distance between two 2-dimensional cartesian coordinates.
     *
     * @param x1 the first x-coordinate
     * @param y1 the first y-coordinate
     * @param x2 the second x-coordinate
     * @param y2 the second y-coordinate
     * @return the distance between the two coordinates
     */
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /**
     * Computes the distance between two 3-dimensional cartesian coordinates.
     *
     * @param x1 the first x-coordinate
     * @param y1 the first y-coordinate
     * @param z1 the first z-coordinate
     * @param x2 the second x-coordinate
     * @param y2 the second y-coordinate
     * @param z2 the second z-coordinate
     * @return the distance between the two coordinates
     */
    public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }

    /**
     * Returns the distance from the specified coordinate to the origin.
     *
     * @param coordinate the coordinate to check
     * @return the cartesian distance from the origin to the coordinate
     */
    public static double magnitude(Cartesian2d coordinate) {
        return coordinate == null ? Double.MAX_VALUE : Math.sqrt(Math.pow(coordinate.getX(), 2) + Math.pow(coordinate.getY(), 2));
    }

    /**
     * Returns the distance from the specified coordinate to the origin.
     *
     * @param coordinate the coordinate to check
     * @return the cartesian distance from the origin to the coordinate
     */
    public static double magnitude(Cartesian3d coordinate) {
        return coordinate == null ? Double.MAX_VALUE : Math.sqrt(Math.pow(coordinate.getX(), 2) + Math.pow(coordinate.getY(), 2) + Math.pow(coordinate.getZ(), 2));
    }

    /**
     * Converts the 2-dimensional vector from cartesian to a polar coordinate.
     *
     * @param vector the vector to translate
     * @return a polar coordinate
     */
    public static Polar2d toPolar(Vector2d vector) {
        return vector == null ? null : new Polar2d(Vector.magnitude(vector), Math.atan2(vector.getY(), vector.getX()));
    }

    /**
     * Converts the 3-dimensional vector from cartesian to a polar coordinate.
     *
     * @param vector the vector to translate
     * @return a polar coordinate
     */
    public static Polar3d toPolar(Vector3d vector) {
        double mag = Vector.magnitude(vector);
        return vector == null ? null : new Polar3d(mag, Math.acos(vector.getZ() / mag), Math.atan(vector.getY() / vector.getX()));
    }

    /**
     * Converts the 2-dimensional cartesian coordinate to polar coordinate.
     *
     * @param coordinate the cartesian coordinate to convert
     * @return a polar coordinate
     */
    public static Polar2d toPolar(Cartesian2d coordinate) {
        return coordinate == null ? null : new Polar2d(Coordinate.magnitude(coordinate), Math.atan2(coordinate.getY(), coordinate.getX()));
    }

    /**
     * Converts the 3-dimensional cartesian coordinate to polar coordinate.
     *
     * @param coordinate the cartesian coordinate to convert
     * @return a polar coordinate
     */
    public static Polar3d toPolar(Cartesian3d coordinate) {
        double mag = Coordinate.magnitude(coordinate);
        return coordinate == null ? null : new Polar3d(mag, Math.acos(coordinate.getZ() / mag), Math.atan(coordinate.getY() / coordinate.getX()));
    }

    /**
     * Converts the 2-dimensional polar coordinate to cartesian coordinate.
     *
     * @param coordinate the polar coordinate to convert
     * @return a cartesian coordinate
     */
    public static Cartesian2d toCartesian(Polar2d coordinate) {
        return coordinate == null ? null : new Cartesian2d(coordinate.getRadius() * Math.cos(coordinate.getTheta()), coordinate.getRadius() * Math.sin(coordinate.getTheta()));
    }

    /**
     * Converts the 2-dimensional polar coordinate to cartesian coordinate.
     *
     * @param coordinate the polar coordinate to convert
     * @return a cartesian coordinate
     */
    public static Cartesian3d toCartesian(Polar3d coordinate) {
        if (coordinate == null)
            return null;
        double sinTheta = Math.sin(coordinate.getTheta());
        return new Cartesian3d(coordinate.getRadius() * sinTheta * Math.cos(coordinate.getPhi()), coordinate.getRadius() * sinTheta * Math.sin(coordinate.getPhi()), coordinate.getRadius() * Math.cos(coordinate.getTheta()));
    }
}
