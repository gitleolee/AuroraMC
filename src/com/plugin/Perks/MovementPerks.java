package com.plugin.Perks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.plugin.MainPlugin;
import com.plugin.Trading;
import com.plugin.Class.ClassAPI;
import com.plugin.Class.Classes;
import com.plugin.Events.TradeEvents;


public class MovementPerks implements Listener {
	
	public static void start() {
		
		new BukkitRunnable(){
			@Override
		    public void run(){
		    	for(Player p : Bukkit.getOnlinePlayers()) {
		    		if(!ClassAPI.getClass(p).equals(Classes.NO_CLASS)) {
		    			p.setWalkSpeed((float) ((0.5 * (ClassAPI.getClass(p).getSpeed() / 5.0))));
		    		} else {
		    			p.setWalkSpeed(0.5f);
		    		}
		    		if(PerksAPI.hasPerk(p, "Secret Accessibility: ON")) {
		    			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10, 3, false, false), true);
		    		}
		    		
		    		if(p.getWorld().getBlockAt(p.getLocation()).getType().equals(Material.STONECUTTER)) {
		    			p.damage(2);
		    		}
		    		
		    		
		    	}
		    	if(TradeEvents.tradeCooldown.isEmpty()) {
		    		return;
		    	}
		    	for(Trading trade : TradeEvents.tradeCooldown.keySet()) {
		    		int timeLeft = TradeEvents.tradeCooldown.get(trade);
		    		
		    		if (timeLeft <= 0) {
		    			TradeEvents.tradeCooldown.remove(trade);
		    			Player receiver = Bukkit.getPlayer(trade.receiver);
		    			Player sender = Bukkit.getPlayer(trade.sender);
		    			receiver.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6The trade request from " + sender.getDisplayName() + " has expired."));
		    			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6AuroraMC&8] &6The trade request to " + receiver.getDisplayName() + " has expired."));
					}else{
						TradeEvents.tradeCooldown.put(trade, timeLeft - 1);
					}
		    	}
		    }
		}.runTaskTimer(MainPlugin.getPlugin(MainPlugin.class), 0, 10);
	}
	
	
	
	
}
