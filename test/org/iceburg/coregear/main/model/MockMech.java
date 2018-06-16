package org.iceburg.coregear.main.model;

import org.iceburg.coregear.model.Affinity;
import org.iceburg.coregear.model.Core;
import org.iceburg.coregear.model.Mech;
import org.iceburg.coregear.model.move.baseMove.DamageOpponentMove;
import org.iceburg.coregear.model.part.Arm;
import org.iceburg.coregear.model.part.Head;
import org.iceburg.coregear.model.part.Legs;
import org.iceburg.coregear.model.part.Part;

public class MockMech {
	
	
	public static Mech mockMechRacer(){
		Mech mech = new Mech();
		mech.setCore(mockCore("Hot Rod", "Racer", Affinity.WIND));
		mech.setHead(mockHead("Revved", 100, Affinity.EARTH));
		mech.setArmRight(mockArm("Street Tire Arm", 80, true, Affinity.EARTH));
		addMockDamageOpponentMove(mech.getArmRight(), "Tire Burn", 10, 10, "Lunge forward and strike with a spinning tire.");
		
		mech.setArmLeft(mockArm("Street Tire Arm", 80,  false, Affinity.EARTH));
		addMockDamageOpponentMove(mech.getArmLeft(), "Side Swipe", 30, 30, "Side swipe the target as you move past them.");
		
		mech.setLegs(mockLegs("Street Tires", 100, Affinity.EARTH));
		return mech;
	}
	public static Mech mockMechTank(){
		Mech mech = new Mech();
		mech.setCore(mockCore("Tank", "TankShell", Affinity.EARTH));
		
		mech.setHead(mockHead("Head Cannon", 100, Affinity.EARTH));
		addMockDamageOpponentMove(mech.getHead(), "Fire Cannon", 50, 50, "Fire a powerful cannon shot");
		
		mech.setArmRight(mockArm("Thick Plated Arm", 120, true, Affinity.EARTH));
		mech.setArmLeft(mockArm("Thick Plated Arm", 120, false, Affinity.EARTH));
		mech.setLegs(mockLegs("Tank Treads", 120, Affinity.EARTH));
		return mech;
	}
	
	
	private static Core mockCore(String name, String playerName, Affinity affinity){
		Core core = new Core();
		core.setName(name);
		core.setPlayerGivenName(playerName);
		core.setAffinity(affinity);
		return core;
	}
	
	private static Head mockHead(String name, int health, Affinity affinity){
		Head head = new Head();
		head.setName(name);
		head.setHealthBase(health);
		head.setAffinity(affinity);
		return head;
	}
	private static Arm mockArm(String name, int health, boolean right, Affinity affinity){
		Arm arm = new Arm(right);
		arm.setName(name);
		arm.setHealthBase(health);
		arm.setAffinity(affinity);
		return arm;
	}
	private static Legs mockLegs(String name, int health, Affinity affinity){
		Legs legs = new Legs();
		legs.setName(name);
		legs.setHealthBase(health);
		legs.setAffinity(affinity);
		return legs;
	}
	
	private static void addMockDamageOpponentMove(Part part, String name, int energyCost, int amount, String description){
		DamageOpponentMove move = new DamageOpponentMove();
		move.setName(name);
		move.setEnergyCost(energyCost);
		move.setDamageAmount(amount);
		move.setDescription(description);
		part.addMove(move);
	}

}
