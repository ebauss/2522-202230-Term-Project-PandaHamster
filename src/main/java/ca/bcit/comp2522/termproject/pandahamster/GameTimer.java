package ca.bcit.comp2522.termproject.pandahamster;

import javafx.animation.AnimationTimer;

/**
 * Keeps track of current game time in seconds.
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public final class GameTimer extends AnimationTimer {
    private static final float NANOSECONDS_TO_SECONDS = 1e+9f;
    private static final float MAX_FRAME_TIME_IN_SECONDS = 1000;
    static {
        new GameTimer().start();
    }
    private static float elapsedSeconds;
    private static float timerLastFrameInSeconds;
    private static float timerLastFrameElapsedTimeInNanoSeconds;
    private GameTimer() { }
    @Override
    public void handle(final long now) {
        timerLastFrameInSeconds = (now - timerLastFrameElapsedTimeInNanoSeconds) / NANOSECONDS_TO_SECONDS;
        timerLastFrameElapsedTimeInNanoSeconds = now;
        if (timerLastFrameInSeconds < MAX_FRAME_TIME_IN_SECONDS) {
            elapsedSeconds += timerLastFrameInSeconds;
        }
    }
    /**
     * Returns the elapsed time in seconds since the timer started.
     * @return elapsed time in seconds
     */
    public static float getElapsedSeconds() {
        return elapsedSeconds;
    }
}
