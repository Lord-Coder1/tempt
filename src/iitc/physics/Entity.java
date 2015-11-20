package iitc.physics;

/**
 * Entity
 *
 * @author Ian
 * @version 1.0
 */
public class Entity {
    private double mass;

    public Entity(double mass) {
        if (mass < 0)
            throw new IllegalArgumentException();
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        if (mass < 0)
            throw new IllegalArgumentException();
        this.mass = mass;
    }

    @Override
    public int hashCode() {
        return (int) (31 * getMass());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Entity && getMass() == ((Entity) o).getMass();
    }
}
