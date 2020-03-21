package com.plugin.Events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.plugin.MainPlugin;
import com.plugin.Class.ClassAPI;
import com.plugin.Class.ClassTypes;
import com.plugin.Class.Classes;
import com.plugin.Perks.PerksAPI;
import com.plugin.Rank.RankAPI;
import com.plugin.String.StringAPI;
import com.plugin.items.ClassDefaultItems;
import com.plugin.items.GUIItems;
import com.plugin.items.ItemAPI;

public class ClassSetter implements Listener {
	
	@EventHandler
	public static void rclick(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			
			if(p.getInventory().getItemInMainHand().toString().contains("Choose Class ")) {
				createAndOpenInv(p);
			}
			if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "AuroraMC Menu")) {
				Inventory inv = Bukkit.createInventory(null, 9 * 6, ChatColor.translateAlternateColorCodes('&', "AuroraMC Menu"));
				inv.clear();
				for(int i = 0; i < 9; i++) {
					inv.setItem(i, GUIItems.getBlankItem());
				}
				
				for(int i = 18; i < 27; i++) {
					inv.setItem(i, GUIItems.getBlankItem());
				}
				
				for(int i = 9; i < 45; i++) {
					if(i % 9 == 0 || i % 9 == 8) {
						inv.setItem(i, GUIItems.getBlankItem());
					}
					
				}
				
				for(int i = 45; i < 54; i++) {
					inv.setItem(i, GUIItems.getBlankItem());
				}
				
				inv.setItem(13, ItemAPI.createHeadItem("&b" + p.getDisplayName(), p.getDisplayName()));
				inv.setItem(12, GUIItems.getBlankItem());
				inv.setItem(14, GUIItems.getBlankItem());
				inv.setItem(11, ItemAPI.createGuiItem(Material.IRON_SWORD, "&6Class: &d" + ClassAPI.classToString(ClassAPI.getClass(p))));
				inv.setItem(15, ItemAPI.createGuiItem(Material.BLUE_DYE, "&6Rank: &d" + RankAPI.rankToString(RankAPI.getRank(p))));
				inv.setItem(10, ItemAPI.createGuiItem(Material.ACACIA_FENCE_GATE, "&6Joins: &d" + MainPlugin.getPlugin(MainPlugin.class).getConfig().getInt(p.getUniqueId() + ".Joins", 0)));
				inv.setItem(16, ItemAPI.createGuiItem(Material.NAME_TAG, "&6Rank Prefix: &d" + RankAPI.getRank(p).getPrefix()));
				inv.addItem(ItemAPI.createGuiItem(Material.REDSTONE, "&6My Unlocked Perks"));
				inv.addItem(ItemAPI.createGuiItem(Material.ENDER_CHEST, "&6Ender Chest"));
				inv.addItem(ItemAPI.createGuiItem(Material.CRAFTING_TABLE, "&6Workbench"));
				p.openInventory(inv);
				
			}
		}
	}
	
	@EventHandler
	public static void drop(PlayerDropItemEvent e) {
		if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "AuroraMC Menu")) {
			e.setCancelled(true);
		}
	}
	
	public static void createAndOpenInv(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9 * 4, ChatColor.translateAlternateColorCodes('&', "&8Choose Class"));
		inv.clear();
		for(int i = 0; i < 9; i++) {
			inv.setItem(i, GUIItems.getBlankItem());
		}
		inv.setItem(9, GUIItems.getBlankItem());
		inv.setItem(17, GUIItems.getBlankItem());
		inv.setItem(18, GUIItems.getBlankItem());
		inv.setItem(26, GUIItems.getBlankItem());
		
		for(int i = 27; i < 36; i++) {
			inv.setItem(i, GUIItems.getBlankItem());
		}
		addClassToInventory(inv, Classes.MAGE, Material.STICK, ChatColor.DARK_PURPLE);
		addClassToInventory(inv, Classes.ASSASSIN, Material.IRON_SWORD, ChatColor.DARK_GRAY);
		addClassToInventory(inv, Classes.PALADIN, Material.STONE_SWORD, ChatColor.LIGHT_PURPLE);
		addClassToInventory(inv, Classes.RANGER, Material.CROSSBOW, ChatColor.BLUE);
		addClassToInventory(inv, Classes.WARRIOR, Material.DIAMOND_SWORD, ChatColor.WHITE);
		addClassToInventory(inv, Classes.SENTINEL, Material.BOW, ChatColor.AQUA);
		addClassToInventory(inv, Classes.TANK, Material.SHIELD, ChatColor.DARK_AQUA);
		addClassToInventory(inv, Classes.PRIEST, Material.ENCHANTED_GOLDEN_APPLE, ChatColor.YELLOW);
		addClassToInventory(inv, Classes.NECROMANCER, Material.SKELETON_SKULL, ChatColor.DARK_BLUE);
		p.openInventory(inv);
	}
	
	/*
	 * 00 01 02 03 04 05 06 07 08
	 * 09 10 11 12 13 14 15 16 17
	 * 18 19 20 21 22 23 24 25 26
	 * 27 28 29 30 31 32 33 34 35
	 */
	
	private static void addClassToInventory(Inventory i, Classes c, Material icon, ChatColor cc) {
		ItemStack item = ItemAPI.createGuiItem(icon, cc + ClassAPI.classToString(c) + " &6(" + StringAPI.captalizeFirstLetter(c.getType().toString()) + ")");
		List<String> lores = new ArrayList<String>();
		lores.add(ChatColor.translateAlternateColorCodes('&', "&cAttack: &6" + c.getAttack() + "/5"));
		lores.add(ChatColor.translateAlternateColorCodes('&', "&eDefense: &6" + c.getDefense() + "/5"));
		lores.add(ChatColor.translateAlternateColorCodes('&', "&dMagic: &6" + c.getMagic() + "/5"));
		lores.add(ChatColor.translateAlternateColorCodes('&', "&bSpeed: &6" + c.getSpeed() + "/5"));
		lores.add(ChatColor.translateAlternateColorCodes('&', "&aHealing: &6" + c.getHeal() + "/5"));
		ItemMeta meta = item.getItemMeta();
		meta.setLore(lores);
		item.setItemMeta(meta);
		i.addItem(item);
	}
	
	@EventHandler
	public static void selClass(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		String title = e.getView().getTitle();
		ItemStack stack = e.getCurrentItem();
		
		if(title.contains("AuroraMC Menu")) {
			e.setCancelled(true);
			if(stack.getItemMeta().getDisplayName().contains("My Unlocked Perks")) {
				Inventory inv = Bukkit.createInventory(null, 9 * 1, ChatColor.translateAlternateColorCodes('&', "AuroraMC Menu: Perks Category"));
				inv.clear();
				for(int i = 0; i < 9; i++) {
					inv.setItem(i, GUIItems.getBlankItem());
				}
				inv.setItem(1, ItemAPI.createGuiItem(Material.FEATHER, "&bMovement Perks"));
				inv.setItem(3, ItemAPI.createGuiItem(Material.IRON_SWORD, "&cDamage Perks"));
				inv.setItem(5, ItemAPI.createGuiItem(Material.SHIELD, "&eDefense Perks"));
				inv.setItem(7, ItemAPI.createGuiItem(Material.STICK, "&dMagic Perks"));
				p.openInventory(inv);
				
			}
			if(stack.getItemMeta().getDisplayName().contains("Movement Perks")) {
				Inventory inv = Bukkit.createInventory(null, 9 * 6, ChatColor.translateAlternateColorCodes('&', "AuroraMC Menu: Movement Perks"));
				inv.clear();
				putItemsToMovementPerksInv(inv, p);
				p.openInventory(inv);
				
			}
			if(stack.getItemMeta().getDisplayName().contains("Damage Perks")) {
				Inventory inv = Bukkit.createInventory(null, 9 * 6, ChatColor.translateAlternateColorCodes('&', "AuroraMC Menu: Damage Perks"));
				inv.clear();
				putItemsToDamagePerksInv(inv, p);
				p.openInventory(inv);
				
			}
			if(stack.getItemMeta().getDisplayName().contains("Defense Perks")) {
				Inventory inv = Bukkit.createInventory(null, 9 * 6, ChatColor.translateAlternateColorCodes('&', "AuroraMC Menu: Defense Perks"));
				inv.clear();
				putItemsToDefensePerksInv(inv, p);
				p.openInventory(inv);
				
			}
			
			if(stack.getItemMeta().getDisplayName().contains("Ender Chest")) {
				
				p.openInventory(p.getEnderChest());
				
			}
			
			if(stack.getItemMeta().getDisplayName().contains("Workbench")) {
				
				p.openWorkbench(null, true);
				
			}
			if(stack.getItemMeta().getDisplayName().contains("Secret Accessibility: ON")) {
				
				PerksAPI.givePerk(p, "Secret Accessibility: OFF");
				PerksAPI.removePerk(p, "Secret Accessibility: ON");
				
				Inventory inv = Bukkit.createInventory(null, 9 * 6, ChatColor.translateAlternateColorCodes('&', "AuroraMC Menu: Movement Perks"));
				inv.clear();
				putItemsToMovementPerksInv(inv, p);
				p.openInventory(inv);
				
			}
			if(stack.getItemMeta().getDisplayName().contains("Secret Accessibility: OFF")) {
				
				PerksAPI.givePerk(p, "Secret Accessibility: ON");
				PerksAPI.removePerk(p, "Secret Accessibility: OFF");
				
				Inventory inv = Bukkit.createInventory(null, 9 * 6, ChatColor.translateAlternateColorCodes('&', "AuroraMC Menu: Movement Perks"));
				inv.clear();
				putItemsToMovementPerksInv(inv, p);
				p.openInventory(inv);
				
			}
		}
		if(stack.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "AuroraMC Menu")) {
			e.setCancelled(true);
		}
		if(title.contains("Choose Class")) {
			e.setCancelled(true);
			String name = stack.getItemMeta().getDisplayName();
			for(Classes c : ClassAPI.classesList) {
				if(name.split(" ")[0].contains(ClassAPI.classToString(c))) {
					showConfirmClassInv(c, p);
				}
			}
		}
		
		if(title.contains("Confirm being a(n) ")) {
			e.setCancelled(true);
			String name = stack.getItemMeta().getDisplayName();
			if(name.contains("Confirm")) {
				p.closeInventory();
				p.getInventory().clear();
				String choseClass = title.split(" ")[3].substring(0, title.split(" ")[3].length() - 1);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6You became a(n) " + choseClass + "."));
				ClassAPI.setClass(p, ClassAPI.stringToClass(choseClass));
				giveItem(p, ClassAPI.stringToClass(choseClass));
			}
			if(name.contains("Deny")) {
				createAndOpenInv(p);
			}
		}
	}
	
	private static void giveItem(Player p, Classes c) {
		PerksAPI.removeAllPerks(p);
		p.getInventory().setItem(8, ItemAPI.createGuiItem(Material.NETHER_STAR, "&dAuroraMC Menu"));
		PerksAPI.givePerk(p, "Speed Diversity");
		PerksAPI.givePerk(p, "Attack Diversity");
		PerksAPI.givePerk(p, "Defense Diversity");
		if(c.equals(Classes.ASSASSIN)) {
			p.getInventory().addItem(ClassDefaultItems.AssassinKnife());
			PerksAPI.givePerk(p, "Secret Accessibility: ON");
		}
		if(c.equals(Classes.MAGE)) {
			p.getInventory().addItem(ClassDefaultItems.MageBasicStaff());
		}
		if(c.equals(Classes.NECROMANCER)) {
			p.getInventory().addItem(ClassDefaultItems.NecromancerSummonerWand());
			
		}
		if(c.equals(Classes.PRIEST)) {
			p.getInventory().addItem(ClassDefaultItems.PriestStaff());
		}
		if(c.equals(Classes.RANGER)) {
			p.getInventory().addItem(ClassDefaultItems.RangerCrossBow());
			p.getInventory().addItem(ClassDefaultItems.RangerKnife());
			p.getInventory().addItem(ClassDefaultItems.HArrows());
			//PerksAPI.givePerk(p, "Swift as the Wind");
		}
		if(c.equals(Classes.SENTINEL)) {
			p.getInventory().addItem(ClassDefaultItems.SentinelBow());
			p.getInventory().addItem(ClassDefaultItems.SentinelCrossbow());
			p.getInventory().addItem(ClassDefaultItems.Arrows());
			p.getInventory().addItem(ClassDefaultItems.Arrows());
		}
		if(c.equals(Classes.TANK)) {
			p.getInventory().addItem(ClassDefaultItems.TankShield());
		}
		if(c.equals(Classes.WARRIOR)) {
			p.getInventory().addItem(ClassDefaultItems.WarriorSword());
			PerksAPI.givePerk(p, "Sword Master");
		}
		if(c.equals(Classes.PALADIN)) {
//			PerksAPI.givePerk(p, "Swift as the Wind");
		}
		if(c.getType().equals(ClassTypes.TANK)) {
			PerksAPI.givePerk(p, "Tough Skin");
		}
		
	}
	
	private static void showConfirmClassInv(Classes c, Player p) {
		Inventory conInv = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', "&8Confirm being a(n) " + ClassAPI.classToString(c) + "?"));
		conInv.setItem(0, GUIItems.getBlankItem());
		conInv.setItem(1, GUIItems.getBlankItem());
		conInv.setItem(2, GUIItems.getBlankItem());
		conInv.setItem(4, GUIItems.getBlankItem());
		conInv.setItem(6, GUIItems.getBlankItem());
		conInv.setItem(7, GUIItems.getBlankItem());
		conInv.setItem(8, GUIItems.getBlankItem());
		conInv.setItem(3, ItemAPI.createGuiItem(Material.LIME_CONCRETE, "&aConfirm"));
		conInv.setItem(5, ItemAPI.createGuiItem(Material.RED_CONCRETE, "&cDeny"));
		p.openInventory(conInv);
	}
	
	private static void putItemsToMovementPerksInv(Inventory inv, Player p) {
		addMovementPerksToInv(inv, p, "Speed Diversity", "&f&lCOMMON", Material.FEATHER, "&aAll Classes", "&bPassive", "Speed Differs By Class");
		addMovementPerksToInv(inv, p, "Secret Accessibility: ON", "&f&lCOMMON", Material.COAL, "&8Assassin", "&cToggle", "Higher Jumps & Click to Turn Off");
		addMovementPerksToInv(inv, p, "Secret Accessibility: OFF", "&f&lCOMMON", Material.COAL, "&8Assassin", "&cToggle", "Higher Jumps & Click to Turn On");
	}
	
	private static void addMovementPerksToInv(Inventory inv, Player p, String perkName, String commonity, Material icon, String classes, String type, String desc) {
		if(PerksAPI.hasPerk(p, perkName)) {
			ItemStack item = ItemAPI.createGuiItem(icon, "&6" + perkName);
			List<String> lores = new ArrayList<String>();
			lores.add(ChatColor.translateAlternateColorCodes('&', commonity + " MOVEMENT PERK"));
			lores.add(ChatColor.translateAlternateColorCodes('&', "&6Needed Class(es): " + classes));
			lores.add(ChatColor.translateAlternateColorCodes('&', "&eType: " + type));
			lores.add(ChatColor.translateAlternateColorCodes('&', "&aDescription: "));
			lores.add(ChatColor.translateAlternateColorCodes('&', "&7" + desc));
			ItemMeta meta = item.getItemMeta();
			meta.setLore(lores);
			item.setItemMeta(meta);
			inv.addItem(item);
		}
	}
	

	
	private static void putItemsToDamagePerksInv(Inventory inv, Player p) {
		addDamagePerksToInv(inv, p, "Attack Diversity", "&f&lCOMMON", Material.GOLDEN_SWORD, "&aAll Classes", "&bPassive", "Attack Damage Differs By Class");
		addDamagePerksToInv(inv, p, "Sword Master", "&f&lCOMMON", Material.DIAMOND_SWORD, "&6Melee&f/&bHybrid &aClasses", "&bPassive", "10% More Damage When Using Swords");
	}
	
	private static void addDamagePerksToInv(Inventory inv, Player p, String perkName, String commonity, Material icon, String classes, String type, String desc) {
		if(PerksAPI.hasPerk(p, perkName)) {
			ItemStack item = ItemAPI.createGuiItem(icon, "&6" + perkName);
			List<String> lores = new ArrayList<String>();
			lores.add(ChatColor.translateAlternateColorCodes('&', commonity + " DAMAGE PERK"));
			lores.add(ChatColor.translateAlternateColorCodes('&', "&6Needed Class(es): " + classes));
			lores.add(ChatColor.translateAlternateColorCodes('&', "&eType: " + type));
			lores.add(ChatColor.translateAlternateColorCodes('&', "&aDescription: "));
			lores.add(ChatColor.translateAlternateColorCodes('&', "&7" + desc));
			ItemMeta meta = item.getItemMeta();
			meta.setLore(lores);
			item.setItemMeta(meta);
			inv.addItem(item);
		}
	}
	
	private static void putItemsToDefensePerksInv(Inventory inv, Player p) {
		addDefensePerksToInv(inv, p, "Defense Diversity", "&f&lCOMMON", Material.GOLDEN_SWORD, "&aAll Classes", "&bPassive", "Damage You Take Differs By Class");
		addDefensePerksToInv(inv, p, "Tough Skin", "&f&lCOMMON", Material.DIAMOND_SWORD, "&7Tank &aClasses", "&bPassive", "Takes 5% Less Damage");
	}
	
	private static void addDefensePerksToInv(Inventory inv, Player p, String perkName, String commonity, Material icon, String classes, String type, String desc) {
		if(PerksAPI.hasPerk(p, perkName)) {
			ItemStack item = ItemAPI.createGuiItem(icon, "&6" + perkName);
			List<String> lores = new ArrayList<String>();
			lores.add(ChatColor.translateAlternateColorCodes('&', commonity + " DEFENSE PERK"));
			lores.add(ChatColor.translateAlternateColorCodes('&', "&6Needed Class(es): " + classes));
			lores.add(ChatColor.translateAlternateColorCodes('&', "&eType: " + type));
			lores.add(ChatColor.translateAlternateColorCodes('&', "&aDescription: "));
			lores.add(ChatColor.translateAlternateColorCodes('&', "&7" + desc));
			ItemMeta meta = item.getItemMeta();
			meta.setLore(lores);
			item.setItemMeta(meta);
			inv.addItem(item);
		}
		
	}
	
	
	
	
}
