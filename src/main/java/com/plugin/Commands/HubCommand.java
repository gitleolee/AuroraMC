package com.plugin.Commands;

import com.plugin.Constants.defaultValues;
import com.plugin.PluginMessage;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HubCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			defaultValues.reloadServerPlayers("Hub");
			if(defaultValues.serverPlayers.get("Hub").contains(p.getDisplayName())) {
				PluginMessage.connect(p, "Hub");

				Location pos = p.getLocation();
				pos.setX(0.0);
				pos.setY(0.0);
				pos.setZ(0.0);
				pos.setPitch(0);
				pos.setYaw(0);

				p.teleport(pos);
			}
			
			
		} else {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou aren't a player!"));
		}
		
		return true;
	}
	
}
