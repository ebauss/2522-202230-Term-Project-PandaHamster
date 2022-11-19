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
    private static WorldManager worldManager;
    private static World world;
    private static BodyDef bodyDef;
    private static FixtureDef fixtureDef;
    private WorldManager() { }
    /**
     * Returns the instance of the world. Subsequent calls will refer to the same world.
     * @return the world
     */
    public static WorldManager getInstance() {
        if (worldManager == null) {
            worldManager = new WorldManager();
            world = new World(new Vec2(0, 0));
            bodyDef = new BodyDef();
            fixtureDef = new FixtureDef();
        }
        return worldManager;
    }
    /**
     * Advances the physics simulation by a single time step that is defined as
     * 1 / 60f, basically a 60th of a second/60FPS.
     */
    public void updateWorld() {
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATION);
        Body firstBody = world.getBodyList();
        // the body list is a linked list
        while (firstBody != null) {
            GameEntity gameEntity = (GameEntity) firstBody.getUserData();
            gameEntity.setXPosition((long) firstBody.getPosition().x);
            gameEntity.setYPosition((long) firstBody.getPosition().y);
            firstBody = firstBody.getNext();
        }
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
    public void createDynamicRectangle(final GameEntity gameEntity) {
        bodyDef.type = BodyType.DYNAMIC;
        bodyDef.position.set(gameEntity.getXPosition(), gameEntity.getYPosition());
        Body body = world.createBody(bodyDef);
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(gameEntity.getWidth(), gameEntity.getHeight());
        fixtureDef.shape = polygonShape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0;
        fixtureDef.restitution = 0;
        body.createFixture(fixtureDef);
        body.setUserData(gameEntity);
        gameEntity.setBody(body);
    }

    /**
     * Creates a new body for the specified game entity for the physics simulation.
     * @param gameEntity the game entity to create the body for
     */
    public void createStaticRectangle(final GameEntity gameEntity) {
        bodyDef.type = BodyType.STATIC;
        bodyDef.position.set(gameEntity.getXPosition(), gameEntity.getYPosition());
        Body body = world.createBody(bodyDef);
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(gameEntity.getWidth(), gameEntity.getHeight());
        fixtureDef.shape = polygonShape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0;
        fixtureDef.restitution = 0;
        body.createFixture(fixtureDef);
        body.setUserData(gameEntity);
        gameEntity.setBody(body);
    }
}
