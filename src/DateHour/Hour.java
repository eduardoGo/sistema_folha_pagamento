package DateHour;

import java.util.Scanner;

public class Hour {
	
	private int hour;
	private int minute;
	
	Scanner input = new Scanner(System.in);
	
	public Hour(int option) {
		int hourAux;
		int minuteAux;
		
		
		if(option == 1)
			System.out.println("Hour start");
		else if(option == 2)
			System.out.println("Hour end");
		
		System.out.println("Format 24hrs");
		while(true) {
			
			
			System.out.print("Hour: ");
			hourAux = input.nextInt();
			System.out.print("Minute: ");
			minuteAux = input.nextInt();
			
			if(hourAux < 0 || hourAux > 24 ) {
				System.out.println("Invalid hour");
				hourAux = -1;
				continue;
			}else {
				this.hour = hourAux;
			}
				
			if(minuteAux < 0 || minuteAux >= 60) {
				System.out.println("Invalid minute");
				minuteAux = -1;
				continue;
			}else {
				this.minute = minuteAux;
			}
			
			if(minute != -1 && hour != -1)
				break;
				
		}
		
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	

}
