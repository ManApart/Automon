package org.iceburg.coregear.main;

import org.iceburg.coregear.main.model.MockMech;
import org.iceburg.coregear.model.Mech;

public class MockBattle {
	
	public static void main(String[] args){
		Mech mechA = MockMech.mockMechRacer();
		Mech mechB = MockMech.mockMechTank();
		
		ConsoleApp app = new ConsoleApp();
		app.getPlayer().setMech(mechA);
		app.startBattle(mechA, mechB);
		
		
	}

}
