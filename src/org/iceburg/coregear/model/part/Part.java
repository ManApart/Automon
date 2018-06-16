package org.iceburg.coregear.model.part;

import java.util.ArrayList;

import org.iceburg.coregear.model.Affinity;
import org.iceburg.coregear.model.Mech;
import org.iceburg.coregear.model.buff.Buff;
import org.iceburg.coregear.model.move.baseMove.Move;

public abstract class Part {

	private int healthBase, healthTotal, healthCurrent;
	private String name, description;
	private Affinity affinity;
	private ArrayList<Move> moves;
	private ArrayList<Buff> buffs;
	private Mech parentMech;
	
	public Part(){
		this.moves = new ArrayList<Move>();
		this.buffs = new ArrayList<Buff>();
		setHealthBase(100);
	}
	
	@Override
	public String toString(){
		return getName();
	}

	public ArrayList<Move> getMoves() {
		return moves;
	}
	public void addMove(Move move) {
		this.moves.add(move);
		move.setParentPart(this);
	}
	public ArrayList<Buff> getBuffs() {
		return buffs;
	}
	public void addBuff(Buff buff) {
		this.buffs.add(buff);
	}
	public Mech getParentMech() {
		return parentMech;
	}
	public void setParentMech(Mech currentMech) {
		this.parentMech = currentMech;
	}

	public int getHealthTotal() {
		return healthTotal;
	}
	public void setHealthTotal(int healthTotal) {
		this.healthTotal = healthTotal;
		setHealthCurrent(healthTotal);
		
	}
	public void incHealth(int amount) {
		this.healthCurrent += amount;
	}

	public int getHealthCurrent() {
		return healthCurrent;
	}
	public String getName(){
		return this.name;
	}
	public String getDescription(){
		return this.description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHealthBase() {
		return healthBase;
	}

	public void setHealthBase(int healthBase) {
		this.healthBase = healthBase;
		setHealthTotal(healthBase);
	}

	private void setHealthCurrent(int healthCurrent) {
		this.healthCurrent = healthCurrent;
	}

	public Affinity getAffinity() {
		return affinity;
	}

	public void setAffinity(Affinity affinity) {
		this.affinity = affinity;
	}

	
	
}
