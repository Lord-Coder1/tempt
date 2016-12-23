package com.iancaffey.tempt.coordinate;

import java.util.Objects;

/**
 * VectorPair2d
 * <p>
 * A representation of a pair of 2-dimensional vector.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class VectorPair2d {
    private final Vector2d left;
    private final Vector2d right;

    /**
     * Constructs a new {@code VectorPair2d} with specified left and right vectors.
     *
     * @param left  the left vector
     * @param right the right vector
     */
    public VectorPair2d(Vector2d left, Vector2d right) {
        if (left == null || right == null)
            throw new IllegalArgumentException();
        this.left = left;
        this.right = right;
    }

    /**
     * Returns the left vector of the pair.
     *
     * @return the left vector
     */
    public Vector2d getLeft() {
        return left;
    }

    /**
     * Returns the right vector of the pair.
     *
     * @return the right vector
     */
    public Vector2d getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        long bits = getLeft().hashCode();
        bits ^= getRight().hashCode() * 31;
        return (((int) bits) ^ ((int) (bits >> 32)));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof VectorPair2d && Objects.equals(getLeft(), ((VectorPair2d) o).getLeft()) && Objects.equals(getRight(), ((VectorPair2d) o).getRight());
    }

    @Override
    public String toString() {
        return String.format("%s[left=%s, right=%s]", getClass().getCanonicalName(), getLeft(), getRight());
    }
}
