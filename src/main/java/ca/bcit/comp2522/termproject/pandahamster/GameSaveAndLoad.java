package ca.bcit.comp2522.termproject.pandahamster;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public final class GameSaveAndLoad {
    private GameSaveAndLoad() { }
    public static void readSaveFile() throws IOException {
        class Save {
            private int playerHealth;
            private int currentWave;
            private int baseHealth;
            public int getPlayerHealth() {
                return playerHealth;
            }
            public void setPlayerHealth(final int playerHealth) {
                this.playerHealth = playerHealth;
            }
            public int getCurrentWave() {
                return currentWave;
            }
            public void setCurrentWave(final int currentWave) {
                this.currentWave = currentWave;
            }
            public int getBaseHealth() {
                return baseHealth;
            }
            public void setBaseHealth(final int baseHealth) {
                this.baseHealth = baseHealth;
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Save save = objectMapper.readValue(PandaHamster.class.getResource("/save/savefile.json"), Save.class);
    }
}
