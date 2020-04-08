package com.plugin.Events.Hub;

import com.plugin.Constants.defaultValues;
import com.plugin.MainPlugin;
import com.plugin.PluginMessage;
import com.plugin.Rank.RankAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class BasicHubSystem implements Listener {
	
	@EventHandler
	public static void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.setHealth(20);
		p.setFoodLevel(20);
		e.setJoinMessage(null);
		
		for(ProxiedPlayer plr : defaultValues.hub.getPlayers()) {
			if(p.hasPlayedBefore()) {
				plr.sendMessage(ChatColor.translateAlternateColorCodes('&',RankAPI.getRank(p).getPrefix() + "&b" + p.getName() + "&7 joined"));
			} else {
				plr.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Welcome " + RankAPI.getRank(p).getPrefix() + "&b" + p.getName() + "&6 to AuroraMC!"));
			}
			
		}
		try {
			Thread.sleep(750);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		PluginMessage.connect(p, "Hub");

		Location pos = p.getLocation();
		pos.setX(0.0);
		pos.setY(0.0);
		pos.setZ(0.0);
		pos.setPitch(0);
		pos.setYaw(0);

		p.teleport(pos);
	}
	
	@EventHandler
	public static void noDamage(EntityDamageEvent e) {
		if(e.getEntity().getWorld().equals(defaultValues.hub)) {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				p.setHealth(20);
			}
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public static void drop(PlayerDropItemEvent e) {
		if(e.getPlayer().getWorld().equals(defaultValues.hub)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public static void swapHands(PlayerSwapHandItemsEvent e) {
		if(e.getPlayer().getWorld().equals(defaultValues.hub)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public static void hunger(FoodLevelChangeEvent e) {
		if(e.getFoodLevel() < 20 && e.getEntity().getWorld().equals(defaultValues.hub)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public static void breakBlock(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(p.getWorld().equals(defaultValues.hub)) {
			if(p.getGameMode() != GameMode.CREATIVE) {
				e.setCancelled(true);
				p.sendMessage(defaultValues.denyMsg);
			}
		}
	}
	
	@EventHandler
	public static void place(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(p.getWorld().equals(defaultValues.hub)) {
			if(p.getGameMode() != GameMode.CREATIVE) {
				e.setCancelled(true);
				p.sendMessage(defaultValues.denyMsg);
			}
		}
	}
	
	public static void start() {
		new BukkitRunnable(){

			@Override
			public void run() {
				defaultValues.reloadServerPlayers("Hub");
				for(String s : defaultValues.serverPlayers.get("Hub")) {
					Player p = Bukkit.getPlayer(s);
					if(p.hasPotionEffect(PotionEffectType.SPEED)) {
						p.removePotionEffect(PotionEffectType.SPEED);
					}
				}
				
			}
			
		}.runTaskTimer(MainPlugin.getPlugin(MainPlugin.class), 0, 1);
	}
	
	
	
	
	
}
