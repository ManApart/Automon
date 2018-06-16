package org.iceburg.coregear.model.move.calculatedMove;

import org.iceburg.coregear.model.move.baseMove.Move;

public abstract class CalculatedMove {
	private Move baseMove;
	
	public CalculatedMove(Move baseMove){
		this.baseMove = baseMove;
	}
	
	public abstract void doMove();
	public abstract String moveReport();
	
	
	public Move getBaseMove(){
		return this.baseMove;
	}
	

	
}
