package com.plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.plugin.Rank.RankAPI;
import com.plugin.Rank.Ranks;

public class PluginCmd implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(RankAPI.getRank(p).getPriority() <= Ranks.MODERATOR.getPriority()) {
				String pluginList = "";
				int cnt = 0;
				for(Plugin pl : Bukkit.getPluginManager().getPlugins()) {
					cnt++;
					pluginList = pluginList + (cnt == 1 ? " " : ChatColor.GRAY + ", ") + (pl.isEnabled() ? ChatColor.GREEN : ChatColor.RED) + pl.getName();
				}
				
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Plugins(" + cnt + "):&7" + pluginList));
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cError: &7You don't have permission to run this command."));
			}
		}
		return true;
		
	}
}
