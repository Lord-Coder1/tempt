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

    public static VectorPair2d getCollision(Entity2d left, Entity2d right) {
        if (left == null || right == null)
            return null;
        Vector2d velocityOne = left.getVelocity();
        Vector2d velocityTwo = right.getVelocity();
        if (velocityOne == null || velocityTwo == null)
            return null;
        Cartesian2d positionOne = left.getPosition();
        Cartesian2d positionTwo = right.getPosition();
        if (positionOne == null || positionTwo == null)
            return null;
        Dimension2d dimensionOne = left.getSize();
        Dimension2d dimensionTwo = right.getSize();
        if (dimensionOne == null || dimensionTwo == null)
            return null;
        double massOne = left.getMass();
        double massTwo = right.getMass();
        boolean infiniteOne = massOne == Double.MAX_VALUE;
        boolean infiniteTwo = massTwo == Double.MAX_VALUE;
        if (infiniteOne && infiniteTwo) {
            massOne = 1.0;
            massTwo = 1.0;
        } else if (infiniteOne) {
            Vector2d normal = side(positionOne, dimensionOne, positionTwo, dimensionTwo);
            return new VectorPair2d(velocityOne, Vector.add(velocityTwo, Vector.multiply(normal, -2 * Vector.dot(velocityTwo, normal))));
        } else if (infiniteTwo) {
            Vector2d normal = side(positionOne, dimensionOne, positionTwo, dimensionTwo);
            return new VectorPair2d(Vector.add(velocityOne, Vector.multiply(normal, -2 * Vector.dot(velocityOne, normal))), velocityTwo);
        }
        Cartesian2d intersection = Motion.intersection(positionOne, dimensionOne, positionTwo, dimensionTwo);
        Vector2d intersectionVector = new Vector2d(new Cartesian2d(positionOne.getX() + dimensionOne.getWidth() / 2.0d, positionOne.getY() + dimensionOne.getHeight() / 2.0d), intersection);
        Vector2d normal = Vector.normalize(intersectionVector);
        Vector2d tangent = new Vector2d(-normal.getY(), normal.getX());
        double velocityOneNormal = Vector.dot(normal, velocityOne);
        double velocityTwoNormal = Vector.dot(normal, velocityTwo);
        double velocityOneTangent = Vector.dot(tangent, velocityOne);
        double velocityTwoTangent = Vector.dot(tangent, velocityTwo);
        double velocityOneAfter = (velocityOneNormal * (massOne - massTwo) + 2 * massTwo * velocityTwoNormal) / (massOne + massTwo);
        double velocityTwoAfter = (velocityTwoNormal * (massTwo - massOne) + 2 * massOne * velocityOneNormal) / (massOne + massTwo);
        return new VectorPair2d(Vector.add(Vector.multiply(normal, velocityTwoAfter), Vector.multiply(tangent, velocityTwoTangent)), Vector.add(Vector.multiply(normal, velocityOneAfter), Vector.multiply(tangent, velocityOneTangent)));
    }

    private static Vector2d side(Cartesian2d positionOne, Dimension2d dimensionOne, Cartesian2d positionTwo, Dimension2d dimensionTwo) {
        double w = 0.5 * (dimensionOne.getWidth() + dimensionTwo.getWidth());
        double h = 0.5 * (dimensionOne.getHeight() + dimensionTwo.getHeight());
        double dx = (positionOne.getX() + (dimensionOne.getWidth() / 2.0d)) - (positionTwo.getX() + (dimensionTwo.getWidth() / 2.0d));
        double dy = (positionOne.getY() + (dimensionOne.getHeight() / 2.0d)) - (positionTwo.getY() + (dimensionTwo.getHeight() / 2.0d));
        double wy = w * dy;
        double hx = h * dx;
        if (wy > hx)
            if (wy > -hx)
                return Vector2d.NORTH;
            else
                return Vector2d.WEST;
        else if (wy > -hx)
            return Vector2d.EAST;
        else
            return Vector2d.SOUTH;
    }

    public static Cartesian2d intersection(Cartesian2d baseOne, Dimension2d sizeOne, Cartesian2d baseTwo, Dimension2d sizeTwo) {
        if (baseOne == null || sizeOne == null || baseTwo == null || sizeTwo == null)
            return null;
        double tx1 = baseOne.getX();
        double ty1 = baseOne.getY();
        double rx1 = baseTwo.getX();
        double ry1 = baseTwo.getY();
        double tx2 = tx1;
        tx2 += sizeOne.getWidth();
        double ty2 = ty1;
        ty2 += sizeOne.getHeight();
        double rx2 = rx1;
        rx2 += sizeTwo.getWidth();
        double ry2 = ry1;
        ry2 += sizeTwo.getHeight();
        if (tx1 < rx1) tx1 = rx1;
        if (ty1 < ry1) ty1 = ry1;
        if (tx2 > rx2) tx2 = rx2;
        if (ty2 > ry2) ty2 = ry2;
        tx2 -= tx1;
        ty2 -= ty1;
        return new Cartesian2d(tx1 + tx2 / 2.0, ty1 + ty2 / 2.0d);
    }

    public static Cartesian2d intersection(Rectangle one, Rectangle two) {
        if (one == null || two == null)
            return null;
        double tx1 = one.getX();
        double ty1 = one.getY();
        double rx1 = two.getX();
        double ry1 = two.getY();
        double tx2 = tx1;
        tx2 += one.getWidth();
        double ty2 = ty1;
        ty2 += one.getHeight();
        double rx2 = rx1;
        rx2 += two.getWidth();
        double ry2 = ry1;
        ry2 += two.getHeight();
        if (tx1 < rx1) tx1 = rx1;
        if (ty1 < ry1) ty1 = ry1;
        if (tx2 > rx2) tx2 = rx2;
        if (ty2 > ry2) ty2 = ry2;
        tx2 -= tx1;
        ty2 -= ty1;
        return new Cartesian2d(tx1 + tx2 / 2.0, ty1 + ty2 / 2.0d);
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
