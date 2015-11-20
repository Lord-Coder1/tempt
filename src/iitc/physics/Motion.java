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

    public static VectorPair2d getCollisionVelocity(Entity2d left, Entity2d right) {
        if (left == null || right == null)
            return null;
        Vector2d leftVelocity = left.getVelocity();
        Vector2d rightVelocity = right.getVelocity();
        double leftMass = left.getMass();
        double rightMass = right.getMass();
        double leftAngle = leftVelocity.getX() == 0 ? 0 : Math.atan(leftVelocity.getY() / leftVelocity.getX());
        double leftVelocityX = leftVelocity.getX() * Math.cos(leftAngle);
        double leftVelocityY = leftVelocity.getX() * Math.sin(leftAngle);
        double rightAngle = rightVelocity.getX() == 0 ? 0 : Math.atan(rightVelocity.getY() / rightVelocity.getX());
        double rightVelocityX = rightVelocity.getX() * Math.cos(rightAngle);
        double rightVelocityY = rightVelocity.getX() * Math.sin(rightAngle);
        if (left instanceof Wall) {
            Vector2d normal = ((Wall) left).getSide().getNormal();
            return new VectorPair2d(Vector2d.ORIGIN, Vector.add(rightVelocity, Vector.multiply(normal, -2 * Vector.dot(rightVelocity, normal))));
        } else if (right instanceof Wall) {
            Vector2d normal = ((Wall) right).getSide().getNormal();
            return new VectorPair2d(Vector.add(leftVelocity, Vector.multiply(normal, -2 * Vector.dot(leftVelocity, normal))), Vector2d.ORIGIN);
        }
        double cof1 = (2 * leftMass) / (leftMass + rightMass);
        double cof2 = -(leftMass - rightMass) / (leftMass + rightMass);
        double cof3 = (leftMass - rightMass) / (leftMass + rightMass);
        double cof4 = (2 * rightMass) / (leftMass + rightMass);
        return new VectorPair2d(new Vector2d(cof3 * leftVelocityX + cof4 * rightVelocityX, cof3 * leftVelocityY + cof4 * rightVelocityY), new Vector2d(cof1 * leftVelocityX + cof2 * rightVelocityX, cof1 * leftVelocityY + cof2 * rightVelocityY));
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

    public static Cartesian2d getPosition(double time, Entity2d entity) {
        return entity == null ? null : getPosition(time, entity.getPosition(), entity.getVelocity(), entity.getAcceleration());
    }

    public static Cartesian2d getPosition(double time, Cartesian2d position, Vector2d velocity, Vector2d acceleration) {
        if (position == null)
            return null;
        if (time == 0)
            return Cartesian2d.ORIGIN;
        double timeSquared = Math.pow(time, 2);
        return new Cartesian2d(position.getX() + (velocity == null ? 0 : (velocity.getX() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getX() * timeSquared)), position.getY() + (velocity == null ? 0 : (velocity.getY() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getY() * timeSquared)));
    }

    public static Cartesian3d getPosition(double time, Entity3d entity) {
        return entity == null ? null : getPosition(time, entity.getPosition(), entity.getVelocity(), entity.getAcceleration());
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

    public static Vector2d getPositionVector(double time, Entity2d entity) {
        return entity == null ? null : getPositionVector(time, entity.getPosition(), entity.getVelocity(), entity.getAcceleration());
    }

    public static Vector2d getPositionVector(double time, Cartesian2d position, Vector2d velocity, Vector2d acceleration) {
        if (position == null)
            return null;
        if (time == 0)
            return Vector2d.ORIGIN;
        double timeSquared = Math.pow(time, 2);
        return new Vector2d(position.getX() + (velocity == null ? 0 : (velocity.getX() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getX() * timeSquared)), position.getY() + (velocity == null ? 0 : (velocity.getY() * time)) + (acceleration == null ? 0 : (1 / 2) * (acceleration.getY() * timeSquared)));
    }

    public static Vector3d getPositionVector(double time, Entity3d entity) {
        return entity == null ? null : getPositionVector(time, entity.getPosition(), entity.getVelocity(), entity.getAcceleration());
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
