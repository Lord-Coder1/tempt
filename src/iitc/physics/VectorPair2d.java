package iitc.physics;

import java.util.Objects;

/**
 * VectorPair2d
 *
 * @author Ian
 * @version 1.0
 */
public class VectorPair2d {
    private final Vector2d left;
    private final Vector2d right;

    public VectorPair2d(Vector2d left, Vector2d right) {
        if (left == null || right == null)
            throw new IllegalArgumentException();
        this.left = left;
        this.right = right;
    }

    public Vector2d getLeft() {
        return left;
    }

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
