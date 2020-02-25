package com.plugin.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GUIItems {
	public static ItemStack getBlankItem() {
		return ItemAPI.createGuiItem(Material.BLACK_STAINED_GLASS_PANE, "&2");
	}
}
