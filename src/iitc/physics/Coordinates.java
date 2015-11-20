package iitc.physics;

/**
 * Coordinates
 *
 * @author Ian
 * @version 1.0
 */
public class Coordinates {
    private Coordinates() {
    }

    public static double distance(Cartesian2d a, Cartesian2d b) {
        return a == null || b == null ? Double.MAX_VALUE : distance(a.getX(), a.getY(), b.getX(), b.getY());
    }

    public static double distance(Cartesian3d a, Cartesian3d b) {
        return a == null || b == null ? Double.MAX_VALUE : distance(a.getX(), a.getY(), a.getZ(), b.getX(), b.getY(), b.getZ());
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }

    public static double magnitude(Cartesian2d point) {
        return point == null ? Double.MAX_VALUE : Math.sqrt(Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2));
    }

    public static double magnitude(Cartesian3d point) {
        return point == null ? Double.MAX_VALUE : Math.sqrt(Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) + Math.pow(point.getZ(), 2));
    }

    public static Polar2d toPolar(Vector2d point) {
        return point == null ? null : new Polar2d(Vector.magnitude(point), Math.atan2(point.getY(), point.getX()));
    }

    public static Polar3d toPolar(Vector3d point) {
        double mag = Vector.magnitude(point);
        return point == null ? null : new Polar3d(mag, Math.acos(point.getZ() / mag), Math.atan(point.getY() / point.getX()));
    }

    public static Polar2d toPolar(Cartesian2d point) {
        return point == null ? null : new Polar2d(Coordinates.magnitude(point), Math.atan2(point.getY(), point.getX()));
    }

    public static Polar3d toPolar(Cartesian3d point) {
        double mag = Coordinates.magnitude(point);
        return point == null ? null : new Polar3d(mag, Math.acos(point.getZ() / mag), Math.atan(point.getY() / point.getX()));
    }

    public static Cartesian2d toCartesian(Polar2d point) {
        return point == null ? null : new Cartesian2d(point.getRadius() * Math.cos(point.getTheta()), point.getRadius() * Math.sin(point.getTheta()));
    }

    public static Cartesian3d toCartesian(Polar3d point) {
        if (point == null)
            return null;
        double sinTheta = Math.sin(point.getTheta());
        return new Cartesian3d(point.getRadius() * sinTheta * Math.cos(point.getPhi()), point.getRadius() * sinTheta * Math.sin(point.getPhi()), point.getRadius() * Math.cos(point.getTheta()));
    }
}
