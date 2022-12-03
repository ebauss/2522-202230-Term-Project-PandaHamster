package ca.bcit.comp2522.termproject.pandahamster;

import org.jbox2d.common.Vec2;

/**
 * Keeps track of the mouse position on the screen.
 */
public final class MousePositionTracker {
    private static Vec2 mouseLocation = new Vec2(0, 0);
    private MousePositionTracker() { }
    /**
     * Returns the current mouse location.
     * @return the current mouse location as a Point2D
     */
    public static Vec2 getMouseLocation() {
        return mouseLocation;
    }
    /**
     * Updates the current mouse location to the specified position.
     * @param x
     * @param y
     */
    public static void setMouseLocation(final double x, final  double y) {
        mouseLocation.set((float) x, (float) y);
    }
}
