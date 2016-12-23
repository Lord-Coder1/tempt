package com.iancaffey.tempt.util;

import com.iancaffey.tempt.coordinate.*;

/**
 * Vector
 * <p>
 * A utility class for converting between different coordinate systems for vectors and performing basic operations on vectors.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Vector {
    private Vector() {

    }

    /**
     * Converts a coordinate to a vector.
     * <p>
     * The components of the coordinate will correspond to their equivalent vector component.
     *
     * @param coordinate the coordinate to convert
     * @return a new {@code Vector2d} whose components match the coordinate
     */
    public static Vector2d toVector(Cartesian2d coordinate) {
        return coordinate == null ? null : new Vector2d(coordinate.getX(), coordinate.getY());
    }

    /**
     * Converts a coordinate to a vector.
     * <p>
     * The components of the coordinate will correspond to their equivalent vector component.
     *
     * @param coordinate the coordinate to convert
     * @return a new {@code Vector3d} whose components match the coordinate
     */
    public static Vector3d toVector(Cartesian3d coordinate) {
        return coordinate == null ? null : new Vector3d(coordinate.getX(), coordinate.getY(), coordinate.getZ());
    }

    /**
     * Converts a vector to a coordinate.
     * <p>
     * The components of the vector will correspond to their equivalent coordinate component.
     *
     * @param vector the vector to convert
     * @return a new {@code Cartesian2d} whose components match the vector
     */
    public static Cartesian2d toCartesian(Vector2d vector) {
        return vector == null ? null : new Cartesian2d(vector.getX(), vector.getY());
    }

    /**
     * Converts a vector to a coordinate.
     * <p>
     * The components of the vector will correspond to their equivalent coordinate component.
     *
     * @param vector the vector to convert
     * @return a new {@code Cartesian3d} whose components match the vector
     */
    public static Cartesian3d toCartesian(Vector3d vector) {
        return vector == null ? null : new Cartesian3d(vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Converts a vector to a polar coordinate.
     *
     * @param vector the vector to convert
     * @return a new {@code Polar2d} representing the vector in polar coordinate
     * @see Coordinate#toPolar(Vector2d)
     */
    public static Polar2d toPolar(Vector2d vector) {
        return vector == null ? null : Coordinate.toPolar(vector);
    }

    /**
     * Converts a vector to a polar coordinate.
     *
     * @param vector the vector to convert
     * @return a new {@code Polar3d} representing the vector in polar coordinate
     * @see Coordinate#toPolar(Vector3d)
     */
    public static Polar3d toPolar(Vector3d vector) {
        return vector == null ? null : Coordinate.toPolar(vector);
    }

    /**
     * Adds two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new {@code Vector2d} representing the sum of the two vectors
     */
    public static Vector2d add(Vector2d a, Vector2d b) {
        if (a == null || b == null)
            return null;
        return new Vector2d(a.getX() + b.getX(), a.getY() + b.getY());
    }

    /**
     * Adds two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new {@code Vector3d} representing the sum of the two vectors
     */
    public static Vector3d add(Vector3d a, Vector2d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ());
    }

    /**
     * Adds two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new {@code Vector3d} representing the sum of the two vectors
     */
    public static Vector3d add(Vector2d a, Vector3d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getX() + b.getX(), a.getY() + b.getY(), b.getZ());
    }

    /**
     * Adds two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new {@code Vector3d} representing the sum of the two vectors
     */
    public static Vector3d add(Vector3d a, Vector3d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
    }

    /**
     * Subtracts two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new {@code Vector2d} representing the difference of the two vectors
     */
    public static Vector2d subtract(Vector2d a, Vector2d b) {
        if (a == null || b == null)
            return null;
        return new Vector2d(a.getX() - b.getX(), a.getY() - b.getY());
    }

    /**
     * Subtracts two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new {@code Vector3d} representing the difference of the two vectors
     */
    public static Vector3d subtract(Vector3d a, Vector2d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getX() - b.getX(), a.getY() - b.getY(), a.getZ());
    }

    /**
     * Subtracts two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new {@code Vector3d} representing the difference of the two vectors
     */
    public static Vector3d subtract(Vector2d a, Vector3d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getX() - b.getX(), a.getY() - b.getY(), -b.getZ());
    }

    /**
     * Subtracts two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new {@code Vector3d} representing the difference of the two vectors
     */
    public static Vector3d subtract(Vector3d a, Vector3d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getX() - b.getX(), a.getY() - b.getY(), a.getZ() - b.getZ());
    }

    /**
     * Divides the vector by the specified scalar.
     *
     * @param a the vector
     * @param b the scalar
     * @return a new {@code Vector2d} divided by the specified vector
     */
    public static Vector2d divide(Vector2d a, double b) {
        if (a == null)
            return null;
        return new Vector2d(a.getX() / b, a.getY() / b);
    }

    /**
     * Divides the vector by the specified scalar.
     *
     * @param a the vector
     * @param b the scalar
     * @return a new {@code Vector3d} divided by the specified vector
     */
    public static Vector3d divide(Vector3d a, double b) {
        if (a == null)
            return null;
        return new Vector3d(a.getX() / b, a.getY() / b, a.getZ() / b);
    }

    /**
     * Multiplies the vector by the specified scalar.
     *
     * @param a the vector
     * @param b the scalar
     * @return a new {@code Vector2d} multiplied by the specified vector
     */
    public static Vector2d multiply(Vector2d a, double b) {
        if (a == null)
            return null;
        return new Vector2d(a.getX() * b, a.getY() * b);
    }

    /**
     * Multiplies the vector by the specified scalar.
     *
     * @param a the vector
     * @param b the scalar
     * @return a new {@code Vector3d} multiplied by the specified vector
     */
    public static Vector3d multiply(Vector3d a, double b) {
        if (a == null)
            return null;
        return new Vector3d(a.getX() * b, a.getY() * b, a.getZ() * b);
    }

    /**
     * Calculates the cross product of the two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a new {@code Vector3d} representing the cross product of the two vectors
     */
    public static Vector3d cross(Vector3d a, Vector3d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getY() * b.getZ() - a.getZ() * b.getY(), -a.getX() * b.getZ() + a.getZ() * b.getX(), a.getX() * b.getY() - a.getY() * b.getX());
    }

    /**
     * Calculates the dot product of the two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a double representing the dot product of the two vectors
     */
    public static double dot(Vector2d a, Vector2d b) {
        return a == null || b == null ? Double.MAX_VALUE : a.getX() * b.getX() + a.getY() * b.getY();
    }

    /**
     * Calculates the dot product of the two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a double representing the dot product of the two vectors
     */
    public static double dot(Vector3d a, Vector3d b) {
        return a == null || b == null ? Double.MAX_VALUE : a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
    }

    /**
     * Calculates the dot product of the two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a double representing the dot product of the two vectors
     */
    public static double dot(Vector2d a, Vector3d b) {
        return a == null || b == null ? Double.MAX_VALUE : a.getX() * b.getX() + a.getY() * b.getY();
    }

    /**
     * Calculates the dot product of the two vectors.
     *
     * @param a the first vector
     * @param b the second vector
     * @return a double representing the dot product of the two vectors
     */
    public static double dot(Vector3d a, Vector2d b) {
        return a == null || b == null ? Double.MAX_VALUE : a.getX() * b.getX() + a.getY() * b.getY();
    }

    /**
     * Calculates the magnitude of the vector.
     *
     * @param vector the vector
     * @return a double representing the magnitude of the vector
     */
    public static double magnitude(Vector2d vector) {
        return vector == null ? Double.MAX_VALUE : Math.sqrt(Math.pow(vector.getX(), 2) + Math.pow(vector.getY(), 2));
    }

    /**
     * Calculates the magnitude of the vector.
     *
     * @param vector the vector
     * @return a double representing the magnitude of the vector
     */
    public static double magnitude(Vector3d vector) {
        return vector == null ? Double.MAX_VALUE : Math.sqrt(Math.pow(vector.getX(), 2) + Math.pow(vector.getY(), 2) + Math.pow(vector.getZ(), 2));
    }

    /**
     * Normalized the vector.
     * <p>
     * The norm is represented as each component divided by the magnitude of the vector.
     *
     * @param vector the vector
     * @return a new {@code Vector2d} representing the normalized vector
     */
    public static Vector2d normalize(Vector2d vector) {
        if (vector == null)
            return null;
        double sqrt = magnitude(vector);
        return new Vector2d(vector.getX() / sqrt, vector.getY() / sqrt);
    }

    /**
     * Normalized the vector.
     * <p>
     * The norm is represented as each component divided by the magnitude of the vector.
     *
     * @param vector the vector
     * @return a new {@code Vector2d} representing the normalized vector
     */
    public static Vector3d normalize(Vector3d vector) {
        if (vector == null)
            return null;
        double sqrt = magnitude(vector);
        return new Vector3d(vector.getX() / sqrt, vector.getY() / sqrt, vector.getZ() / sqrt);
    }

    /**
     * Returns the inverse vector.
     * <p>
     * The inverse vector is represented as each negated component of the specified vector.
     *
     * @param vector the vector
     * @return a new {@code Vector2d} representing the inverse
     */
    public static Vector2d inverse(Vector2d vector) {
        return vector == null ? null : new Vector2d(-vector.getX(), -vector.getY());
    }

    /**
     * Returns the inverse vector.
     * <p>
     * The inverse vector is represented as each negated component of the specified vector.
     *
     * @param vector the vector
     * @return a new {@code Vector3d} representing the inverse
     */
    public static Vector3d inverse(Vector3d vector) {
        return vector == null ? null : new Vector3d(-vector.getX(), -vector.getY(), -vector.getZ());
    }
}
