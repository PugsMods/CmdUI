package com.putopug.cmdui;

import com.putopug.cmdui.config.DeJsonizer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Locale;

/**
 * @author PugzAreCute
 */
public class Inventory {
    public static org.bukkit.inventory.Inventory inventory;
    public static void init(){
        inventory = Bukkit.createInventory(null, 27, "Tp menu");
        ItemStack itemStack = new ItemStack(Material.AIR);
        ItemMeta meta;

        for (Object x : DeJsonizer.slts.getSlots().keySet()) {
            itemStack.setType(Material.getMaterial(DeJsonizer.slts.getSlots().get(x).getItem().replaceAll("minecraft:","").toUpperCase(Locale.ROOT)));
            meta = itemStack.getItemMeta();
            meta.setDisplayName(DeJsonizer.slts.getSlots().get(x.toString()).getDisplayName());
            meta.setLore(DeJsonizer.slts.getSlots().get(x.toString()).getLore().getLore());
            itemStack.setItemMeta(meta);
            inventory.setItem(Integer.parseInt(x.toString().replaceAll("slot_","")),itemStack);
        }
    }
}
