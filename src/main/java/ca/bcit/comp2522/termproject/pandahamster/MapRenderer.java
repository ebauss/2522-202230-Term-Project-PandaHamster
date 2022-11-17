package ca.bcit.comp2522.termproject.pandahamster;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import org.tiledreader.TiledLayer;
import org.tiledreader.TiledMap;
import org.tiledreader.TiledTileLayer;

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
        HashMap<String, HashMap<Integer, Image>> tiles = new HashMap<>();
        // iterate through each layer
        for (TiledLayer tiledLayer: map.getTopLevelLayers()) {
            // TiledTileLayers are the layers where actual tiles are drawn
            if (tiledLayer instanceof TiledTileLayer) {
                TiledTileLayer tiledTileLayer = (TiledTileLayer) tiledLayer;
            }
        }
    }
}
