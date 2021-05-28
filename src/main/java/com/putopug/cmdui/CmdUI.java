package com.putopug.cmdui;

import com.putopug.cmdui.config.DataEngine;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author PugzAreCute
 */
public final class CmdUI extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("cmdui").setExecutor(new UICmd());
        getCommand("cmdreload").setExecutor(new Reload());
        this.getServer().getPluginManager().registerEvents(new Listener(), this);
        this.saveDefaultConfig();
        DataEngine.init();
    }
    @Override
    public void onDisable() {
    }
}
