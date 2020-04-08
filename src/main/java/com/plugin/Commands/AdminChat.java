package com.plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.plugin.Rank.RankAPI;
import com.plugin.Rank.Ranks;

public class AdminChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(RankAPI.getRank(p).getPriority() <= Ranks.ADMIN.getPriority()) {
				String msg = String.join(" ", args);
				for(Player plr : Bukkit.getOnlinePlayers()) {
					if(RankAPI.getRank(plr).getPriority() <= Ranks.ADMIN.getPriority()) {
						plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&9Staff Chat&8] &b" + p.getDisplayName() +": &3" + msg));
					}
				}
			}
		} else {
			String msg = String.join(" ", args);
			for(Player plr : Bukkit.getOnlinePlayers()) {
				if(RankAPI.getRank(plr).getPriority() <= Ranks.ADMIN.getPriority()) {
					plr.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&9Staff Chat&8] &bConsole System: &3" + msg));
				}
			}
		}
		
		
		return true;
	}

}
