package org.iceburg.coregear.main;

import org.iceburg.coregear.model.Mech;

public class Battle {
	private Mech mechA, mechB;
	private int turn;
	
	public Battle(Mech mechA, Mech mechB){
		this.mechA = mechA;
		this.mechB = mechB;
	}
	
	public Mech getMechA() {
		return mechA;
	}

	public Mech getMechB() {
		return mechB;
	}
	public Mech getOpponent(Mech source){
		if (source == getMechA()){
			return getMechB();
		} else {
			return getMechA();
		}
		
	}

	public int getTurn() {
		return turn;
	}
	private boolean isEvenTurn() {
		return getTurn() % 2 == 0;
	}

	public void nextTurn() {
		this.turn++;
	}
	
	public boolean isMechsTurn(Mech mech){
		if (mech == getMechA() && isEvenTurn()){
			return true;
		}
		if (mech == getMechB() && !isEvenTurn()){
			return true;
		}
		return false;
	}

	public Mech getActiveMech(){
		if (isMechsTurn(getMechA())){
			return getMechA();
		}
		return getMechB();
	}


}
