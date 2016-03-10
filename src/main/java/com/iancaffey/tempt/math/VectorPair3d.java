package com.iancaffey.tempt.math;

import java.util.Objects;

/**
 * VectorPair2d
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class VectorPair3d {
    private final Vector3d left;
    private final Vector3d right;

    public VectorPair3d(Vector3d left, Vector3d right) {
        if (left == null || right == null)
            throw new IllegalArgumentException();
        this.left = left;
        this.right = right;
    }

    public Vector3d getLeft() {
        return left;
    }

    public Vector3d getRight() {
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
        return o instanceof VectorPair3d && Objects.equals(getLeft(), ((VectorPair3d) o).getLeft()) && Objects.equals(getRight(), ((VectorPair3d) o).getRight());
    }

    @Override
    public String toString() {
        return String.format("%s[left=%s, right=%s]", getClass().getCanonicalName(), getLeft(), getRight());
    }
}
