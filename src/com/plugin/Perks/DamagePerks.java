package com.plugin.Perks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import com.plugin.Class.ClassAPI;
import com.plugin.Class.Classes;
import com.plugin.items.ItemAPI;
public class DamagePerks implements Listener {
	
	@EventHandler
	public static void damage(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if(!ClassAPI.getClass(p).equals(Classes.NO_CLASS)) {
    			e.setDamage((e.getDamage() * 2.0) * (ClassAPI.getClass(p).getAttack() / 5.0));
    		}
			if(PerksAPI.hasPerk(p, "Sword Master") && ItemAPI.isSword(p.getInventory().getItemInMainHand())) {
    			e.setDamage(((e.getDamage() * 1.1)));
    		
    		}
			
		
		}
	}
	
	@EventHandler
	public static void takeDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
		
			
			if(!ClassAPI.getClass(p).equals(Classes.NO_CLASS)) {
    			e.setDamage((e.getDamage() * (2 * ClassAPI.getClass(p).getDefense()) * (1 - (ClassAPI.getClass(p).getDefense() / 5.0))));
    		}
			
			
			if(PerksAPI.hasPerk(p, "Tough Skin")) {
    			e.setDamage(((e.getDamage() * 0.95)));
    			
    		}
			
			
			if(e.isCancelled()) {
				e.setCancelled(false);
			}
			p.sendMessage("Dam: " + e.getDamage() * 0.95);
		
		}
		if(e.isCancelled()) {
			e.setCancelled(false);
		}
	}
	
	@EventHandler
	public static void die(EntityDeathEvent e) {
		if(e.getEntity() instanceof Player) {
		
			for(ItemStack i : e.getDrops()) {
				if(i.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "AuroraMC Menu")) {
					e.getDrops().remove(i);
				}
			}
			
			
			
		}
	}
	@EventHandler
	public static void respawn(PlayerRespawnEvent e) {
		
		e.getPlayer().getInventory().setItem(8, ItemAPI.createGuiItem(Material.NETHER_STAR, "&dAuroraMC Menu"));
	}
	
	
	
}
