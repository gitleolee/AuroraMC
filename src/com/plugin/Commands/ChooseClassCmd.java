package com.plugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.plugin.Events.ClassSetter;
import com.plugin.Rank.RankAPI;
import com.plugin.Rank.Ranks;

public class ChooseClassCmd implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(RankAPI.getRank(p).getPriority() <= Ranks.MODERATOR.getPriority()) {
				ClassSetter.createAndOpenInv(p);;
			}
		}
		return true;
		
	}
	
}
