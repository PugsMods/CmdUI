package com.putopug.cmdui;

import com.putopug.cmdui.config.DataEngine;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Locale;
import java.util.logging.Level;

/**
 * @author PugzAreCute
 */
public class Inventory {
    public static org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 27, DataEngine.slts.getUiTitle());;

    public static void init() {
        ItemStack itemStack = new ItemStack(Material.AIR);
        ItemMeta meta;

        for (Object x : DataEngine.slts.getSlots().keySet()) {
            if (Material.getMaterial(DataEngine.slts.getSlots().get(x.toString()).getItem().replaceAll("minecraft:", "").toUpperCase(Locale.ROOT)) != null) {
                itemStack.setType(Material.getMaterial(DataEngine.slts.getSlots().get(x.toString()).getItem().replaceAll("minecraft:", "").toUpperCase(Locale.ROOT)));
            } else {
                Bukkit.getLogger().log(Level.SEVERE, "Oops! did you make a mistake for " + x + "'s item? " + DataEngine.slts.getSlots().get(x.toString()).getItem() + " in not a valid item");
            }
            meta = itemStack.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(DataEngine.slts.getSlots().get(x.toString()).getDisplayName());
            } else {
                Bukkit.getLogger().log(Level.SEVERE, "Some error occurred, please check slots.json");
            }
            if (meta != null) {
                meta.setLore(DataEngine.slts.getSlots().get(x.toString()).getLore().getLore());
            } else {
                Bukkit.getLogger().log(Level.SEVERE, "Some error occurred, please check slots.json");
            }
            itemStack.setItemMeta(meta);
            inventory.setItem(Integer.parseInt(x.toString().replaceAll("slot_", "")), itemStack);
        }
    }
}
