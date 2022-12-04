package ca.bcit.comp2522.termproject.pandahamster;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.HashMap;

public final class GameSaveAndLoad {
    private GameSaveAndLoad() { }
    public class SaveFile {
        public double currentHealth;
        public double currentWave;
        public double baseHealth;
        public double x;
        public double y;
    }
    public static void load() throws IOException {
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader(PandaHamster.class.getResource("/save/savefile.json").getFile()));
        SaveFile save = gson.fromJson(jsonReader, SaveFile.class);
        System.out.println(save.x);
        final double savedPlayerHealth = save.currentHealth;
        final double savedBaseHealth = save.baseHealth;
        final double savedCurrentWave = save.currentWave;
        final double playerX = save.x;
        final double playerY = save.y;
        Player.getInstance().setCurrentHealth((int) savedPlayerHealth);
        Player.getInstance().setXPosition((float) playerX);
        Player.getInstance().setYPosition((float) playerY);
        Base.getInstance().setHealth((int) savedBaseHealth);
        AlienWaveGenerator.getInstance(GameMap.getMapHeight(), GameMap.getMapWidth()).setCurrentWave((int) savedCurrentWave);
    }
    public static void save() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader(PandaHamster.class.getResource("/save/savefile.json").getFile()));
        SaveFile save = gson.fromJson(jsonReader, SaveFile.class);
        save.currentHealth = Player.getInstance().getCurrentHealth();
        save.currentWave = AlienWaveGenerator.getInstance(GameMap.getMapHeight(), GameMap.getMapWidth()).getCurrentWave();
        save.baseHealth = Base.getInstance().getHealth();
        save.x = Player.getInstance().getXPosition();
        save.y = Player.getInstance().getYPosition();
        try (OutputStream outputStream = new FileOutputStream(PandaHamster.class.getResource("/save/savefile.json").getPath())) {
            outputStream.write(gson.toJson(save).getBytes());
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Illegal IO operation");
        }
    }
}
