package com.plugin.Events;

import org.bukkit.Axis;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.Orientable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import com.plugin.items.ClassDefaultItems;
import com.plugin.items.GUIItems;
import com.plugin.items.ItemAPI;

import net.md_5.bungee.api.ChatColor;

public class BuildersPro implements Listener {
	
	@EventHandler
	public static void click(InventoryClickEvent e) {
		if(e.getView().getTitle().equals("AuroraMC BuildersPro")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Extra Blocks")) {
				Inventory inv = Bukkit.createInventory(null, 9 * 3, "BuildersPro - Extra Blocks");
				e.getWhoClicked().openInventory(inv);
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Extra Items")) {
				Inventory inv = Bukkit.createInventory(null, 9, "BuildersPro - Item Categories");
				e.getWhoClicked().openInventory(inv);
			}
		}
		if(e.getView().getTitle().equals("BuildersPro - Extra Blocks")) {
			e.setCancelled(true);
			e.getWhoClicked().getInventory().addItem(e.getCurrentItem());
		}
		if(e.getView().getTitle().equals("BuildersPro - Items: Game")) {
			e.setCancelled(true);
			e.getWhoClicked().getInventory().addItem(e.getCurrentItem());
		}
		if(e.getView().getTitle().equals("BuildersPro - Item Categories")) {
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Game Items")) {
				Inventory inv = Bukkit.createInventory(null, 9 * 6, "BuildersPro - Items: Game");
				e.getWhoClicked().openInventory(inv);
			}
		}
	}
	
	@EventHandler
	public static void open(InventoryOpenEvent e) {
		if(e.getView().getTitle().equals("BuildersPro - Extra Blocks")) {
			Inventory inv = e.getInventory();
			inv.addItem(ItemAPI.createGuiItem(Material.BARRIER, "&6Barrier"));
			inv.addItem(ItemAPI.createGuiItem(Material.SPAWNER, "&6Mob Spawner"));
			inv.addItem(ItemAPI.createGuiItem(Material.PURPLE_STAINED_GLASS, "&6Nether Portal - X"));
			inv.addItem(ItemAPI.createGuiItem(Material.PURPLE_STAINED_GLASS, "&6Nether Portal - Z"));
			inv.addItem(ItemAPI.createGuiItem(Material.END_PORTAL_FRAME, "&6End Portal"));
			inv.addItem(ItemAPI.createGuiItem(Material.BLACK_CONCRETE, "&6End Gateway"));
		}
		if(e.getView().getTitle().equals("BuildersPro - Item Categories")) {
			Inventory inv = e.getInventory();
			inv.setItem(0, GUIItems.getBlankItem());
			inv.setItem(1, GUIItems.getBlankItem());
			inv.setItem(3, GUIItems.getBlankItem());
			inv.setItem(4, GUIItems.getBlankItem());
			inv.setItem(5, GUIItems.getBlankItem());
			inv.setItem(7, GUIItems.getBlankItem());
			inv.setItem(8, GUIItems.getBlankItem());
			inv.setItem(2, ItemAPI.createGuiItem(Material.COMPASS, "&aGame Items"));
			inv.setItem(6, ItemAPI.createHeadItem("&cOther Items", "Console"));
		}
		if(e.getView().getTitle().equals("BuildersPro - Items: Game")) {
			Inventory inv = e.getInventory();
			inv.addItem(ItemAPI.createGuiItem(Material.COMPASS, "&aChoose Class &7(RClick)"));
			inv.addItem(GUIItems.getBlankItem());
			inv.addItem(ClassDefaultItems.PriestStaff());
			inv.addItem(ClassDefaultItems.Arrows());
			inv.addItem(ClassDefaultItems.MageBasicStaff());
			inv.addItem(ClassDefaultItems.AssassinKnife());
			inv.addItem(ClassDefaultItems.SentinelCrossbow());
			inv.addItem(ClassDefaultItems.SentinelBow());
		}
	}
	
	@EventHandler
	public static void place(BlockPlaceEvent e) {
		if(e.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Nether Portal - X")) {
			e.getBlockPlaced().setType(Material.NETHER_PORTAL);
			Orientable rotatable = (Orientable) e.getBlockPlaced().getBlockData();
			
		    rotatable.setAxis(Axis.X);
		    e.getBlockPlaced().setBlockData(rotatable);
		}
		if(e.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Nether Portal - Z")) {
			e.getBlockPlaced().setType(Material.NETHER_PORTAL);
			Orientable rotatable = (Orientable) e.getBlockPlaced().getBlockData();
			
		    rotatable.setAxis(Axis.Z);
		    e.getBlockPlaced().setBlockData(rotatable);
		}
		if(e.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "End Portal")) {
			e.getBlockPlaced().setType(Material.END_PORTAL);
		    
		}
		if(e.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "End Gateway")) {
			e.getBlockPlaced().setType(Material.END_GATEWAY);
		    
		}
	}
	
}
