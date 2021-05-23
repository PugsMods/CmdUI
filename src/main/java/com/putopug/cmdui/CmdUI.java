package com.putopug.cmdui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class CmdUI extends JavaPlugin {

    public static Inventory inventory;
    @Override
    public void onEnable() {
        getCommand("cmdui").setExecutor(new UICmd());
        this.getServer().getPluginManager().registerEvents(new Listener(),this);
        invStuff();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void invStuff(){
        inventory = Bukkit.createInventory(null,27,"Tp menu");

        ItemStack item = new ItemStack(Material.COMPASS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED+"Spawn");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GOLD+"Click to TP!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inventory.setItem(13,item);
    }
}
