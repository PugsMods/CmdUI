package com.putopug.cmdui;

import com.putopug.cmdui.config.DataEngine;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * @author PugzAreCute
 */
public class Listener implements org.bukkit.event.Listener {
    public static CmdUI plugin;
    public Listener(CmdUI ins) {
        plugin=ins;
    }

    @EventHandler
    public void onClickInInv(InventoryClickEvent event) {
        if (!event.getInventory().equals(Inventory.inventory)) return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        for (Object x : DataEngine.slts.getSlots().keySet()) {
            int slotint = Integer.parseInt(x.toString().replaceAll("slot_", ""));
            if(DataEngine.slts.getSlots().get(x.toString()).getPermissionNode().equalsIgnoreCase("")){
                if (event.getSlot() == slotint) {
                    if (DataEngine.slts.getSlots().get(x.toString()).getCommand().equals("${cmdui.utils.tp_to_world_spawn}")) {
                        player.teleport(event.getWhoClicked().getWorld().getSpawnLocation());
                        return;
                    } else {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), DataEngine.slts.getSlots().get(x.toString()).getCommand().replaceAll("\\$\\{player_name}", player.getDisplayName()));
                    }
                }
            }
            else if (player.hasPermission(DataEngine.slts.getSlots().get(x.toString()).getPermissionNode())) {
                if (event.getSlot() == slotint) {
                    if (DataEngine.slts.getSlots().get(x.toString()).getCommand().equals("${cmdui.utils.tp_to_world_spawn}")) {
                        player.teleport(event.getWhoClicked().getWorld().getSpawnLocation());
                        return;
                    } else {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), DataEngine.slts.getSlots().get(x.toString()).getCommand().replaceAll("\\$\\{player_name}", player.getDisplayName()));
                    }
                }
            } else {
                player.sendMessage("You do not have permission to use that command!");
            }
        }
    }
}
