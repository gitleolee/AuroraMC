package com.plugin.Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.plugin.Trading;
import com.plugin.items.GUIItems;
import com.plugin.items.ItemAPI;

import net.md_5.bungee.api.ChatColor;

public class TradeEvents implements Listener {
	
	public static HashMap<Trading, Integer> tradeCooldown = new HashMap<Trading, Integer>();
	public static List<UUID> closedFirst = new ArrayList<UUID>();
	
	
	@EventHandler
	public static void openInventory(InventoryOpenEvent e) {
		// Player opener = (Player) e.getPlayer();
		String title = e.getView().getTitle();
		Inventory inv = e.getInventory();
		if(title.contains("Trade with ")) {
			for(int i = 18; i < 27; i++) {
				inv.setItem(i, GUIItems.getBlankItem());
			}
			inv.setItem(21, ItemAPI.createGuiItem(Material.LIME_WOOL, "&aAccept"));
			inv.setItem(22, ItemAPI.createGuiItem(Material.BARRIER, "&cClose"));
			inv.setItem(23, ItemAPI.createGuiItem(Material.REDSTONE_BLOCK, "&6Other: &cDidn't Accept"));
		}
	}
	
	@EventHandler
	public static void closeInventory(InventoryCloseEvent e) {
		String title = e.getView().getTitle();
		Player closer = (Player) e.getPlayer();
		if(title.contains("Trade with ")) {
			Player other = Bukkit.getPlayer(title.split(" ")[2]);
			if(closedFirst.contains(closer.getUniqueId())) {
				closedFirst.remove(closer.getUniqueId());
				return;
			} else {
				other.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6" + closer.getDisplayName() + " denied the trade."));
				closer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6You denied the trade with " + other.getDisplayName() + "."));
				closedFirst.add(other.getUniqueId());
				other.closeInventory();
				return;
				
			}	
		}
	}
	
	@EventHandler
	public static void click(InventoryClickEvent e) {
		String title = e.getView().getTitle();
		if(title.contains("Trade with ")) {
			ItemStack item = e.getCurrentItem();
			Player clicker = (Player) e.getWhoClicked();
			e.setCancelled(true);
			if(item.getItemMeta().getDisplayName().equals(ChatColor.RED + "Close")) {
				clicker.closeInventory();
			}
		}
	}
	
	
}
