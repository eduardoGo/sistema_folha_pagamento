package Main;

import java.util.Scanner;

import Employeer.DadosEmpregados;


public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int option = 0;
		
		DadosEmpregados managerEmployee = new DadosEmpregados();
		
		
		System.out.println("Payroll System");
		do {
			
			System.out.println("- Enter the option that you want -");
			System.out.println("[1] Register new employee");
			System.out.println("[2] Edit employee informations");
			System.out.println("[3] Remove employee");
			System.out.println("[4] Throw a dot card");
			System.out.println("[5] Throw a sales result");
			System.out.println("[6] Throw a service fee");
			System.out.println("[7] Payroll");
			System.out.println("[8] Undo/redo");
			System.out.println("[9] Payment schedule");
			System.out.println("[10] Create new payment schedule");
			System.out.println("[0] Exit");
			
			option = input.nextInt();
			
			switch(option) {
			case 1:
				managerEmployee.newEmployer();
				
				break;
			case 2:
				managerEmployee.editEmployee();
				break;
			case 3:
				managerEmployee.removeEmployee();
				break;
			case 4:
				managerEmployee.addCardPoint();
				break;
			case 5:
				managerEmployee.addSalesResult();
				break;
			case 6:
				managerEmployee.serviceFee();
				break;
			case 7:
				managerEmployee.payroll();
				break;
			case 8:
				System.out.println("Function not available");
				break;
			case 9:
				managerEmployee.paymentSchedule();
				break;
			case 10:
				managerEmployee.newPaymentSchedule();
				break;
			default:
				break;
			}
			
		} while(option != 0);

			

		
		input.close();
	}

}
