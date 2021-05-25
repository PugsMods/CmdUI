package com.putopug.cmdui;

import com.putopug.cmdui.config.DataEngine;
import org.bukkit.plugin.java.JavaPlugin;

public final class CmdUI extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("cmdui").setExecutor(new UICmd());
        this.getServer().getPluginManager().registerEvents(new Listener(), this);
        this.saveDefaultConfig();
        DataEngine.init();
        Inventory.init();
    }

    @Override
    public void onDisable() {
    }
}
