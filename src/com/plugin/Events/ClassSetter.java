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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.plugin.Class.ClassAPI;
import com.plugin.Class.Classes;
import com.plugin.Perks.PerksAPI;
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
		}
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
		if(title.contains("Choose Class")) {
			e.setCancelled(true);
			String name = stack.getItemMeta().getDisplayName();
			for(Classes c : ClassAPI.classesList) {
				if(name.split(" ")[0].contains(ClassAPI.classToString(c))) {
					showConfirmClassInv(c, p);
				}
			}
		}
		
		if(title.contains("Confirm being a ")) {
			e.setCancelled(true);
			String name = stack.getItemMeta().getDisplayName();
			if(name.contains("Confirm")) {
				p.closeInventory();
				p.getInventory().clear();
				String choseClass = title.split(" ")[3].substring(0, title.split(" ")[3].length() - 1);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6You became a " + choseClass + "."));
				ClassAPI.setClass(p, ClassAPI.stringToClass(choseClass));
				giveItem(p, ClassAPI.stringToClass(choseClass));
			}
			if(name.contains("Deny")) {
				p.closeInventory();
			}
		}
	}
	
	private static void giveItem(Player p, Classes c) {
		if(c.equals(Classes.ASSASSIN)) {
			p.getInventory().addItem(ClassDefaultItems.AssassinSword());
			PerksAPI.givePerk(p, "Swift as the Wind");
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
			p.getInventory().addItem(ClassDefaultItems.RangerCrossbow());
			p.getInventory().addItem(ClassDefaultItems.Arrows());
			PerksAPI.givePerk(p, "Swift as the Wind");
		}
		if(c.equals(Classes.SENTINEL)) {
			p.getInventory().addItem(ClassDefaultItems.SentinelBow());
			p.getInventory().addItem(ClassDefaultItems.Arrows());
		}
		if(c.equals(Classes.TANK)) {
			p.getInventory().addItem(ClassDefaultItems.TankShield());
		}
		if(c.equals(Classes.WARRIOR)) {
			p.getInventory().addItem(ClassDefaultItems.WarriorSword());
		}
		if(c.equals(Classes.PALADIN)) {
			PerksAPI.givePerk(p, "Swift as the Wind");
		}
		
	}
	
	private static void showConfirmClassInv(Classes c, Player p) {
		Inventory conInv = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', "&8Confirm being a " + ClassAPI.classToString(c) + "?"));
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
	
}
