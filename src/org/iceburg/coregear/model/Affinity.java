package org.iceburg.coregear.model;

import java.util.HashMap;

public enum Affinity {
	WATER, WIND, FIRE, EARTH;
	
	private HashMap<Affinity, Float> attackMap;
	
	private void init(float water, float wind, float fire, float earth){
		attackMap = new HashMap<>();
		attackMap.put(WATER, water);
		attackMap.put(WIND, wind);
		attackMap.put(FIRE, fire);
		attackMap.put(EARTH, earth);
	};
	
	public float getAffinity(Affinity defender){
		return attackMap.get(defender);
	}
	
	
	static {
		WATER.init(1, 1, 1, 1);
		WIND.init(2, 1, 0.5f, 0.5f);
		FIRE.init(1, 2, 1, 1);
		EARTH.init(0.5f, 1, 2, 1);
	}
	
	
}
