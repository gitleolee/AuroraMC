package com.plugin.Constants;

import com.plugin.PluginMessage;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.List;

public class defaultValues {
	public static String hubName = "hub";
	public static ServerInfo hub = ProxyServer.getInstance().getServerInfo("Hub");
	public static String denyMsg = ChatColor.translateAlternateColorCodes('&', "&c&lHey! &7Sorry, but you can't do that here!");

	public static HashMap<String, List<String>> serverPlayers = new HashMap<>();

	public static void reloadServerPlayers(String server) {
		PluginMessage.getPlayers(server);
	}
}
