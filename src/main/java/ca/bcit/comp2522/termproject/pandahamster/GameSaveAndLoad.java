package ca.bcit.comp2522.termproject.pandahamster;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.HashMap;

public final class GameSaveAndLoad {
    private GameSaveAndLoad() { }
    public static void load() throws IOException {
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader(PandaHamster.class.getResource("/save/savefile.json").getFile()));
        HashMap<String, Double> save = gson.fromJson(jsonReader, HashMap.class);
        final double savedPlayerHealth = save.get("currentHealth");
        final double savedBaseHealth = save.get("baseHealth");
        final double savedCurrentWave = save.get("currentWave");
        final double playerX = save.get("x");
        final double playerY = save.get("y");
        Player.getInstance().setCurrentHealth((int) savedPlayerHealth);
        Player.getInstance().setXPosition((float) playerX);
        Player.getInstance().setYPosition((float) playerY);
        Base.getInstance().setHealth((int) savedBaseHealth);
        AlienWaveGenerator.getInstance(GameMap.getMapHeight(), GameMap.getMapWidth()).setCurrentWave((int) savedCurrentWave);
    }
    public static void save() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader(PandaHamster.class.getResource("/save/savefile.json").getFile()));
        HashMap<String, Double> save = gson.fromJson(jsonReader, HashMap.class);
        save.put("currentHealth", (double) Player.getInstance().getCurrentHealth());
        save.put("currentWave", (double) AlienWaveGenerator.getInstance(GameMap.getMapHeight(), GameMap.getMapWidth()).getCurrentWave());
        save.put("baseHealth", (double) Base.getInstance().getHealth());
        save.put("x", (double) Player.getInstance().getXPosition());
        save.put("y", (double) Player.getInstance().getYPosition());
    }
}
