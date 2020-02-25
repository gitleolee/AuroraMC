package com.plugin;

import java.util.UUID;

public class Trading {
	
	public UUID sender = null;
	public UUID receiver = null;
	
	public Trading(UUID sender, UUID receiver) {
		this.sender = sender;
		this.receiver = receiver;
	}
	
}
