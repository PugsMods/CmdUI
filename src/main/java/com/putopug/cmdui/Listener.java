package com.putopug.cmdui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Listener implements org.bukkit.event.Listener {
    @EventHandler
    public void onClickInInv(InventoryClickEvent event) {
        if (!event.getInventory().equals(Inventory.inventory)) return;
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        if (event.getSlot() == 13) {
            player.teleport(event.getWhoClicked().getWorld().getSpawnLocation());
        }
    }
}
