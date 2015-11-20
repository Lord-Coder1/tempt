package iitc.physics;

/**
 * Shape2d
 *
 * @author Ian
 * @version 1.0
 */
public interface Shape2d {
    public double getX();

    public double getY();

    public boolean contains(Cartesian2d point);

    public boolean contains(double x, double y);
}
