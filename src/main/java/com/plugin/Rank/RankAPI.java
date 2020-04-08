package com.plugin.Rank;

import org.bukkit.entity.Player;

import com.plugin.MainPlugin;

import net.md_5.bungee.api.ChatColor;

public class RankAPI {
	
	static MainPlugin instance = MainPlugin.getPlugin(MainPlugin.class);
	
	public static void setRank(Player p, Ranks r) {
		instance.getConfig().set(p.getUniqueId() + ".Rank", rankToString(r));
		instance.saveConfig();
		reloadTab(p);
	}
	
	public static Ranks getRank(Player p) {
		return stringToRank(instance.getConfig().getString(p.getUniqueId() + ".Rank", "Default"));
	}
	
	public static void reloadTab(Player p) {
		p.setPlayerListName(getRank(p).getPrefix() + ChatColor.WHITE + p.getDisplayName());
	}
	
	public static String rankToString(Ranks r) {
		if(r.equals(Ranks.OWNER)) {
			return "Owner";
		}
		else if(r.equals(Ranks.ADMIN)) {
			return "Admin";
		}
		else if(r.equals(Ranks.MODERATOR)) {
			return "Mod";
		}
		else if(r.equals(Ranks.HELPER)) {
			return "Helper";
		}
		else if(r.equals(Ranks.DEMIGOD)) {
			return "Demigod";
		}
		else if(r.equals(Ranks.EMPEROR)) {
			return "Emperor";
		}
		else if(r.equals(Ranks.KING)) {
			return "King";
		}
		else if(r.equals(Ranks.PRINCE)) {
			return "Prince";
		}
		else if(r.equals(Ranks.NOBLE)) {
			return "Noble";
		}
		else if(r.equals(Ranks.WarlockP)) {
			return "Warlock+";
		}
		else if(r.equals(Ranks.Warlock)) {
			return "Warlock";
		}
		else if(r.equals(Ranks.KnightP)) {
			return "Knight+";
		}
		else if(r.equals(Ranks.Knight)) {
			return "Knight";
		}
		else if(r.equals(Ranks.SQUIRE)) {
			return "Squire";
		}
		else if(r.equals(Ranks.DEFAULT)) {
			return "Default";
		}
		else {
			return "Default";
		}
	}
	
	public static Ranks stringToRank(String r) {
		if(r.equals("Owner")) {
			return Ranks.OWNER;
		}
		else if(r.equals("Admin")) {
			return Ranks.ADMIN;
		}
		else if(r.equals("Mod")) {
			return Ranks.MODERATOR;
		}
		else if(r.equals("Helper")) {
			return Ranks.HELPER;
		}
		else if(r.equals("Demigod")) {
			return Ranks.DEMIGOD;
		}
		else if(r.equals("Emperor")) {
			return Ranks.EMPEROR;
		}
		else if(r.equals("King")) {
			return Ranks.KING;
		}
		else if(r.equals("Prince")) {
			return Ranks.PRINCE;
		}
		else if(r.equals("Noble")) {
			return Ranks.NOBLE;
		}
		else if(r.equals("Warlock+")) {
			return Ranks.WarlockP;
		}
		else if(r.equals("Warlock")) {
			return Ranks.Warlock;
		}
		else if(r.equals("Knight+")) {
			return Ranks.KnightP;
		}
		else if(r.equals("Knight")) {
			return Ranks.Knight;
		}
		else if(r.equals("Squire")) {
			return Ranks.SQUIRE;
		}
		else if(r.equals("Default")) {
			return Ranks.DEFAULT;
		}
		else {
			return Ranks.DEFAULT;
		}
		
	}
	
}
