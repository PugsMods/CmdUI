package com.putopug.cmdui.config;

import com.google.gson.Gson;
import org.bukkit.Bukkit;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DeJsonizer {
    public static Slots slts;

    public static void init() {
        Gson gson = new Gson();
        {
            try {
                slts = gson.fromJson(new FileReader(Bukkit.getServer().getPluginManager().getPlugin("CmdUI").getDataFolder()+"\\slots.json"), Slots.class);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
