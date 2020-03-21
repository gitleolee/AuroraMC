package com.plugin.Class;

public enum Classes {
	MAGE(2.5, 2.3, 4.9, 2.1, 2.0, ClassTypes.MAGIC),
	ASSASSIN(4.8, 0.9, 0.5, 3.5, 1, ClassTypes.MELEE),
	PALADIN(2.1, 4, 1.4, 1.5, 1.5, ClassTypes.SUPPORT),
	RANGER(3.8, 2.3, 0.7, 2.9, 0.9, ClassTypes.HYBRID),
	WARRIOR(4.2, 2.6, 0.2, 2.4, 1.4, ClassTypes.MELEE),
	SENTINEL(4.5, 1.5, 0.6, 3.0, 0.8, ClassTypes.RANGED),
	TANK(0.8, 4.8, 0.1, 1.9, 1.1, ClassTypes.TANK),
	PRIEST(0.4, 2.1, 0.6, 1.1, 4.2, ClassTypes.SUPPORT),
	NECROMANCER(1.2, 1.7, 3.4, 1.2, 2.0, ClassTypes.SUPPORT),
	NO_CLASS(0,0,0,0,0, ClassTypes.HYBRID)
	;
	
	private double attack; //Everything Max Is 5
	private double defense;
	private double magic;
	private double speed;
	private double heal;
	private ClassTypes type;
	
	Classes(double attack, double defense, double magic, double speed, double heal, ClassTypes type) {
		this.attack = attack;
		this.defense = defense;
		this.magic = magic;
		this.speed = speed;
		this.heal = heal;
		this.type = type;
	}

	public double getAttack() {
		return attack;
	}

	public double getDefense() {
		return defense;
	}

	public double getMagic() {
		return magic;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public double getHeal() {
		return heal;
	}
	
	public ClassTypes getType() {
		return type;
	}
	
}
