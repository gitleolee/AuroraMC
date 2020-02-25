package com.plugin.Events;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.plugin.Class.ClassAPI;
import com.plugin.Class.Classes;
import com.plugin.items.ItemAPI;

public class Join implements Listener {
	
	@EventHandler
	public static void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(122);
		if(ClassAPI.getClass(p) == Classes.NO_CLASS) {
			p.getInventory().clear();
			p.getInventory().setItem(8, ItemAPI.createGuiItem(Material.COMPASS, "&aChoose Class &7(RClick)"));
		}
	}
	
}
