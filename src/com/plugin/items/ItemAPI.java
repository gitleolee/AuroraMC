package com.plugin.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemAPI {
	public static void unbreakable(ItemStack stack, boolean unbreakable) {
		ItemMeta meta = stack.getItemMeta();
		meta.setUnbreakable(unbreakable);
		stack.setItemMeta(meta);
	}
	
	public static void hideFlags(ItemStack stack) {
		ItemMeta meta = stack.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES,ItemFlag.HIDE_POTION_EFFECTS,ItemFlag.HIDE_PLACED_ON,ItemFlag.HIDE_ENCHANTS,ItemFlag.HIDE_DESTROYS,ItemFlag.HIDE_UNBREAKABLE);
		stack.setItemMeta(meta);
	}
	
	public static void setName(ItemStack stack, String name) {
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		stack.setItemMeta(meta);
	}
	
	public static void addFirstLore(ItemStack stack, String firstLore) {
		ItemMeta meta = stack.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', firstLore));
		meta.setLore(lore);
		stack.setItemMeta(meta);
	}
	public static void addLore(ItemStack stack, String firstLore) {
		ItemMeta meta = stack.getItemMeta();
		List<String> lore = meta.getLore();
		lore.add(ChatColor.translateAlternateColorCodes('&', firstLore));
		meta.setLore(lore);
		stack.setItemMeta(meta);
	}
	
	
	public static ItemStack createGuiItem(Material mat, String name) {
		ItemStack stack = new ItemStack(mat);
		hideFlags(stack);
		unbreakable(stack, true);
		setName(stack, name);
		return stack;
	}
	
	public static ItemStack createGuiItem(Material mat, String name, String firstLore) {
		ItemStack stack = new ItemStack(mat);
		hideFlags(stack);
		unbreakable(stack, true);
		setName(stack, name);
		addFirstLore(stack, firstLore);
		return stack;
	}
	
	public static ItemStack createGuiItem(int count, Material mat, String name) {
		ItemStack stack = new ItemStack(mat, count);
		hideFlags(stack);
		unbreakable(stack, true);
		setName(stack, name);
		return stack;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack createHeadItem(String name, String owner) {
		ItemStack stack = new ItemStack(Material.PLAYER_HEAD);
		hideFlags(stack);
		unbreakable(stack, true);
		setName(stack, name);
		SkullMeta meta = (SkullMeta) stack.getItemMeta();
		meta.setOwner(owner);
		stack.setItemMeta(meta);
		return stack;
	}
	
	public static ItemStack createGuiItem(int count, Material mat, String name, String firstLore) {
		ItemStack stack = new ItemStack(mat, count);
		hideFlags(stack);
		unbreakable(stack, true);
		setName(stack, name);
		addFirstLore(stack, firstLore);
		return stack;
	}
	
	
	public static boolean isName(ItemStack stack, String name) {
		return stack.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', name));
				
	}
	
	public static boolean isFirstLore(ItemStack stack, String firstLore) {
		return stack.getItemMeta().getLore().get(0).equals(firstLore);
				
	}
	
	public static boolean isSword(ItemStack stack) {
		return stack.getType().toString().toLowerCase().contains("sword");
	}
}
