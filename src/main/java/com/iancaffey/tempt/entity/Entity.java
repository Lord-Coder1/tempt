package com.iancaffey.tempt.entity;

/**
 * Entity
 * <p>
 * A representation of an entity which has mass.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Entity {
    private double mass;

    /**
     * Constructs a new {@code Entity} with 0 mass.
     */
    public Entity() {
        this(0);
    }

    /**
     * Constructs a new {@code Entity} with specified mass.
     * <p>
     * The mass must be non-negative.
     *
     * @param mass the entity mass
     */
    public Entity(double mass) {
        if (mass < 0)
            throw new IllegalArgumentException();
        this.mass = mass;
    }

    /**
     * Returns the mass of the entity.
     *
     * @return the entity mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * Updates the mass of the entity.
     *
     * @param mass the entity mass
     */
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

    @Override
    public String toString() {
        return String.format("%s[mass=%s]", getClass().getCanonicalName(), getMass());
    }
}
