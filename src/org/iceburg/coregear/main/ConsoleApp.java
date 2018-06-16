package org.iceburg.coregear.main;

import java.util.Scanner;

import org.iceburg.coregear.model.Mech;
import org.iceburg.coregear.model.move.baseMove.Move;
import org.iceburg.coregear.model.move.calculatedMove.CalculatedMove;
import org.iceburg.coregear.model.part.Part;

public class ConsoleApp extends AutomonApp{
	private Scanner scanner;
	private JavaFXConsole console;
	
	public ConsoleApp(){
		super();
		scanner = new Scanner(System.in);
		console = new JavaFXConsole();
//		console.launch();
	}
	
	/*
	 * Utilities
	 */
	public void startBattle(Mech mechA, Mech mechB){
		display("Starting mock battle between " + mechA + " and " + mechB);
		setBattle(new Battle(mechA, mechB));
		showMainBattleMenu();
	}
	
	private void display(String message){
		System.out.println(message);
	}
	
	private void display(String[] messages, int optionStart){
		String messageOut = "";
		int n=0;
		for (int i=0; i< messages.length; i++){
			if (i!=0){
				messageOut += "\n";
			}
			if (i >= optionStart){
				n++;
				messageOut += n + ")";
			}
			messageOut += messages[i];
		}
		
		System.out.println(messageOut);
	}
	
	private boolean booleanPrompt(String message){
		display(message +" (Y/N)");
		String in = scanner.nextLine();
		if (in.equalsIgnoreCase("Y")){
			return true;
		} else if (in.equalsIgnoreCase("N")){
			return false;
		} else{
			return booleanPrompt(message);
		}
	}
	
	private int getNumberIn(){
		String in = scanner.nextLine();
		if (in.equals("\n") || in.equals("\r\n") || in.isEmpty()){
			return 1;
		}
		try {
			int i = Integer.parseInt(in);
			return i;
		}
		catch (Exception e){
			return -1;
		}
	}
	
	private void nextTurn() {
		getBattle().nextTurn();		
		showMainBattleMenu();
	}
	
	
	/*
	 * Menus
	 */
	
	private void showMainBattleMenu(){
		String info = getBattle().getActiveMech() + "'s turn:"
			+ "\n1) " + getBattle().getMechA() + ": " + getBattle().getMechA().getHealthCurrent() + "/" + getBattle().getMechA().getHealthTotal()
			+ "\n2) " + getBattle().getMechB() + ": " + getBattle().getMechB().getHealthCurrent() + "/" + getBattle().getMechB().getHealthTotal();
		display(info);
		int choice = getNumberIn();
		if (choice == 1){
			showMechParts(getBattle().getMechA());
		} else if (choice == 2){
			showMechParts(getBattle().getMechB());
		} else{
			showMainBattleMenu();
		}
	}
	
	private void showMechParts(Mech mech){
		boolean giveOptions = getBattle().isMechsTurn(mech);
		Part choice = displayParts(mech, giveOptions);
		if (choice != null){
			showMechPart(choice);
		} else{
			showMainBattleMenu();
		}
	}
	
	private Part displayParts(Mech mech, boolean giveOptions){
		
		String info = mech
				+ "\n" + mech.getCore().getName()
				+ "\n1) Head: " + printPart(mech.getHead())
				+ "\n2) Right Arm: " + printPart(mech.getArmRight())
				+ "\n3) Left Arm: " + printPart(mech.getArmLeft())
				+ "\n4) Legs: " + printPart(mech.getLegs())
				+ "\n5) Back";
		
		if (!giveOptions){
			info = mech
				+ "\n" + mech.getCore().getName()
				+ "\n1) Head: " + printPart(mech.getHead())
				+ "\n2) Right Arm: " + printPart(mech.getArmRight())
				+ "\n3) Left Arm: " + printPart(mech.getArmLeft())
				+ "\n4) Legs: " + printPart(mech.getLegs())
				+ "\n5) Back";
		}
		
		display(info);
		int choice = getNumberIn();
		
		if (!giveOptions){
			return null;
		}
		
		Part[] parts = new Part[]{
				mech.getHead(), mech.getArmRight(),mech.getArmLeft(),mech.getLegs()
		};
		if (choice <= parts.length){
			return parts[choice-1];
		} else{
			return null;
		}
	}
	
	private String printPart(Part part){
		return part + " " + part.getHealthCurrent() + "/" + part.getHealthTotal();
	}
	
	private void showMechPart(Part part){
		String info = part
				+ "\nHealth: " + part.getHealthCurrent()  + "/" +part.getHealthTotal();

		if (part.getBuffs().size() > 0){
			info += "\nBuffs:";
			
		}
		if (part.getMoves().size() > 0){
			info += "\nMoves:";
			for (int i=0; i< part.getMoves().size(); i++){
				Move move = part.getMoves().get(i);
				info += "\n" +(i+1) + ") "+ move
					+ "\n  - Cost: " + move.getEnergyCost()
					+ "\n  - " + move.getDescription();
			}
		}
		
		display(info);
		int choice = getNumberIn();
		if (choice <= part.getMoves().size()){
			Move moveBase = part.getMoves().get(choice-1);
			showAimMove(moveBase);
		}
		showMechParts(part.getParentMech());
	}
	
	private void showAimMove(Move moveBase){
		Mech opponent = getBattle().getOpponent(moveBase.getParentPart().getParentMech());
		display("Target which of " + opponent +"'s parts?");
		Part target = displayParts(opponent, true);
		
		if (target == null){
			display("No target for " + moveBase);
			showMechPart(moveBase.getParentPart());
		}
		
		CalculatedMove move = moveBase.calculateMove(moveBase.getParentPart(), target);
		if (move != null){
			display(move.moveReport());
			move.doMove();
			if (target.getHealthCurrent() <=0 ){
				display(target.getName() + " has been destroyed!");
			}
			nextTurn();
		} else{
			display("Unable to perform " + moveBase);
			showMechPart(moveBase.getParentPart());
		}
	}

	
}
