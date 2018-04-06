package Employeer;

import java.util.ArrayList;

import DateHour.Date;
import Payment.PaymentSchedule;
import Sales.Sale;
import Syndicate.Sindicato;

import java.util.Scanner;


public class DadosEmpregados {
	
	private  ArrayList<Empregado> registeredEmployees = new ArrayList<Empregado>();
	private ArrayList<PaymentSchedule> paymentSchedules = new ArrayList<PaymentSchedule>();
	private Sindicato syndicate = new Sindicato();
	
	private  int identification = 1;
	
	Scanner input = new Scanner(System.in);
	
	
	
	
	public DadosEmpregados() {
		paymentSchedules.add(new PaymentSchedule("1",false,true));
		paymentSchedules.add(new PaymentSchedule("2",false,true));
		paymentSchedules.add(new PaymentSchedule("1",true,false));
	}

	public void newEmployer() {
		
		System.out.print("Enter the employee's name: ");
		String name = input.next();
		System.out.print("Enter the employee's address: ");
		String adress = input.next();
		
		Empregado newEmployee = PutNewTypeEmployee();
		
		newEmployee.setName(name);
		newEmployee.setAddres(adress);
		
	
		
		newEmployee.paymentMethod();
		
		newEmployee.setPaymentSchedule(choosePaymentSchedule());
		
		System.out.println("Today's date:");
		
		newEmployee.setLastPayment(new Date());
		
		System.out.printf("The employee identification is %d%n", this.identification);
		
		newEmployee.setNumberIdentification(this.identification++);
		
		this.registeredEmployees.add(newEmployee);
		
		this.identification++;
		
		
		

	}
	
	private Empregado PutNewTypeEmployee() {
		int typeEmployee = 0;
		
		do {
			System.out.println("Select the type:");
			System.out.println("[1] Non-commissioned employee");
			System.out.println("[2] Commissioned employee");
			System.out.println("[3] Payed by hour");
			typeEmployee = input.nextInt();
			if(typeEmployee <= 0 || typeEmployee >= 4 )
				System.out.println("Invalid input!");
		}while(typeEmployee <= 0 || typeEmployee >= 4);
		
		if(typeEmployee == 1)
			return new NonComissioned();
		else if(typeEmployee == 2)
			return new Comissioned();
		else
			return new PayedByHour();
		
	}
	
	public void removeEmployee() { 
		
		int remove = 0;
		do {
			
			System.out.printf("Enter the employee identification: ");
			remove = input.nextInt();
			if(remove <= 0 || remove > this.identification)
				System.out.println("Invalid identification!");
			
		}while(remove <= 0 || remove > this.identification);
		
		registeredEmployees.remove(remove-1);
		
		System.out.println("Finish!");
	}
	
	public void addCardPoint() {
		
		Empregado currentEmployee = searchEmployee();
		if(currentEmployee == null)
			return;
		
		
		
		currentEmployee.getCardPoint().addPoint(currentEmployee);
		
		
		System.out.println("Finish!");
		
	}
	
	
	public Empregado searchEmployee() {
		
		Empregado currentEmployee = null;
		do {
			System.out.print("Enter the employee identification: ");
			int identificationAux = input.nextInt();
			currentEmployee = null;
			
			for(Empregado employeeAux : registeredEmployees) {
				if(employeeAux.getNumberIdentification() == identificationAux)
					currentEmployee = employeeAux;
				
					
			}
			if(currentEmployee == null) {
				System.out.printf("Invalid identification!%n"
						+ "[1] Try again [2] Back to main menu%n");
				if(input.nextInt() == 2)
					return null;
			}
		}while(currentEmployee == null);
		
		return currentEmployee;
	}
	
	public void editEmployee() {
		
		Empregado currentEmployee = searchEmployee();
		if(currentEmployee == null)
			return;
		
		
		
		boolean flag = true;
		int option;
		
		System.out.println("Select the employee information you want to edit:");
		do {
			System.out.printf("[1] Name%n[2] Address%n[3] Type%n[4] Payment Method%n"
					+ "[5] Sign in/out Syndicate%n[6] Syndical rate%n[7] Gross salary");
			
			option = input.nextInt();
			
			switch(option) {
				case 1:
					System.out.print("New name: ");
					currentEmployee.setName(input.next());
					break;
				case 2:
					System.out.print("New addres: ");
					currentEmployee.setAddres(input.next());
					break;
				case 3:
					currentEmployee = PutNewTypeEmployee();
					
					break;
				case 4:
					currentEmployee.paymentMethod();
					break;
				case 5:
					syndicate.enterOrExit(currentEmployee);
					break;
				case 6:
					syndicate.editSyndicateFee(currentEmployee);
					break;
				case 7:
					System.out.print("New gross salary: ");
					currentEmployee.setGrossSalary(input.nextFloat());
					break;
				default:
					System.out.println("Invalid input!");
					break;
			}
			
			System.out.printf("Edit again ?%n[1] Yes [2] No%n");
			if(input.nextInt() == 2)
				flag = false;
			
		}while(flag);
		
	}
	
	public void addSalesResult() {
		
		Empregado currentEmployee = searchEmployee();
		if(currentEmployee == null)
			return;
		if(!(currentEmployee instanceof Comissioned)){
			System.out.println("User don't is comissioned");
			return;
		}
		
		( (Comissioned) currentEmployee).getSales().add(new Sale());
	}
	
	public void serviceFee() {
		
		Empregado currentEmployee = searchEmployee();
		if(currentEmployee == null)
			return;
		
		Sindicato.throwServiceFee(currentEmployee);
	}
	
	public PaymentSchedule choosePaymentSchedule() {
		int option = 1;
		boolean verification = false;
		do {
			System.out.println("Select the payment schedule:");
			for(PaymentSchedule scheduleAux : paymentSchedules)
				System.out.printf("[%d] %s%n", option++,scheduleAux.getSchedule());
			
			option = input.nextInt();
			if(option > paymentSchedules.size() || option < 0) {
				System.out.println("Invalid input");
				option = 1;
			}else
				verification = true;
				
			
		}while(!verification);
		
		return paymentSchedules.get(option-1);
	}
	
	public void paymentSchedule() {
		
		Empregado currentEmployee = searchEmployee();
		if(currentEmployee == null)
			return;
		
		System.out.printf("Current payment shedule: %s%n", currentEmployee.getPaymentSchedule().getSchedule());
		System.out.printf("To edit ?%n[1] Yes [2] No");
		if(input.nextInt() == 1)
			currentEmployee.setPaymentSchedule(choosePaymentSchedule());
		
	}
	public void newPaymentSchedule() {
		paymentSchedules.add(new PaymentSchedule());
	}
	
	public void payroll() {
		System.out.println("Today's date:");
		Date todayDate = new Date();
		
		for(Empregado auxEmployee : registeredEmployees ) {
			if(mustBePaid(auxEmployee,todayDate)) {
				
				pay(auxEmployee);
				auxEmployee.setLastPayment(todayDate);
			}
				
			
		}
	}
	
	private boolean mustBePaid(Empregado employee,Date todayDate) {
		PaymentSchedule auxSchedule = employee.getPaymentSchedule();
		int weeks;
		int total;
		int daysWorkeds=0;
		int[] daysPerMonth = Date.getDayspermonth();
		
	
		
		if(auxSchedule.isWeekly()) {
			
			
			weeks = Integer.parseInt(auxSchedule.getDay());
			total = weeks*7;
			if(auxSchedule.getDayWeekly().equals("Tuesday"))
				total += 1;
			else if(auxSchedule.getDayWeekly().equals("Wednesday"))
				total += 2;
			else if(auxSchedule.getDayWeekly().equals("Thursday"))
				total += 3;
			else if(auxSchedule.getDayWeekly().equals("Friday"))
				total += 4;
			
		}else {
			if( (employee.getLastPayment().getMonth() +1) == todayDate.getMonth() &&
				employee.getLastPayment().getDay() == todayDate.getDay())
				return true;
			else
				return false;
		}
		
		 if(todayDate.getMonth() != employee.getLastPayment().getMonth()){

             daysWorkeds += daysPerMonth[employee.getLastPayment().getMonth()]
                     - employee.getLastPayment().getDay();
             daysWorkeds += todayDate.getDay();

         }
         else{
             daysWorkeds = todayDate.getDay() - employee.getLastPayment().getDay();
         }
		 
		 if(daysWorkeds >= total)
			 return true;
		 else 
			 return false;
		
	}
	
	private void pay(Empregado employee) {
		
		System.out.printf("Name: %s%nIdentification: %d%n",employee.getName(),employee.getNumberIdentification());
		
		double deductios = deductions(employee);
		double salesValue = 0;
		double extraHourValue = 0;
		System.out.printf("Gross salary: %.2f%n",employee.getGrossSalary());
		if(employee instanceof Comissioned) {
			
			salesValue = totalSalesValue(employee)*((Comissioned) employee).getPercentageSales();
			System.out.printf("Sales made: %.2f%n", salesValue);
			((Comissioned) employee).getSales().clear();
			
		}
		else if(employee instanceof PayedByHour) {
			System.out.printf("Extra Hours: %d", ((PayedByHour)employee).getExtraHours());
			extraHourValue = ((PayedByHour) employee).getExtraHours()*5;
			

			((PayedByHour) employee).setExtraHours(0);
			
		}
		
		System.out.printf("Net salary: %.2f%n", employee.getGrossSalary() + extraHourValue
				+ salesValue - deductios);
		
		
	}
	private float totalSalesValue(Empregado employee) {
		
		float total=0;
		for(Sale auxSale : ((Comissioned) employee).getSales())
			total += auxSale.getValue();
		
		return total;
	}
	
	private double deductions(Empregado employee) {
		if(!employee.isPertenceSindicato())
			return 0;
		
		System.out.printf("Service fee: %.2f%nUnion fee: %.2f%n",employee.getServiceFee(),employee.getSyndicalFee());
		return employee.getServiceFee() + employee.getSyndicalFee();
		
	}
	
	
}
