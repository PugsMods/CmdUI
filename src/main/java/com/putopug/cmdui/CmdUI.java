package com.putopug.cmdui;

import com.putopug.cmdui.config.DataEngine;
import com.putopug.cmdui.config.DeJsonizer;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author PugzAreCute
 */
public final class CmdUI extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("cmdui").setExecutor(new UICmd());
        this.getServer().getPluginManager().registerEvents(new Listener(), this);
        this.saveDefaultConfig();
        DataEngine.init();
        DeJsonizer.init();
    }
    @Override
    public void onDisable() {
    }
}
