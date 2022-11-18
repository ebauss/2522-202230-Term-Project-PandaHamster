package ca.bcit.comp2522.termproject.pandahamster;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

/**
 * For managing a world instance.
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public final class WorldManager {
    private static World world;
    private WorldManager() { }
    /**
     * Returns the instance of the world. Subsequent calls will refer to the same world.
     * @return the world
     */
    public static World getInstance() {
        if (world == null) {
            world = new World(new Vec2(0, 0));
        }
        return world;
    }
}
