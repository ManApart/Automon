package org.iceburg.coregear.model.move.baseMove;

import org.iceburg.coregear.model.move.calculatedMove.CalculatedMove;
import org.iceburg.coregear.model.part.Part;

public abstract class Move {

	private boolean performInBattle = true;
	private String name, description;
	private int energyCost;
	private Part parentPart;
	
	public abstract CalculatedMove calculateMove(Part source, Part target);
	
	@Override
	public String toString(){
		return getName();
	}
	
	public boolean performInBattle(){
		return performInBattle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getEnergyCost() {
		return energyCost;
	}


	public void setEnergyCost(int energyCost) {
		this.energyCost = energyCost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Part getParentPart() {
		return parentPart;
	}

	public void setParentPart(Part parentPart) {
		this.parentPart = parentPart;
	}


	
}
