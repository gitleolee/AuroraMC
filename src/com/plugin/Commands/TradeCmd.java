package com.plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.plugin.Trading;
import com.plugin.Events.TradeEvents;

import net.md_5.bungee.api.ChatColor;

public class TradeCmd implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			if(args.length == 2) {
				if(args[0].equals("accept")) {
					if(isOnline(args[1]) && isPending(p, Bukkit.getPlayer(args[1]))) {
						Inventory sTU = Bukkit.createInventory(null, 5 * 9, "Trade with " + p.getDisplayName());
						Inventory rTU = Bukkit.createInventory(null, 5 * 9, "Trade with " + Bukkit.getPlayer(args[1]).getDisplayName());
						
						p.openInventory(rTU);
						Bukkit.getPlayer(args[1]).openInventory(sTU);
						
						removeTrade(p, Bukkit.getPlayer(args[1]));
					} else {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6That player didn't send a pending trade request to you."));
					}
				} else if(args[0].equals("deny")) {
					if(isOnline(args[1]) && isPending(Bukkit.getPlayer(args[1]), p)) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6You denied that player's trade request."));
						Bukkit.getPlayer(args[1]).sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6" + p.getDisplayName() + " denied your trade request."));
						TradeEvents.tradeCooldown.remove(new Trading(Bukkit.getPlayer(args[1]).getUniqueId(), p.getUniqueId()));
					} else {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6That player didn't send a pending trade request to you."));
					}
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cError: &7Invalid Usage"));
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage: &7/trade accept <player name> or /trade deny <player name>"));
				}
			} else if(args.length == 1) {
				if(isOnline(args[0])) {
					Player receiver = Bukkit.getPlayer(args[0]);
					if(!isPending(receiver, p)) {
						if(p == Bukkit.getPlayer(args[0])) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6You can't trade to yourself!"));
							return true;
						}
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6You sent " + receiver.getDisplayName() + " a trade request. It will expire in 60 seconds."));
						receiver.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6" + p.getDisplayName() + " sent a trade request. To accept, do /trade accept " + p.getDisplayName() + ". After &c60 &6seconds, the trade request will expire."));
						TradeEvents.tradeCooldown.put(new Trading(p.getUniqueId(), receiver.getUniqueId()), 120);
						
					} else {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6You can't send a trade request to " + receiver.getDisplayName() + " until the player accepts or it expires."));
					}
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cError: &7That player isn't online or doesn't exist!"));
				}
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cError: &7Invalid Argument Length"));
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage: &7/trade <player name>"));
			}
			
		}
		
		return true;
	}
	
	private boolean isOnline(String name) {
		boolean flag = false;
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(p.getName().equals(name)) {
				flag = true;
				break;
			}
		}
		return flag;
		
	}
	
	private boolean isPending(Player receiver, Player sender) {
		for(Trading trade : TradeEvents.tradeCooldown.keySet()) {
			if(trade.sender.equals(sender.getUniqueId())) {
				if(trade.receiver.equals(receiver.getUniqueId())) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void removeTrade(Player receiver, Player sender) {
		for(Trading trade : TradeEvents.tradeCooldown.keySet()) {
			if(trade.sender.equals(sender.getUniqueId())) {
				if(trade.receiver.equals(receiver.getUniqueId())) {
					TradeEvents.tradeCooldown.remove(trade);
					break;
				}
			}
		}
	}
}
