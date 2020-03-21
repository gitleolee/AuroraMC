package com.plugin.items;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_15_R1.NBTTagCompound;
import net.minecraft.server.v1_15_R1.NBTTagFloat;
import net.minecraft.server.v1_15_R1.NBTTagInt;
import net.minecraft.server.v1_15_R1.NBTTagList;
import net.minecraft.server.v1_15_R1.NBTTagString;

public class ClassDefaultItems {
	public static ItemStack AssassinKnife() {
		ItemStack item = ItemAPI.createGuiItem(Material.IRON_SWORD, "&fAssassin's Knife", "&f&lCOMMON");
		ItemAPI.addLore(item, "&6Melee");
		
		
		net.minecraft.server.v1_15_R1.ItemStack Item = CraftItemStack.asNMSCopy(item);
		NBTTagCompound nbt = (Item.hasTag() ? Item.getTag() : new NBTTagCompound());
        
		NBTTagList modifiers = new NBTTagList();
        NBTTagCompound damage = new NBTTagCompound();
        damage.set("AttributeName", NBTTagString.a("generic.attackSpeed"));
        damage.set("Name", NBTTagString.a("generic.attackSpeed"));
        damage.set("Amount", NBTTagFloat.a(122));
        damage.set("Operation", NBTTagInt.a(0));
        damage.set("UUIDLeast", NBTTagInt.a(894654));
        damage.set("UUIDMost", NBTTagInt.a(2872));
        damage.set("Slot", NBTTagString.a("mainhand"));
        modifiers.add(damage);
        nbt.set("AttributeModifiers", modifiers);
		
        Item.setTag(nbt);
        
        item = CraftItemStack.asBukkitCopy(Item);
		
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
		ItemAPI.addLore(item, "&9Range");
		return item;
	}
	public static ItemStack Arrows() {
		ItemStack item = ItemAPI.createGuiItem(64, Material.ARROW, "&fArrow", "&f&lCOMMON");
		ItemAPI.addLore(item, "&9Range");
		return item;
	}
	public static ItemStack HArrows() {
		ItemStack item = ItemAPI.createGuiItem(32, Material.ARROW, "&fArrow", "&f&lCOMMON");
		ItemAPI.addLore(item, "&9Range");
		return item;
	}
	public static ItemStack RangerCrossBow() {
		ItemStack item = ItemAPI.createGuiItem(Material.CROSSBOW, "&fRanger's Crossbow", "&f&lCOMMON");
		ItemAPI.addLore(item, "&9Range");
		return item;
	}
	public static ItemStack RangerKnife() {
		ItemStack item = ItemAPI.createGuiItem(Material.STONE_SWORD, "&fRanger's Knife", "&f&lCOMMON");
		ItemAPI.addLore(item, "&6Melee");
		
		net.minecraft.server.v1_15_R1.ItemStack Item = CraftItemStack.asNMSCopy(item);
		NBTTagCompound nbt = (Item.hasTag() ? Item.getTag() : new NBTTagCompound());
        
		NBTTagList modifiers = new NBTTagList();
        NBTTagCompound damage = new NBTTagCompound();
        damage.set("AttributeName", NBTTagString.a("generic.attackSpeed"));
        damage.set("Name", NBTTagString.a("generic.attackSpeed"));
        damage.set("Amount", NBTTagFloat.a(122));
        damage.set("Operation", NBTTagInt.a(0));
        damage.set("UUIDLeast", NBTTagInt.a(894654));
        damage.set("UUIDMost", NBTTagInt.a(2872));
        damage.set("Slot", NBTTagString.a("mainhand"));
        modifiers.add(damage);
        nbt.set("AttributeModifiers", modifiers);
		
        Item.setTag(nbt);
        
        item = CraftItemStack.asBukkitCopy(Item);
		
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
	public static ItemStack SentinelCrossbow() {
		ItemStack item = ItemAPI.createGuiItem(Material.CROSSBOW, "&fSentinel's Crossbow", "&f&lCOMMON");
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
