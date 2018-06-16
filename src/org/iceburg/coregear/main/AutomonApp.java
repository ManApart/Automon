package org.iceburg.coregear.main;

public class AutomonApp {

	private static Player player;
	private static Battle battle;
	
	
	public AutomonApp(){
		setPlayer(new Player());
	}
	
	public static Player getPlayer(){
		return player;
	}

	public static Battle getBattle() {
		return battle;
	}

	public static void setBattle(Battle newBattle) {
		battle = newBattle;
	}

	public static void setPlayer(Player newPlayer) {
		player = newPlayer;
	}
	
}
