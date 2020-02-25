package com.plugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCmd implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage(ttC("&6--[[&9Help Menu&6]]--"));
		}
		return true;
		
	}
	
	private String ttC(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
}
