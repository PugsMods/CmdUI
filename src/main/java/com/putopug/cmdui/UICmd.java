package com.putopug.cmdui;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author PugzAreCute
 */
public class UICmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Ya need to be a player to use this :/");
            return false;
        }
        Player player = (Player) sender;
        player.openInventory(Inventory.inventory);
        return true;
    }
}
