package Syndicate;

import java.util.ArrayList;
import java.util.Scanner;

import Employeer.Empregado;


public class Sindicato {
	
	private static ArrayList<Empregado> affiliatedEmployees = new ArrayList<Empregado>();
	private static int numeroUnicoNoSindicato = 1;
	//se for usar pra saber a quantidade de empregadosdo sindicato, lembrar de diminuir -1
	
	
	static Scanner input = new Scanner(System.in);
	
	public void editSyndicateFee(Empregado currentEmployee) {
		
		if(!currentEmployee.isPertenceSindicato()) {
			System.out.printf("The employee does not belong to the syndicate%n");
			return;
		}
		
		System.out.printf("Current union fee: %.2f%nNew union fee: ",currentEmployee.getSyndicalFee());
		currentEmployee.setSyndicalFee(input.nextFloat());
		
			
	}
	
	public void enterOrExit(Empregado currentEmployee) {
		if(currentEmployee.isPertenceSindicato()) {
			
			System.out.printf("Leave the syndicate ?%n[1] Yes [2] No");
			if(input.nextInt() == 1) {
				currentEmployee.setPertenceSindicato(false);
				affiliatedEmployees.remove(currentEmployee);
				
			}
		}else {
			System.out.printf("Enter the syndicate ?%n[1] Yes [2] No%n");
			
			if(input.nextInt() == 1) {
				System.out.print("Union fee: ");
				currentEmployee.setSyndicalFee(input.nextFloat());
				currentEmployee.setPertenceSindicato(true);
				currentEmployee.setNumeroUnicoSindicato(numeroUnicoNoSindicato++);
				affiliatedEmployees.add(currentEmployee);
				
			}
		}
		
		
	}
	public static void throwServiceFee(Empregado currentEmployee) {
		
		if(!currentEmployee.isPertenceSindicato()) {
			System.out.printf("The employee does not belong to the syndicate%n");
			return;
		}
		
		System.out.print("The fee: ");
		currentEmployee.addServiceFee(input.nextFloat());
		
		
	}
}
