package org.iceburg.coregear.model.move.calculatedMove;

import org.iceburg.coregear.model.move.baseMove.Move;
import org.iceburg.coregear.model.part.Part;

public class DamageOpponent extends CalculatedMove {
	private Part source, target;
	private int amount;
	
	public DamageOpponent(Move baseMove) {
		super(baseMove);
	}

	@Override
	public void doMove() {
		target.incHealth(-amount);
		
	}

	@Override
	public String moveReport() {
		return source.getParentMech() + " attacks with " + getBaseMove().getName() + " and does " + amount + " damage to " + target.getParentMech().getCore().getName() + "'s " + target.getName() + "!";
	}
	
	
	public Part getSource() {
		return source;
	}


	public void setSource(Part source) {
		this.source = source;
	}


	public Part getTarget() {
		return target;
	}


	public void setTarget(Part target) {
		this.target = target;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
