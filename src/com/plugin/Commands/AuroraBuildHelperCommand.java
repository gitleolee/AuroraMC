package com.plugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.plugin.items.GUIItems;
import com.plugin.items.ItemAPI;

public class AuroraBuildHelperCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			
			Inventory inv = Bukkit.createInventory(null, 9 * 3, "AuroraMC BuildersPro");
			for(int i = 0; i < 9; i++) {
				inv.setItem(i, GUIItems.getBlankItem());
			}
			for(int i = 18; i < 27; i++) {
				inv.setItem(i, GUIItems.getBlankItem());
			}
			inv.setItem(9, GUIItems.getBlankItem());
			inv.setItem(11, GUIItems.getBlankItem());
			inv.setItem(12, GUIItems.getBlankItem());
			inv.setItem(14, GUIItems.getBlankItem());
			inv.setItem(15, GUIItems.getBlankItem());
			inv.setItem(17, GUIItems.getBlankItem());
			
			inv.setItem(10, ItemAPI.createGuiItem(Material.BARRIER, "&6Extra Blocks"));
			inv.setItem(13, ItemAPI.createHeadItem("&bHeads", "MHF_Pig"));
			inv.setItem(16, ItemAPI.createGuiItem(Material.DIAMOND_HOE, "&3Extra Items"));
			
			p.openInventory(inv);
		}
		return true;
		
	}
}
