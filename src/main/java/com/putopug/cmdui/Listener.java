package com.putopug.cmdui;

import com.putopug.cmdui.config.DeJsonizer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * @author PugzAreCute
 */
public class Listener implements org.bukkit.event.Listener {
    @EventHandler
    public void onClickInInv(InventoryClickEvent event) {
        if (!event.getInventory().equals(Inventory.inventory)) return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        for (Object x: DeJsonizer.slts.getSlots().keySet()){
            if(event.getSlot() == Integer.parseInt(x.toString().replaceAll("slot_",""))){
                if(!(DeJsonizer.slts.getSlots().get(x.toString()).getCommand().equals("${cmdui.utils.tp_to_world_spawn}"))){
                    player.teleport(event.getWhoClicked().getWorld().getSpawnLocation());
                    return;
                }else{
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),DeJsonizer.slts.getSlots().get(x.toString()).getCommand().replaceAll("\\$\\{player_name}",player.getDisplayName()));
                }
            }
        }
    }
}
