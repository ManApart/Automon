package org.iceburg.coregear.model.part;

public class Arm extends Part {

	private boolean rightArm;
	
	public Arm(boolean right){
		this.rightArm = right;
	}
	
	public boolean isRightArm(){
		return rightArm;
	}
}
