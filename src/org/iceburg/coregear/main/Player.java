package org.iceburg.coregear.main;

import org.iceburg.coregear.model.Mech;

public class Player {
	private Mech mech;
	
	
	public boolean isPlayerMech(Mech mech){
		return this.mech == mech;
	}
	
	public void setMech(Mech mech){
		this.mech = mech;
	}

}
