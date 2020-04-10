package com.plugin.Events.Hub;

import com.plugin.Constants.defaultValues;
import com.plugin.Items.ItemAPI;
import com.plugin.MainPlugin;
import com.plugin.PluginMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class ServerSelector implements Listener {

    @EventHandler
    public static void rclick(PlayerInteractEvent e) {
        if(e.getItem().getItemMeta().getDisplayName().contains("Server Selector")) {
            Inventory serverSelector = Bukkit.createInventory(null, 9 * 6, ChatColor.translateAlternateColorCodes('&', "&9Server Selector"));
            e.getPlayer().openInventory(serverSelector);
        }
    }

    @EventHandler
    public static void openInv(InventoryOpenEvent e) {
        defaultValues.reloadServerPlayers("Hub");
        if(e.getView().getTitle().equals("Server Selector") && defaultValues.serverPlayers.get("Hub").contains(e.getPlayer().getName())) {
            for(int i = 0; i < 9 * 6; i++) {
                e.getInventory().setItem(i, ItemAPI.createGuiItem(Material.matchMaterial(MainPlugin.getInstance().getConfig().getString("ServerSelector." + i + ".Material", "AIR")), MainPlugin.getInstance().getConfig().getString("ServerSelector." + i + ".Name", "")));
            }
        }
    }


    @EventHandler
    public static void clickInv(InventoryClickEvent e) {
        defaultValues.reloadServerPlayers("Hub");
        if(e.getView().getTitle().equals("Server Selector") && defaultValues.serverPlayers.get("Hub").contains(e.getWhoClicked().getName())) {
            e.setCancelled(true);
            int index = -1;
            for(int i = 0; i < 9 * 6; i++) {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(MainPlugin.getInstance().getConfig().getString("ServerSelector." + i + ".Name", ""))) {
                    index = i;
                    break;
                }
            }
            if(index != -1) {
                PluginMessage.connect((Player) e.getWhoClicked(), MainPlugin.getInstance().getConfig().getString("ServerSelector." + index + ".Server", "Hub"));
                e.getWhoClicked().closeInventory();
            }

        }
    }

}
