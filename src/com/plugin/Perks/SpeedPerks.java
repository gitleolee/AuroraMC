package com.plugin.Perks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.plugin.MainPlugin;
import com.plugin.Class.ClassAPI;
import com.plugin.Class.Classes;

public class SpeedPerks {
	public static void start() {
		
		new BukkitRunnable(){
			@Override
		    public void run(){
		    	for(Player p : Bukkit.getOnlinePlayers()) {
		    		if(!ClassAPI.getClass(p).equals(Classes.NO_CLASS)) {
		    			p.setWalkSpeed((float) ((0.5 * (ClassAPI.getClass(p).getSpeed() / 5.0))));
		    		} else {
		    			p.setWalkSpeed(1);
		    		}
		    	}
		    }
		}.runTaskTimer(MainPlugin.getPlugin(MainPlugin.class), 0, 10);
	}
}
