package org.iceburg.coregear.model;

public class Core {

	private int level = 1;
	private float rechargeRate = 1;
	private String playerGivenName, name;
	private Mech currentMech;
	private Affinity affinity;
	
	@Override
	public String toString(){
		return getName();
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public float getRechargeRate() {
		return rechargeRate;
	}
	public void setRechargeRate(float rechargeRate) {
		this.rechargeRate = rechargeRate;
	}
	public String getPlayerGivenName() {
		return playerGivenName;
	}
	public void setPlayerGivenName(String playerGivenName) {
		this.playerGivenName = playerGivenName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Mech getCurrentMech() {
		return currentMech;
	}

	public void setCurrentMech(Mech currentMech) {
		this.currentMech = currentMech;
	}

	public Affinity getAffinity() {
		return affinity;
	}

	public void setAffinity(Affinity affinity) {
		this.affinity = affinity;
	}
	
	
}
