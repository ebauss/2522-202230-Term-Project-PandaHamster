package ca.bcit.comp2522.termproject.pandahamster;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

/**
 *  To crop and return a sub image from a given original image. Used in map rendering
 *  to split the map into evenly sized sub images.
 * @author Alexander Liu
 * @version 2022
 */
public final class ImageCropper {
    private ImageCropper() { }

    /**
     * Crops and returns a new sub image from the original image.
     * Code used from stackoverflow post:
     * https://stackoverflow.com/questions/14802374/effective-image-cropping-in-javafx
     * @param imgPath the path of the original image
     * @param x the x position of the desired sub image
     * @param y the y position of the desired sub image
     * @param width the width of the desired sub image
     * @param height the height of the desired sub image
     * @return the cropped image
     */
    public static WritableImage cropImage(final String imgPath, final int x, final int y, final int width, final int height) {
        Image originalImage = new Image(imgPath);
        // retrieves the pixel reader of the original image
        PixelReader pixelReader = originalImage.getPixelReader();
        // returns a sub image at the specified region
        return new WritableImage(pixelReader, x, y, width, height);
    }
}
