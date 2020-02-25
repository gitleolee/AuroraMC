package com.plugin.Rank;

import net.md_5.bungee.api.ChatColor;

public enum Ranks {
	
	OWNER("&4[Owner]", 0),
	ADMIN("&c[Admin]", 5),
	MODERATOR("&a[Mod]", 8),
	HELPER("&9[Helper]", 12),
	DEMIGOD("&1[Demigod]", 50),
	EMPEROR("&6[Emperor]", 60),
	KING("&e[King]", 65),
	PRINCE("&b[Prince]", 75),
	NOBLE("&a[Noble]", 80),
	WarlockP("&2[Warlock+]", 90),
	Warlock("&2[Warlock]", 95),
	KnightP("&3[Knight+]", 100),
	Knight("&3[Knight]", 110),
	SQUIRE("&8[Squire]", 115),
	DEFAULT("&7[Default]", 999999)
	;
	
	private String prefix;
	private int priority;
	
	Ranks(String prefix, int priority) {
		this.prefix = prefix;
		this.priority = priority;
	}
	
	public String getPrefix() {
		return ChatColor.translateAlternateColorCodes('&', prefix);
	}

	public int getPriority() {
		return priority;
	}
}
