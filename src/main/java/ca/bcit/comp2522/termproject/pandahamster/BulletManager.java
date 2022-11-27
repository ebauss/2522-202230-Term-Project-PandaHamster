package ca.bcit.comp2522.termproject.pandahamster;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Manages all bullets fired in the game.
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public final class BulletManager {
    private static final List<Bullet> BULLET_LIST = new ArrayList<>();
    private BulletManager() { }

    /**
     * Adds bullets for the manager to keep track of. Bullets will be added to the list, game, and world.
     * @param bullets a variable list of bullets to add
     */
    public static void addBullets(final Bullet... bullets) {
        for (Bullet bullet: bullets) {
            BULLET_LIST.add(bullet);
            PandaHamster.getGroup().getChildren().add(bullet.getBulletSprite());
            WorldManager.getInstance().createDynamicRectangle(bullet, 0.2f);
        }
    }
    /**
     * Removes all unnecessary bullets from the game. Conditions for a bullet to be removed:
     * <ul>
     *     <li>When a bullet hit a valid collidable object</li>
     *     <li>When a bullet travelled its max range</li>
     * </ul>
     */
    public static void cleanup() {
        for (Bullet bullet: BULLET_LIST) {
            System.out.println(bullet.getXPosition());
            if (bullet.reachedMaxRange()) {
                bullet.setMarkedForRemoval(true);
            }
        }
        Iterator<Bullet> itr = BULLET_LIST.iterator();
        while (itr.hasNext()) {
            Bullet bullet = itr.next();
            if (bullet.markedForRemoval()) {
                remove(bullet);
                itr.remove();
            }
        }
    }

    /**
     * Removes the bullet from the game and world.
     * @param bullet the bullet to remove
     */
    private static void remove(final Bullet bullet) {
        PandaHamster.getGroup().getChildren().remove(bullet.getBulletSprite());
        WorldManager.getInstance().removeBody(bullet.getBody());
    }
}
