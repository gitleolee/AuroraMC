package com.plugin.Events;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.plugin.MainPlugin;
import com.plugin.Class.ClassAPI;
import com.plugin.Class.Classes;
import com.plugin.Rank.RankAPI;
import com.plugin.items.ItemAPI;

public class Join implements Listener {
	
	@EventHandler
	public static void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		RankAPI.reloadTab(p);
		e.setJoinMessage(null);
		
		int currentJoins = MainPlugin.getPlugin(MainPlugin.class).getConfig().getInt(p.getUniqueId() + ".Joins", 0);
		MainPlugin.getPlugin(MainPlugin.class).getConfig().set(p.getUniqueId() + ".Joins", currentJoins + 1);
		MainPlugin.getPlugin(MainPlugin.class).saveConfig();
		p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4);
		if(ClassAPI.getClass(p) == Classes.NO_CLASS) {
			p.getInventory().clear();
			p.getInventory().setItem(7, ItemAPI.createGuiItem(Material.COMPASS, "&aChoose Class &7(RClick)"));
		}
	}
	
}
