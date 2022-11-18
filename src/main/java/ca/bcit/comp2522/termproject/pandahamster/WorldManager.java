package ca.bcit.comp2522.termproject.pandahamster;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

/**
 * For managing a world instance.
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public final class WorldManager {
    private static final float TIME_STEP = 1 / 60f;
    private static final int VELOCITY_ITERATIONS = 8;
    private static final int POSITION_ITERATION = 3;
    private static World world;
    private static BodyDef bodyDef;
    private static FixtureDef fixtureDef;
    private WorldManager() { }
    /**
     * Returns the instance of the world. Subsequent calls will refer to the same world.
     * @return the world
     */
    public static World getInstance() {
        if (world == null) {
            world = new World(new Vec2(0, 0));
            bodyDef = new BodyDef();
            fixtureDef = new FixtureDef();
        }
        return world;
    }
    /**
     * Advances the physics simulation by a single time step that is defined as
     * 1 / 60f.
     */
    public static void updateWorld() {
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATION);
    }
    /**
     * Gets the list of the bodies in the world.
     * @return the list of bodies
     */
    public Body getBodies() {
        return world.getBodyList();
    }
    /**
     * Creates a new body for the specified game entity for the physics simulation.
     * @param gameEntity the game entity to create a body for
     */
    public static void createDynamicRectangle(final GameEntity gameEntity) {
        bodyDef.type = BodyType.DYNAMIC;
        bodyDef.position.set(gameEntity.getXPosition(), gameEntity.getYPosition());
        Body body = world.createBody(bodyDef);
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(gameEntity.getWidth(), gameEntity.getHeight());
        fixtureDef.shape = polygonShape;
        fixtureDef.density = 10f;
        fixtureDef.friction = 0.2f;
        fixtureDef.restitution = 0;
        body.createFixture(fixtureDef);
        body.setUserData(gameEntity);
        gameEntity.setBody(body);
    }
}
