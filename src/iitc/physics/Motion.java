package iitc.physics;

/**
 * Motion
 *
 * @author Ian
 * @version 1.0
 */
public class Motion {
    private Motion() {
    }

    public static Cartesian2d getDisplacement(double time, Vector2d velocity, Vector2d acceleration) {
        if (time == 0)
            return Cartesian2d.ORIGIN;
        double timeSquared = Math.pow(time, 2);
        return new Cartesian2d((velocity == null ? 0 : (velocity.getX() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getX() * timeSquared)), (velocity == null ? 0 : (velocity.getY() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getY() * timeSquared)));
    }

    public static Cartesian3d getDisplacement(double time, Vector3d velocity, Vector3d acceleration) {
        if (time == 0)
            return Cartesian3d.ORIGIN;
        double timeSquared = Math.pow(time, 2);
        return new Cartesian3d((velocity == null ? 0 : (velocity.getX() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getX() * timeSquared)), (velocity == null ? 0 : (velocity.getY() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getY() * timeSquared)), (velocity == null ? 0 : (velocity.getZ() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getZ() * timeSquared)));
    }

    public static Cartesian2d getPosition(double time, Cartesian2d position, Vector2d velocity, Vector2d acceleration) {
        if (position == null)
            return null;
        if (time == 0)
            return Cartesian2d.ORIGIN;
        double timeSquared = Math.pow(time, 2);
        return new Cartesian2d(position.getX() + (velocity == null ? 0 : (velocity.getX() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getX() * timeSquared)), position.getY() + (velocity == null ? 0 : (velocity.getY() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getY() * timeSquared)));
    }

    public static Cartesian3d getPosition(double time, Cartesian3d position, Vector3d velocity, Vector3d acceleration) {
        if (position == null)
            return null;
        if (time == 0)
            return Cartesian3d.ORIGIN;
        double timeSquared = Math.pow(time, 2);
        return new Cartesian3d(position.getX() + (velocity == null ? 0 : (velocity.getX() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getX() * timeSquared)), position.getY() + (velocity == null ? 0 : (velocity.getY() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getY() * timeSquared)), position.getZ() + (velocity == null ? 0 : (velocity.getZ() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getZ() * timeSquared)));
    }

    public static Cartesian2d getPosition(double time, Vector2d position, Vector2d velocity, Vector2d acceleration) {
        if (position == null)
            return null;
        if (time == 0)
            return Cartesian2d.ORIGIN;
        double timeSquared = Math.pow(time, 2);
        return new Cartesian2d(position.getX() + (velocity == null ? 0 : (velocity.getX() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getX() * timeSquared)), position.getY() + (velocity == null ? 0 : (velocity.getY() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getY() * timeSquared)));
    }

    public static Cartesian3d getPosition(double time, Vector3d position, Vector3d velocity, Vector3d acceleration) {
        if (position == null)
            return null;
        if (time == 0)
            return Cartesian3d.ORIGIN;
        double timeSquared = Math.pow(time, 2);
        return new Cartesian3d(position.getX() + (velocity == null ? 0 : (velocity.getX() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getX() * timeSquared)), position.getY() + (velocity == null ? 0 : (velocity.getY() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getY() * timeSquared)), position.getZ() + (velocity == null ? 0 : (velocity.getZ() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getZ() * timeSquared)));
    }

    public static Vector2d getPositionVector(double time, Cartesian2d position, Vector2d velocity, Vector2d acceleration) {
        if (position == null)
            return null;
        if (time == 0)
            return Vector2d.ORIGIN;
        double timeSquared = Math.pow(time, 2);
        return new Vector2d(position.getX() + (velocity == null ? 0 : (velocity.getX() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getX() * timeSquared)), position.getY() + (velocity == null ? 0 : (velocity.getY() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getY() * timeSquared)));
    }

    public static Vector3d getPositionVector(double time, Cartesian3d position, Vector3d velocity, Vector3d acceleration) {
        if (position == null)
            return null;
        if (time == 0)
            return Vector3d.ORIGIN;
        double timeSquared = Math.pow(time, 2);
        return new Vector3d(position.getX() + (velocity == null ? 0 : (velocity.getX() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getX() * timeSquared)), position.getY() + (velocity == null ? 0 : (velocity.getY() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getY() * timeSquared)), position.getZ() + (velocity == null ? 0 : (velocity.getZ() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getZ() * timeSquared)));
    }

    public static Vector2d getPositionVector(double time, Vector2d position, Vector2d velocity, Vector2d acceleration) {
        if (position == null)
            return null;
        if (time == 0)
            return Vector2d.ORIGIN;
        double timeSquared = Math.pow(time, 2);
        return new Vector2d(position.getX() + (velocity == null ? 0 : (velocity.getX() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getX() * timeSquared)), position.getY() + (velocity == null ? 0 : (velocity.getY() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getY() * timeSquared)));
    }

    public static Vector3d getPositionVector(double time, Vector3d position, Vector3d velocity, Vector3d acceleration) {
        if (position == null)
            return null;
        if (time == 0)
            return Vector3d.ORIGIN;
        double timeSquared = Math.pow(time, 2);
        return new Vector3d(position.getX() + (velocity == null ? 0 : (velocity.getX() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getX() * timeSquared)), position.getY() + (velocity == null ? 0 : (velocity.getY() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getY() * timeSquared)), position.getZ() + (velocity == null ? 0 : (velocity.getZ() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getZ() * timeSquared)));
    }
}
