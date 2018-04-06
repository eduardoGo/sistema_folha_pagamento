package DateHour;

import java.util.Scanner;

public class Date {

	
	private int month;
	private int day;
	private int year;
	

	private static final int[] daysPerMonth = 
		{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
	Scanner input = new Scanner(System.in);
	
	public Date(int month, int day, int year) {
		
		
		if(month <= 0 || month > 12)
			System.out.println("Error");
		
		
		if(day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
			System.out.println();
			
		if( month == 2 && day == 29 && !(year % 400 == 0 ||(year % 4 == 0 && year % 100 !=0)))
			System.out.println();
		
		this.month = month;
		this.day = day;
		this.year = year;
		
	}
	public Date() {
		int monthAux,dayAux,yearAux;
		
		while(true) {
			System.out.print("Month: ");
			monthAux = input.nextInt();
			System.out.print("Day: ");
			dayAux = input.nextInt();
			System.out.print("Year: ");
			yearAux = input.nextInt();
			
			if(monthAux <= 0 || monthAux > 12) {
				System.out.println("Invalid month");
				monthAux = -1;
				continue;
			}
			else
				this.month = monthAux;
			
			
			if(dayAux <= 0 || (dayAux > daysPerMonth[monthAux] && !(monthAux == 2 && dayAux == 29)))
			{	
				System.out.println("Invalid day");
				dayAux = -1;
				continue;
			}
			else
				this.day = dayAux;
				
			
			if(yearAux < 0 )
			{	
				System.out.println("Invalid year");
				yearAux = -1;
				continue;
			}
			else
				this.year = yearAux;
				
			
			if(monthAux != -1 && dayAux != -1 && yearAux != -1)
				break;
			
		}
			
	}
	
	
	public static int[] getDayspermonth() {
		return daysPerMonth;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	
	
}
