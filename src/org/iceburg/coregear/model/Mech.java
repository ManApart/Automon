package org.iceburg.coregear.model;

import org.iceburg.coregear.model.part.Arm;
import org.iceburg.coregear.model.part.Head;
import org.iceburg.coregear.model.part.Legs;

public class Mech {
	private Core core;
	private Head head;
	private Arm armRight, armLeft;
	private Legs legs;


	@Override
	public String toString(){
		if (core != null){
			return core.getPlayerGivenName();
		}
		return "Mech";
	}
	
	public int getHealthCurrent(){
		return head.getHealthCurrent() + armRight.getHealthCurrent() + armLeft.getHealthCurrent() + legs.getHealthCurrent();
	}
	public int getHealthTotal(){
		return head.getHealthTotal() + armRight.getHealthTotal() + armLeft.getHealthTotal() + legs.getHealthTotal();
	}
	
	
	
	
	public Core getCore() {
		return core;
	}
	public void setCore(Core core) {
		this.core = core;
		core.setCurrentMech(this);
	}
	public Head getHead() {
		return head;
	}
	public void setHead(Head head) {
		this.head = head;
		head.setParentMech(this);
	}
	public Arm getArmRight() {
		return armRight;
	}
	public void setArmRight(Arm armRight) {
		this.armRight = armRight;
		armRight.setParentMech(this);
	}
	public Arm getArmLeft() {
		return armLeft;
	}
	public void setArmLeft(Arm armLeft) {
		this.armLeft = armLeft;
		armLeft.setParentMech(this);
	}
	public Legs getLegs() {
		return legs;
	}
	public void setLegs(Legs legs) {
		this.legs = legs;
		legs.setParentMech(this);
	}
	
	
	
	
	
}