package com.plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.plugin.Rank.RankAPI;
import com.plugin.Rank.Ranks;

public class SetRank implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 2) {
			Player rReceiver = Bukkit.getPlayer(args[0]);
			Ranks r = RankAPI.stringToRank(args[1]);
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(RankAPI.getRank(p).getPriority() <= Ranks.ADMIN.getPriority()) {
					RankAPI.setRank(rReceiver, r);
				}
			} else {
				RankAPI.setRank(rReceiver, r);
			}
		}
		
		return true;
		
	}
}