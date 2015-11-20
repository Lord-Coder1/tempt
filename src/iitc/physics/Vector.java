package iitc.physics;

/**
 * Vector
 *
 * @author Ian
 * @version 1.0
 */
public class Vector {
    private Vector() {

    }

    public static Vector2d toVector(Cartesian2d point) {
        return point == null ? null : new Vector2d(point.getX(), point.getY());
    }

    public static Vector3d toVector(Cartesian3d point) {
        return point == null ? null : new Vector3d(point.getX(), point.getY(), point.getZ());
    }

    public static Cartesian2d toCartesian(Vector2d vector) {
        return vector == null ? null : new Cartesian2d(vector.getX(), vector.getY());
    }

    public static Cartesian3d toCartesian(Vector3d vector) {
        return vector == null ? null : new Cartesian3d(vector.getX(), vector.getY(), vector.getZ());
    }

    public static Polar2d toPolar(Vector2d vector) {
        return vector == null ? null : Coordinates.toPolar(vector);
    }

    public static Polar3d toPolar(Vector3d vector) {
        return vector == null ? null : Coordinates.toPolar(vector);
    }

    public static Vector2d add(Vector2d a, Vector2d b) {
        if (a == null || b == null)
            return null;
        return new Vector2d(a.getX() + b.getX(), a.getY() + b.getY());
    }

    public static Vector3d add(Vector3d a, Vector2d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ());
    }

    public static Vector3d add(Vector2d a, Vector3d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getX() + b.getX(), a.getY() + b.getY(), b.getZ());
    }

    public static Vector3d add(Vector3d a, Vector3d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
    }

    public static Vector2d subtract(Vector2d a, Vector2d b) {
        if (a == null || b == null)
            return null;
        return new Vector2d(a.getX() - b.getX(), a.getY() - b.getY());
    }

    public static Vector3d subtract(Vector3d a, Vector2d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getX() - b.getX(), a.getY() - b.getY(), a.getZ());
    }

    public static Vector3d subtract(Vector2d a, Vector3d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getX() - b.getX(), a.getY() - b.getY(), -b.getZ());
    }

    public static Vector3d subtract(Vector3d a, Vector3d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getX() - b.getX(), a.getY() - b.getY(), a.getZ() - b.getZ());
    }

    public static Vector2d divide(Vector2d a, double b) {
        if (a == null)
            return null;
        return new Vector2d(a.getX() / b, a.getY() / b);
    }

    public static Vector3d divide(Vector3d a, double b) {
        if (a == null)
            return null;
        return new Vector3d(a.getX() / b, a.getY() / b, a.getZ() / b);
    }

    public static Vector2d multiply(Vector2d a, double b) {
        if (a == null)
            return null;
        return new Vector2d(a.getX() * b, a.getY() * b);
    }

    public static Vector3d multiply(Vector3d a, double b) {
        if (a == null)
            return null;
        return new Vector3d(a.getX() * b, a.getY() * b, a.getZ() * b);
    }

    public static Vector3d cross(Vector3d a, Vector3d b) {
        if (a == null || b == null)
            return null;
        return new Vector3d(a.getY() * b.getZ() - a.getZ() * b.getY(), -a.getX() * b.getZ() + a.getZ() * b.getX(), a.getX() * b.getY() - a.getY() * b.getX());
    }

    public static double dot(Vector2d a, Vector2d b) {
        return a == null || b == null ? Double.MAX_VALUE : a.getX() * b.getX() + a.getY() * b.getY();
    }

    public static double dot(Vector3d a, Vector3d b) {
        return a == null || b == null ? Double.MAX_VALUE : a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
    }

    public static double dot(Vector2d a, Vector3d b) {
        return a == null || b == null ? Double.MAX_VALUE : a.getX() * b.getX() + a.getY() * b.getY();
    }

    public static double dot(Vector3d a, Vector2d b) {
        return a == null || b == null ? Double.MAX_VALUE : a.getX() * b.getX() + a.getY() * b.getY();
    }

    public static double magnitude(Vector2d vector) {
        return vector == null ? Double.MAX_VALUE : Math.sqrt(Math.pow(vector.getX(), 2) + Math.pow(vector.getY(), 2));
    }

    public static double magnitude(Vector3d vector) {
        return vector == null ? Double.MAX_VALUE : Math.sqrt(Math.pow(vector.getX(), 2) + Math.pow(vector.getY(), 2) + Math.pow(vector.getZ(), 2));
    }

    public static Vector2d normalize(Vector2d vector) {
        if (vector == null)
            return null;
        double sqrt = magnitude(vector);
        return new Vector2d(vector.getX() / sqrt, vector.getY() / sqrt);
    }

    public static Vector3d normalize(Vector3d vector) {
        if (vector == null)
            return null;
        double sqrt = magnitude(vector);
        return new Vector3d(vector.getX() / sqrt, vector.getY() / sqrt, vector.getZ() / sqrt);
    }
}
