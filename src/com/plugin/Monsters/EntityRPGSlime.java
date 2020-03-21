package com.plugin.Monsters;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import com.plugin.items.ItemAPI;

import net.md_5.bungee.api.ChatColor;

public class EntityRPGSlime implements Listener {
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onSlimeSpawn(CreatureSpawnEvent e) {
		if(e.getEntityType().equals(EntityType.SLIME)) {
			Random r = new Random();
			int chance = r.nextInt(100);
			
			if(chance != 5) {
				Slime slime = (Slime) e.getEntity();
				slime.setCustomNameVisible(true);
				slime.setCustomName(ChatColor.AQUA + "[Lv. 1] Slime");
				slime.setSize(1);
				slime.setMaxHealth(10);
				slime.setHealth(10);
			} else {
				Slime slime = (Slime) e.getEntity();
				slime.setCustomNameVisible(true);
				slime.setCustomName(ChatColor.AQUA + "[Lv. 10] Slime Boss");
				slime.setSize(10);
				slime.setMaxHealth(100);
				slime.setHealth(100);
			}
			
		}
	}
	 
	
	@EventHandler
	public static void onSlimeDeath(EntityDeathEvent e) {
		if(e.getEntityType().equals(EntityType.SLIME)) {
			Random r = new Random();
			e.getDrops().clear();
			e.setDroppedExp(0);
			int chance = r.nextInt(6);
			if(chance <= 2) {
				e.getDrops().add(ItemAPI.createGuiItem(chance, Material.GOLD_NUGGET, "&bPieces of Gold", "&b&lUNCOMMON"));
			}
			
			chance = r.nextInt(10);
			if(chance < 2) {
				e.getDrops().add(ItemAPI.createGuiItem(chance, Material.SLIME_BALL, "&bSlimy Material", "&b&lUNCOMMON"));
			}
			
			if(e.getEntity().getName().contains("[Lv. 10]")) {
				e.getDrops().add(ItemAPI.createGuiItem(20, Material.SLIME_BALL, "&bSlimy Material", "&b&lUNCOMMON"));
				e.getDrops().add(ItemAPI.createGuiItem(3, Material.GOLD_INGOT, "&bGold Ingot", "&b&lUNCOMMON"));
				
			}
			
			
			
		}
	}
	
	

}
