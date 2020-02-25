package com.plugin.Events;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

import com.plugin.Trading;

public class TradeEvents implements Listener {
	
	public static HashMap<Trading, Integer> tradeCooldown = new HashMap<Trading, Integer>();
	
	
	@EventHandler
	public static void openInventory(InventoryOpenEvent e) {
		Player opener = (Player) e.getPlayer();
		String title = e.getView().getTitle();
		
		if(title.contains("Trade with ")) {
			
		}
		
	}
	
	
}
