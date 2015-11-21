package iitc.game;

import iitc.physics.Dimension2d;
import iitc.physics.Rectangle;
import iitc.physics.Wall;

import java.util.Arrays;

/**
 * BoundedScene
 *
 * @author Ian
 * @version 1.0
 */
public class BoundedScene extends Scene {
    private final Wall[] walls;

    public BoundedScene(double x, double y, double width, double height) {
        super(x, y, width, height);
        double halfHeight = height / 2.0d;
        double halfWidth = width / 2.0d;
        this.walls = new Wall[]{new Wall(new Dimension2d(halfWidth, height), Wall.Side.LEFT),
                new Wall(new Dimension2d(width, halfHeight), Wall.Side.TOP),
                new Wall(new Dimension2d(halfWidth, height), Wall.Side.RIGHT),
                new Wall(new Dimension2d(width, halfHeight), Wall.Side.BOTTOM)};
        walls[0].setPosition(x - halfWidth, y);
        walls[1].setPosition(x, y - halfHeight);
        walls[2].setPosition(x + width, 0);
        walls[3].setPosition(0, y + height);
        add(walls);

    }

    public BoundedScene(Rectangle bounds) {
        super(bounds);
        double x = bounds.getX();
        double y = bounds.getY();
        double width = bounds.getWidth();
        double height = bounds.getHeight();
        double halfHeight = height / 2.0d;
        double halfWidth = width / 2.0d;
        this.walls = new Wall[]{new Wall(new Dimension2d(halfWidth, height), Wall.Side.LEFT),
                new Wall(new Dimension2d(width, halfHeight), Wall.Side.TOP),
                new Wall(new Dimension2d(halfWidth, height), Wall.Side.RIGHT),
                new Wall(new Dimension2d(width, halfHeight), Wall.Side.BOTTOM)};
        walls[0].setPosition(x - halfWidth, y);
        walls[1].setPosition(x, y - halfHeight);
        walls[2].setPosition(x + width, 0);
        walls[3].setPosition(0, y + height);
        add(walls);
    }

    public Wall[] getWalls() {
        return Arrays.copyOf(walls, walls.length);
    }
}
