package com.putopug.cmdui;

import com.google.gson.Gson;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DeJsonizer {
    Gson gson = new Gson();
    public static Slots slts;

    {
        try {
            slts = gson.fromJson(new FileReader(Bukkit.getServer().getPluginManager().getPlugin("CmdUI").getDataFolder()+"/slots.json"),Slots.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
