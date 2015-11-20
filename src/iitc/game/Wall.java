package iitc.game;

import iitc.physics.Dimension2d;

/**
 * Wall
 *
 * @author Ian
 * @version 1.0
 */
public class Wall extends SceneEntity2d {
    public Wall(Dimension2d size) {
        super(Double.MAX_EXPONENT, size);
    }
}
