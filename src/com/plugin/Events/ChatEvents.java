package com.plugin.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.plugin.Class.ClassAPI;
import com.plugin.Class.Classes;
import com.plugin.Rank.RankAPI;
import com.plugin.Rank.Ranks;

public class ChatEvents implements Listener {
	
	@EventHandler
	public static void chat(AsyncPlayerChatEvent e) {
		e.setCancelled(true);
		chatFormat(e.getMessage(), e.getPlayer());
	}
	
	private static void chatFormat(String msg, Player sender) {
		for(Player p : sender.getWorld().getPlayers()) {
			String pC = (ClassAPI.getClass(sender) == Classes.NO_CLASS) ? "" : ChatColor.DARK_PURPLE + ("(" + ClassAPI.classToString(ClassAPI.getClass(sender)) + ")");
			if(RankAPI.getRank(sender).getPriority() <= Ranks.Warlock.getPriority()) {
				msg = ChatColor.translateAlternateColorCodes('&', msg);
			}
			p.sendMessage(RankAPI.getRank(sender).getPrefix() + ChatColor.translateAlternateColorCodes('&', "&f") + pC + ChatColor.WHITE + sender.getDisplayName()  + ": " + ChatColor.AQUA + msg);
		}
	}
	
}
