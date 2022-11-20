package ca.bcit.comp2522.termproject.pandahamster;

import javafx.geometry.Point2D;

/**
 * Keeps track of the mouse position on the screen.
 */
public final class MousePositionTracker {
    private static Point2D mouseLocation = new Point2D(0, 0);
    private MousePositionTracker() { }
    /**
     * Returns the current mouse location.
     * @return the current mouse location as a Point2D
     */
    public static Point2D getMouseLocation() {
        return mouseLocation;
    }
    /**
     * Updates the current mouse location to the specified position.
     * @param x
     * @param y
     */
    public static void setMouseLocation(final double x, final  double y) {
        mouseLocation = new Point2D(x, y);
    }
}
