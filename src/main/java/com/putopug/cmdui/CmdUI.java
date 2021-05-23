package com.putopug.cmdui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class CmdUI extends JavaPlugin {

    public Inventory inventory;
    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void invStuff(){
        inventory = Bukkit.createInventory(null,27,"Tp menu");
    }
}
