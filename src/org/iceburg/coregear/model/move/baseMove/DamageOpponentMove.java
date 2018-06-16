package org.iceburg.coregear.model.move.baseMove;

import org.iceburg.coregear.model.move.calculatedMove.CalculatedMove;
import org.iceburg.coregear.model.move.calculatedMove.DamageOpponent;
import org.iceburg.coregear.model.part.Part;

public class DamageOpponentMove extends Move{
	private int damageAmount;
	

	@Override
	public CalculatedMove calculateMove(Part source, Part target) {
		DamageOpponent move = new DamageOpponent(this);
		move.setSource(source);
		move.setTarget(target);
		move.setAmount(calcAmount(source, target));
		return move;
	}
	
	private int calcAmount(Part source, Part target) {
		int amount = (int) (damageAmount * source.getAffinity().getAffinity(target.getAffinity()));
		return amount;
	}

	public void setDamageAmount(int amount) {
		this.damageAmount = amount;
	}




}
