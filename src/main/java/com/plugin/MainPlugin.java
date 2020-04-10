package com.plugin;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.plugin.Commands.*;
import com.plugin.Events.*;
import com.plugin.Events.Hub.*;

public class MainPlugin extends JavaPlugin {

	private static MainPlugin instance;

	@Override
	public void onEnable() {

		setInstance(instance);

		super.onEnable();
		registerCommands();
		registerEvents();
		
		BasicHubSystem.start();
	}

	private static void setInstance(MainPlugin instance) {
		MainPlugin.instance = instance;
	}

	public static MainPlugin getInstance() {
		return instance;
	}
	
	private void registerEvents() {
		registerEvent(new ChatEvents());

		
		registerEvent(new BasicHubSystem());
		registerEvent(new ServerSelector());
	}
	
	private void registerCommands() {
		registerCommand(new SetRank(), "setrank");
		registerCommand(new GiveRank(), "giverank");
		
		registerCommand(new AdminChat(), "adminchat");
		registerCommand(new ModerationChat(), "modchat");
		registerCommand(new StaffChat(), "staffchat");
		registerCommand(new StaffChat(), "sc");
		
		registerCommand(new HubCommand(), "hub");
		registerCommand(new HubCommand(), "spawn");
		registerCommand(new HubCommand(), "lobby");
	}
	
	private void registerEvent(Listener l) {
		getServer().getPluginManager().registerEvents(l, this);
	}
	
	private void registerCommand(CommandExecutor cmd, String syntax) {
		getCommand(syntax).setExecutor(cmd);
	}
	
}
