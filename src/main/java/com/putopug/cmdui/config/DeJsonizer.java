package com.putopug.cmdui.config;

import com.google.gson.Gson;
import com.putopug.cmdui.Inventory;
import org.bukkit.Bukkit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DeJsonizer {
    public static Slots slts;

    public static void init() {
        Gson gson = new Gson();

            try {
                slts = gson.fromJson(new BufferedReader(new FileReader(Bukkit.getServer().getPluginManager().getPlugin("CmdUI").getDataFolder()+"\\slots.json")), Slots.class);
                Inventory.init();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

    }
}
