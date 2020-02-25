package com.plugin.Class;

import org.bukkit.entity.Player;

import com.plugin.MainPlugin;

public class ClassAPI {
	
	static MainPlugin instance = MainPlugin.getPlugin(MainPlugin.class);
	
	public static Classes[] classesList = {
			Classes.ASSASSIN,
			Classes.MAGE,
			Classes.NECROMANCER,
			Classes.PALADIN,
			Classes.PRIEST,
			Classes.RANGER,
			Classes.SENTINEL,
			Classes.TANK,
			Classes.WARRIOR
	};
	
	public static void setClass(Player p, Classes c) {
		instance.getConfig().set(p.getUniqueId() + ".Class", classToString(c));
		instance.saveConfig();
	}
	public static Classes getClass(Player p) {
		return stringToClass(instance.getConfig().getString(p.getUniqueId() + ".Class", "No Class"));
	}
	
	public static String classToString(Classes c) {
		if(c.equals(Classes.MAGE)) {
			return "Mage";
		}
		else if(c.equals(Classes.ASSASSIN)) {
			return "Assassin";
		}
		else if(c.equals(Classes.NECROMANCER)) {
			return "Necromancer";
		}
		else if(c.equals(Classes.PALADIN)) {
			return "Paladin";
		}
		else if(c.equals(Classes.PRIEST)) {
			return "Priest";
		}
		else if(c.equals(Classes.RANGER)) {
			return "Ranger";
		}
		else if(c.equals(Classes.SENTINEL)) {
			return "Sentinel";
		}
		else if(c.equals(Classes.TANK)) {
			return "Tank";
		}
		else if(c.equals(Classes.WARRIOR)) {
			return "Warrior";
		}
		else if(c.equals(Classes.NO_CLASS)) {
			return "No Class";
		}
		else {
			return "No Class";
		}
		
	}
	
	public static Classes stringToClass(String c) {
		if(c.equals("Mage")) {
			return Classes.MAGE;
		}
		else if(c.equals("Assassin")) {
			return Classes.ASSASSIN;
		}
		else if(c.equals("Necromancer")) {
			return Classes.NECROMANCER;
		}
		else if(c.equals("Paladin")) {
			return Classes.PALADIN;
		}
		else if(c.equals("Priest")) {
			return Classes.PRIEST;
		}
		else if(c.equals("Ranger")) {
			return Classes.RANGER;
		}
		else if(c.equals("Sentinel")) {
			return Classes.SENTINEL;
		}
		else if(c.equals("Tank")) {
			return Classes.TANK;
		}
		else if(c.equals("Warrior")) {
			return Classes.WARRIOR;
		}
		else if(c.equals("No Class")) {
			return Classes.NO_CLASS;
		}
		else {
			return Classes.NO_CLASS;
		}
		
	}
}
