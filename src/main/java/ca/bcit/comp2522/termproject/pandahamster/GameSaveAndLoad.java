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
        HashMap<String, Integer> save = gson.fromJson(jsonReader, HashMap.class);
        Player.getInstance().setCurrentHealth(save.get("currentHealth"));
        Base.getInstance().setHealth(save.get("baseHealth"));
    }
    public static void save() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader(PandaHamster.class.getResource("/save/savefile.json").getFile()));
        HashMap<String, Integer> save = gson.fromJson(jsonReader, HashMap.class);
        save.put("currentHealth", Player.getInstance().getCurrentHealth());
        save.put("currentWave", AlienWaveGenerator.getInstance(GameMap.getMapHeight(), GameMap.getMapWidth()).getCurrentWave());
        save.put("baseHealth", (int) Base.getInstance().getHealth());
    }
}
