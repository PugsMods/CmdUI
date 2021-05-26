package com.putopug.cmdui;

import com.putopug.cmdui.config.DeJsonizer;
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
    public static org.bukkit.inventory.Inventory inventory;
    public static void init(){
        inventory = Bukkit.createInventory(null, 27, DeJsonizer.slts.getUiTitle());
        ItemStack itemStack = new ItemStack(Material.AIR);
        ItemMeta meta;

        for (Object x : DeJsonizer.slts.getSlots().keySet()) {
            if(Material.getMaterial(DeJsonizer.slts.getSlots().get(x.toString()).getItem().replaceAll("minecraft:","").toUpperCase(Locale.ROOT)) != null){
            itemStack.setType(Material.getMaterial(DeJsonizer.slts.getSlots().get(x.toString()).getItem().replaceAll("minecraft:","").toUpperCase(Locale.ROOT)));
            }else{
                Bukkit.getLogger().log(Level.SEVERE,"Oops! dod you make a mistake for "+x+"'s item? "+Material.getMaterial(DeJsonizer.slts.getSlots().get(x.toString()).getItem().replaceAll("minecraft:",""))+" in not a valid item");
            }
            meta = itemStack.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(DeJsonizer.slts.getSlots().get(x.toString()).getDisplayName());
            }else {
                Bukkit.getLogger().log(Level.SEVERE,"Some error occurred, please check sots.json");
            }
            if (meta != null) {
                meta.setLore(DeJsonizer.slts.getSlots().get(x.toString()).getLore().getLore());
            }else {
                Bukkit.getLogger().log(Level.SEVERE,"Some error occurred, please check sots.json");
            }
            itemStack.setItemMeta(meta);
            inventory.setItem(Integer.parseInt(x.toString().replaceAll("slot_","")),itemStack);
        }
    }
}
