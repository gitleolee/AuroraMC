package com.plugin.Perks;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import com.plugin.MainPlugin;

public class PerksAPI {
	static MainPlugin instance = MainPlugin.getPlugin(MainPlugin.class);
	
	public static void givePerk(Player p, String s) {
		
		List<String> lists = instance.getConfig().getStringList(p.getUniqueId() + ".Perks");
		if(lists == null) {
			lists = new ArrayList<String>();
		}
		
		lists.add(s);
		
		instance.getConfig().set(p.getUniqueId() + ".Perks", lists);
		instance.saveConfig();
	}
	
	public static List<String> getPerks(Player p) {
		List<String> lists = instance.getConfig().getStringList(p.getUniqueId() + ".Perks");
		if(lists == null) {
			lists = new ArrayList<String>();
		}
		return lists;
	}
	
	public static boolean hasPerk(Player p, String s) {
		List<String> lists = getPerks(p);
		boolean flag = false;
		for(String perk : lists) {
			if(perk.equals(s)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	
}
