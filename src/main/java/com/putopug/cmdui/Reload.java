package com.putopug.cmdui;

import com.putopug.cmdui.config.DataEngine;
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
        sender.sendMessage("Reload Complete!");
        return true;
    }
}
