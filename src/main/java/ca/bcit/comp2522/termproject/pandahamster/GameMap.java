package ca.bcit.comp2522.termproject.pandahamster;

public final class GameMap {
    private static int MAP_HEIGHT;
    private static int MAP_WIDTH;
    private GameMap() { }

    public static int getMapHeight() {
        return MAP_HEIGHT;
    }

    public static void setMapHeight(int mapHeight) {
        MAP_HEIGHT = mapHeight;
    }

    public static int getMapWidth() {
        return MAP_WIDTH;
    }

    public static void setMapWidth(int mapWidth) {
        MAP_WIDTH = mapWidth;
    }
}
