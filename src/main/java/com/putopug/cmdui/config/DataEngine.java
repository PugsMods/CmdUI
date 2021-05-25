package com.putopug.cmdui.config;

import org.bukkit.Bukkit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

public class DataEngine {
    public static void init() {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("CmdUI").getDataFolder(), "slots.json");
        if (!file.exists()) {
            Bukkit.getLogger().log(Level.INFO, "Detected slots.json to be missing, generating....");
            try {
                file.createNewFile();
                FileWriter writer = new FileWriter(Bukkit.getServer().getPluginManager().getPlugin("CmdUI").getDataFolder() + "\\slots.json");
                writer.write("{\n" +
                        "    \"slots\":{\n" +
                        "      \"slot_1\": {\n" +
                        "      \"command\": \"tp @s 0 100 0\",\n" +
                        "      \"item\": \"minecraft:compass\",\n" +
                        "      \"lore\": {\n" +
                        "        \"line_1\": \"Click on mee!\",\n" +
                        "        \"line_2\": \"\",\n" +
                        "        \"line_3\": \"\"\n" +
                        "      }\n" +
                        "    },\n" +
                        "  \"slot_2\": {\n" +
                        "    \"command\": \"tp @s 0 100 0\",\n" +
                        "    \"item\": \"minecraft:compass\",\n" +
                        "    \"lore\": {\n" +
                        "      \"line_1\": \"Click on mee!\",\n" +
                        "      \"line_2\": \"\",\n" +
                        "      \"line_3\": \"\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "  }\n" +
                        "  }");
                Bukkit.getServer().getLogger().log(Level.INFO, "Successfully generated Default slots.json!");
            } catch (IOException e) {
                Bukkit.getLogger().log(Level.WARNING, "WARNING: Failed to create slots.json. Do i have permission to write?");
            }
        }
    }
}