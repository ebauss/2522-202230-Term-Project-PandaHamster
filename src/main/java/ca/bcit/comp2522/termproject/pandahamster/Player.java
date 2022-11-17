package ca.bcit.comp2522.termproject.pandahamster;

import java.util.ArrayList;

/**
 * Represents an object of type Player.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public class Player {
    private static final long MAX_LEVEL = 20;
    private static final int THREE = 3;
    private static final int ONE_HUNDRED = 100;
    private String name;
    private long level;
    private long currentExp;
    private long money;
    // TODO make AbstractWeapon so that the line below can be uncommented
//    private List<AbstractWeapon> weaponInventory;
    private short lifeCount;

    public Player(final String someName) {
        this.name = someName;
        this.level = 1;
//        weaponInventory = new ArrayList<>();
        this.lifeCount = THREE;
        this.money = ONE_HUNDRED;
    }
}
