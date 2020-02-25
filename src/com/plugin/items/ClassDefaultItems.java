package com.plugin.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ClassDefaultItems {
	public static ItemStack AssassinSword() {
		ItemStack item = ItemAPI.createGuiItem(Material.IRON_SWORD, "&fAssassin's Knife", "&f&lCOMMON");
		ItemAPI.addLore(item, "&6Melee");
		return item;
	}
	public static ItemStack MageBasicStaff() {
		ItemStack item = ItemAPI.createGuiItem(Material.STICK, "&fMage's Basic Staff", "&f&lCOMMON");
		ItemAPI.addLore(item, "&dMagic");
		return item;
	}
	public static ItemStack NecromancerSummonerWand() {
		ItemStack item = ItemAPI.createGuiItem(Material.BONE, "&fNecromancer's Summoner Wand", "&f&lCOMMON");
		ItemAPI.addLore(item, "&eSupport");
		return item;
	}
	public static ItemStack Arrow() {
		ItemStack item = ItemAPI.createGuiItem(Material.ARROW, "&fArrow", "&f&lCOMMON");
		ItemAPI.addLore(item, "&9Range&f/&bHybrid");
		return item;
	}
	public static ItemStack Arrows() {
		ItemStack item = ItemAPI.createGuiItem(64, Material.ARROW, "&fArrow", "&f&lCOMMON");
		ItemAPI.addLore(item, "&9Range&f/&bHybrid");
		return item;
	}
	public static ItemStack RangerCrossbow() {
		ItemStack item = ItemAPI.createGuiItem(Material.CROSSBOW, "&fRanger's Hybrid Crossbow", "&f&lCOMMON");
		ItemAPI.addLore(item, "&bHybrid");
		return item;
	}
	public static ItemStack WarriorSword() {
		ItemStack item = ItemAPI.createGuiItem(Material.DIAMOND_SWORD, "&fWarrior's Sword", "&f&lCOMMON");
		ItemAPI.addLore(item, "&6Melee");
		return item;
	}
	public static ItemStack SentinelBow() {
		ItemStack item = ItemAPI.createGuiItem(Material.BOW, "&fSentinel's Bow", "&f&lCOMMON");
		ItemAPI.addLore(item, "&9Range");
		return item;
	}
	public static ItemStack TankShield() {
		ItemStack item = ItemAPI.createGuiItem(Material.SHIELD, "&fTank's Shield", "&f&lCOMMON");
		ItemAPI.addLore(item, "&7Tank");
		return item;
	}
	public static ItemStack PriestStaff() {
		ItemStack item = ItemAPI.createGuiItem(Material.STICK, "&fStaff of Basic Healing", "&f&lCOMMON");
		ItemAPI.addLore(item, "&eSupport");
		return item;
	}
}
