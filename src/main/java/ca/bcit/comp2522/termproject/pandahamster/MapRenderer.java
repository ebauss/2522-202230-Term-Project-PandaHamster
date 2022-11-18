package ca.bcit.comp2522.termproject.pandahamster;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import org.tiledreader.*;

import java.util.HashMap;

/**
 * Class to render a tmx file (a tiled map).
 * @author Alex Liu
 * @version 2022
 */
public final class MapRenderer {
    private MapRenderer() { }

    /**
     * Renders a map into a StackPane of GridPane's. Each tile will be stored
     * as an ImageView in each cell of the GridPane.
     * @param map the map to render
     * @return the rendered map
     */
    public StackPane render(final TiledMap map) {
        StackPane stackPane = new StackPane();
        HashMap<String, HashMap<Integer, Image>> tiles = new HashMap<>();
        for (TiledTileset tiledTileset: map.getTilesets()) {
            tiles.put(tiledTileset.getName(), new HashMap<>());
        }
        // iterate through each layer
        for (TiledLayer tiledLayer: map.getTopLevelLayers()) {
            // TiledTileLayers are the layers where actual tiles are drawn
            if (tiledLayer instanceof TiledTileLayer) {
                TiledTileLayer tiledTileLayer = (TiledTileLayer) tiledLayer;
                // iterate through all the tiles on the layer
                for (int x = 0; x < map.getWidth(); x++) {
                    for (int y = 0; y < map.getHeight(); y++) {
                        TiledTile tile = tiledTileLayer.getTile(x, y);
                        String tilesetName = tile.getTileset().getName();
                        Image image = ImageCropper.cropImage(
                                tile.getTileset().getPath(),
                                x * map.getTileWidth(), y * map.getTileHeight(),
                                map.getTileWidth(),
                                map.getTileHeight());

                    }
                }
            }
        }
    }
}
