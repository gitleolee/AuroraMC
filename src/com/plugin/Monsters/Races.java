package com.plugin.Monsters;

public enum Races {
	
	GOBLIN(RacesRanks.LOW, RacesSides.AGGRESSIVE),
	SLIME(RacesRanks.LOW, RacesSides.NEUTRAL),
	OGRE(RacesRanks.HIGH, RacesSides.AGGRESSIVE),
	ORC(RacesRanks.LOW, RacesSides.AGGRESSIVE),
	DWARFS(RacesRanks.HIGH, RacesSides.FRIENDLY),
	DRYAD(RacesRanks.HIGH, RacesSides.FRIENDLY),
	HOBGOBLINS(RacesRanks.MEDIUM, RacesSides.NEUTRAL)
	;
	
	private RacesRanks rank;
	private RacesSides side;
	
	Races(RacesRanks rank, RacesSides side) {
		this.rank = rank;
		this.side = side;
	}

	public RacesRanks getRank() {
		return rank;
	}

	public RacesSides getSide() {
		return side;
	}
	
}
