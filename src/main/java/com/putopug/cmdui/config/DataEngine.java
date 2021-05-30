package com.putopug.cmdui.config;

import com.google.gson.Gson;
import com.putopug.cmdui.Inventory;
import org.bukkit.Bukkit;

import java.io.*;
import java.util.logging.Level;

/**
 * @author PugzAreCute
 */
public class DataEngine {
    public static Slots slts;

    public static void init() {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("CmdUI").getDataFolder(), "slots.json");
        if (!file.exists()) {
            Bukkit.getLogger().log(Level.INFO, "Detected slots.json to be missing, generating....");
            try {
                file.createNewFile();
                FileWriter writer = new FileWriter(Bukkit.getServer().getPluginManager().getPlugin("CmdUI").getDataFolder() + File.separator + "slots.json");
                writer.write("{\n" +
                        "  \"slots\":{\n" +
                        "    \"slot_0\": {\n" +
                        "      \"command\": \"tp ${player_name} 0 100 0\",\n" +
                        "      \"item\": \"minecraft:compass\",\n" +
                        "      \"lore\": {\n" +
                        "        \"line_1\": \"Click on mee!\",\n" +
                        "        \"line_2\": \"\",\n" +
                        "        \"line_3\": \"\"\n" +
                        "      },\n" +
                        "      \"permission_node\": \"\",\n" +
                        "      \"displayName\": \"Hi!\"\n" +
                        "    },\n" +
                        "    \"slot_2\": {\n" +
                        "      \"command\": \"tp ${player_name} 0 100 0\",\n" +
                        "      \"item\": \"minecraft:compass\",\n" +
                        "      \"lore\": {\n" +
                        "        \"line_1\": \"Click on mee!\",\n" +
                        "        \"line_2\": \"\",\n" +
                        "        \"line_3\": \"\"\n" +
                        "      },\n" +
                        "      \"permission_node\": \"\",\n" +
                        "      \"displayName\": \"Tp to 0,100,0\"\n" +
                        "    },\n" +
                        "    \"slot_3\": {\n" +
                        "      \"command\": \"${cmdui.utils.tp_to_world_spawn}\",\n" +
                        "      \"item\": \"minecraft:dirt\",\n" +
                        "      \"lore\": {\n" +
                        "        \"line_1\": \"Click on mee!\",\n" +
                        "        \"line_2\": \"\",\n" +
                        "        \"line_3\": \"\"\n" +
                        "      },\n" +
                        "      \"permission_node\": \"\",\n" +
                        "      \"displayName\": \"Tp to wold spawn!\"\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"ui_title\": \"Menu\"\n" +
                        "}");
                Bukkit.getServer().getLogger().log(Level.INFO, "Successfully generated Default slots.json!");
            } catch (IOException e) {
                Bukkit.getLogger().log(Level.WARNING, "WARNING: Failed to create slots.json. Do i have permission to write?");
            }
        }
        Gson gson = new Gson();
        try {
            slts = gson.fromJson(new BufferedReader(new FileReader(Bukkit.getServer().getPluginManager().getPlugin("CmdUI").getDataFolder() + File.separator + "slots.json")), Slots.class);
            Inventory.init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}