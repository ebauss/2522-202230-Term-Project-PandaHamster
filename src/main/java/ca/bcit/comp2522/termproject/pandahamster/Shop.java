package ca.bcit.comp2522.termproject.pandahamster;

import java.util.ArrayList;

/**
 * Represents the Shop object.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class Shop {
    private static Shop shopInstance;
    private final Player playerInstance;
    private final ArrayList<AbstractShooter> shopInventory;

    /**
     * Constructs the Shop object.
     *
     * @param playerInstance the instance of the Player as a Player object.
     * @param shopInventory  the inventory of the Shop as an ArrayList<AbstractShooter>
     */
    public Shop(final Player playerInstance, final ArrayList<AbstractShooter> shopInventory) {
        this.playerInstance = playerInstance;
        this.shopInventory = shopInventory;
    }

    /**
     * Ensures that only one instance of Shop is created.
     *
     * @param somePlayer the instance of the Player as a Player object.
     * @param someInventory the inventory of the Shop as an ArrayList<AbstractShooter>
     * @return the single instance of the Shop
     */
    public static Shop getInstance(final Player somePlayer, final ArrayList<AbstractShooter> someInventory) {
        if (shopInstance == null) {
            shopInstance = new Shop(somePlayer, someInventory);
        }
        return shopInstance;
    }

    /**
     * Displays the items in the shop.
     */
    public void showItems() {
        // TODO modify implementation so that it displays shop items in JavaFX. Currently, only looping through the
        //  shopInventory has been implemented.
        for (AbstractShooter element: this.shopInventory) {
            System.out.println(element.name);
        }
    }
}
