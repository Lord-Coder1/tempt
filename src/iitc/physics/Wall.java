package iitc.physics;

import iitc.game.SceneEntity2d;

/**
 * Wall
 *
 * @author Ian
 * @version 1.0
 */
public class Wall extends SceneEntity2d {
    private final Side side;

    public Wall(Dimension2d size, Side side) {
        super(Double.MAX_VALUE, size);
        if (side == null)
            throw new IllegalArgumentException();
        this.side = side;
    }

    public Side getSide() {
        return side;
    }

    public static enum Side {
        LEFT(new Vector2d(1, 0)), TOP(new Vector2d(0, -1)), RIGHT(new Vector2d(-1, 0)), BOTTOM(new Vector2d(0, 1));
        private final Vector2d normal;

        Side(Vector2d normal) {
            this.normal = normal;
        }

        public Vector2d getNormal() {
            return normal;
        }
    }
}
