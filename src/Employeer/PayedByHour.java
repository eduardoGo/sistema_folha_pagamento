package Employeer;

public class PayedByHour extends Empregado{

	
	private int extraHours=0;

	public int getExtraHours() {
		return extraHours;
	}

	public void addExtraHours(int extraHours) {
		this.extraHours += extraHours;
	}

	public void setExtraHours(int extraHours) {
		this.extraHours = extraHours;
	}
	
	
}
