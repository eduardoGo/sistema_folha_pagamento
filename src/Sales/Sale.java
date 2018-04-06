package Sales;

import java.util.Scanner;

import DateHour.Date;

public class Sale {

	private Date date;
	private float value;
	
	Scanner input = new Scanner(System.in);
	
	public Sale() {
		System.out.println("Date of sale:");
		this.date = new Date();
		System.out.print("Value of the sale: ");
		this.value = input.nextInt();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
	
	
	
}
