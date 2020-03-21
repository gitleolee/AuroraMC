package com.plugin;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.plugin.Commands.AuroraBuildHelperCommand;
import com.plugin.Commands.ChooseClassCmd;
import com.plugin.Commands.HelpCmd;
import com.plugin.Commands.PluginCmd;
import com.plugin.Commands.StaffChat;
import com.plugin.Commands.TradeCmd;
import com.plugin.Events.BuildersPro;
import com.plugin.Events.ChatEvents;
import com.plugin.Events.ClassSetter;
import com.plugin.Events.Join;
import com.plugin.Events.TradeEvents;
import com.plugin.Monsters.EntityRPGSlime;
import com.plugin.Perks.DamagePerks;
import com.plugin.Perks.MovementPerks;

public class MainPlugin extends JavaPlugin {
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		
		MovementPerks.start();
		
		
		
		
		registerEvents();
		registerCommands();
	}
	
	private void registerEvents() {
		registerEvent(new ChatEvents());
		registerEvent(new Join());
		registerEvent(new ClassSetter());
		registerEvent(new TradeEvents());
		registerEvent(new BuildersPro());
		
		registerEvent(new EntityRPGSlime());
		
		registerEvent(new MovementPerks());
		registerEvent(new DamagePerks());
	}
	
	private void registerCommands() {
		registerCommand(new StaffChat(), "staffchat");
		registerCommand(new StaffChat(), "sc");
		registerCommand(new PluginCmd(), "pl");
		registerCommand(new PluginCmd(), "plugins");
		registerCommand(new HelpCmd(), "help");
		registerCommand(new HelpCmd(), "?");
		registerCommand(new TradeCmd(), "trade");
		registerCommand(new ChooseClassCmd(), "changeclass");
		registerCommand(new AuroraBuildHelperCommand(), "builderspro");
		registerCommand(new AuroraBuildHelperCommand(), "bp");
		
	
	}
	
	private void registerEvent(Listener l) {
		getServer().getPluginManager().registerEvents(l, this);
	}
	
	private void registerCommand(CommandExecutor cmd, String syntax) {
		getCommand(syntax).setExecutor(cmd);;
	}
}
