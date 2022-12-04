package ca.bcit.comp2522.termproject.pandahamster;

import org.tiledreader.FileSystemTiledReader;
import org.tiledreader.TiledMap;
import org.tiledreader.TiledReader;

public final class GameMap {
    private static int MAP_HEIGHT;
    private static int MAP_WIDTH;
    static {
        TiledReader reader = new FileSystemTiledReader();
        TiledMap map = reader.getMap(PandaHamster.class.getResource("/gameMap.tmx").getPath());
        MAP_HEIGHT = map.getHeight() * map.getTileHeight();
        MAP_WIDTH = map.getWidth() * map.getTileWidth();
    }
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
