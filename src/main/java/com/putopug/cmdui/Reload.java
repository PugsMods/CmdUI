package com.putopug.cmdui;

import com.putopug.cmdui.config.DataEngine;
import com.putopug.cmdui.config.DeJsonizer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author PugzAreCute
 */
public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        DataEngine.init();
        DeJsonizer.init();
        sender.sendMessage("Reload Complete!");
        return false;
    }
}
