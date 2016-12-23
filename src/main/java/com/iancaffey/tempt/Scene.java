package com.iancaffey.tempt;

import com.iancaffey.tempt.coordinate.Cartesian2d;
import com.iancaffey.tempt.coordinate.Vector2d;
import com.iancaffey.tempt.coordinate.VectorPair2d;
import com.iancaffey.tempt.math.Dimension2d;
import com.iancaffey.tempt.shape.Rectangle;
import com.iancaffey.tempt.util.Motion;

import java.util.*;

/**
 * Scene
 * <p>
 * A representation of a bounded scene composed of scene entities.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Scene {
    private final Set<SceneEntity2d> entities = new HashSet<>();
    private final Map<SceneEntity2d, List<SceneEntity2d>> visited = new HashMap<>();
    private final Map<SceneEntity2d, Long> updateTimes = new HashMap<>();
    private final Rectangle bounds;

    /**
     * Constructs a new {@code Scene} with specified bounds.
     *
     * @param x      the x-coordinate
     * @param y      the y-coordinate
     * @param width  the width
     * @param height the height
     */
    public Scene(double x, double y, double width, double height) {
        this(new Rectangle(x, y, width, height));
    }

    /**
     * Constructs a new {@code Scene} with specified bounds.
     *
     * @param bounds the scene bounds
     */
    public Scene(Rectangle bounds) {
        if (bounds == null)
            throw new IllegalArgumentException();
        this.bounds = bounds;
    }

    /**
     * Adds the specified entities to the scene.
     *
     * @param entities the scene entities
     */
    public void add(SceneEntity2d... entities) {
        if (entities == null)
            return;
        Collections.addAll(this.entities, entities);
    }

    /**
     * Adds the specified entity to the scene.
     *
     * @param entity the scene entity
     */
    public void add(SceneEntity2d entity) {
        entities.add(entity);
    }

    /**
     * Removes the specified entity from the scene.
     *
     * @param entity the scene entity
     */
    public void remove(SceneEntity2d entity) {
        entities.remove(entity);
        updateTimes.remove(entity);
    }

    /**
     * Returns a copy of the loaded scene entities.
     *
     * @return the scene entities
     */
    public SceneEntity2d[] getEntities() {
        return entities.toArray(new SceneEntity2d[entities.size()]);
    }

    /**
     * Clears the scene of all entities.
     */
    public void clear() {
        entities.clear();
        updateTimes.clear();
    }

    /**
     * Updates the scene by checking for all collisions between entities and updating their new positions accordingly.
     */
    public void update() {
        synchronized (entities) {
            for (SceneEntity2d entity : entities) {
                List<SceneEntity2d> entityVisits = visited.get(entity);
                Rectangle rectangle = new Rectangle(entity.getPosition(), entity.getSize());
                for (SceneEntity2d opposition : entities) {
                    Cartesian2d oppositionPosition = opposition.getPosition();
                    Dimension2d oppositionSize = opposition.getSize();
                    if ((entityVisits != null && entityVisits.contains(opposition)) || opposition.equals(entity)) {
                        if (entityVisits != null && !rectangle.intersects(oppositionPosition, oppositionSize))
                            entityVisits.remove(opposition);
                        continue;
                    }
                    List<SceneEntity2d> oppositeVisits = visited.get(opposition);
                    if (oppositeVisits != null && oppositeVisits.contains(entity))
                        continue;
                    if (rectangle.intersects(oppositionPosition, oppositionSize)) {
                        VectorPair2d pair = Motion.getCollision(entity, opposition);
                        entity.setVelocity(pair.getLeft());
                        opposition.setVelocity(pair.getRight());
                        if (entityVisits == null) {
                            entityVisits = new ArrayList<>();
                            visited.put(entity, entityVisits);
                        }
                        entityVisits.add(opposition);
                    } else if (entityVisits != null) {
                        entityVisits.remove(opposition);
                    }
                }
            }
            long time = System.currentTimeMillis();
            for (SceneEntity2d entity : entities) {
                Long update = updateTimes.get(entity);
                if (update != null) {
                    double t = (time - update) / 1000.0d;
                    entity.setPosition(Motion.getPosition(t, entity));
                    Vector2d velocity = entity.getVelocity();
                    if (velocity != null) {
                        Vector2d acceleration = entity.getAcceleration();
                        if (acceleration != null)
                            entity.setVelocity(velocity.getX() + t * acceleration.getX(), velocity.getY() + t * acceleration.getY());
                    }
                }
                updateTimes.put(entity, time);
            }
        }
    }

    /**
     * Returns whether the scene contains the specified entity.
     *
     * @param entity the scene entity
     * @return {@code true} if the scene contains the entity
     */
    public boolean contains(SceneEntity2d entity) {
        if (entity == null)
            return false;
        Rectangle bounds = getBounds();
        return bounds != null && bounds.contains(entity.getMotion().getPosition());
    }

    /**
     * Returns the scene bounds.
     *
     * @return the scene bounds
     */
    public Rectangle getBounds() {
        return bounds;
    }
}
