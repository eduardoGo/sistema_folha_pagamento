package Employeer;
import Card.Card;
import DateHour.Date;


import java.util.Scanner;

import enums.PaymentMethod;

import Payment.PaymentSchedule;

public class Empregado {
	
	private String name;
	private String addres;
	private int numberIdentification;
	
	private boolean pertenceSindicato;
	private int numeroUnicoSindicato;
	private double syndicalFee=0;
	private double serviceFee=0;
	
	private Date lastPayment;
	private double grossSalary = 2000;
	
	
	private Card cardPoint = new Card();
	private PaymentMethod paymentMethod = null;
	
	private PaymentSchedule paymentSchedule;
	
	Scanner input = new Scanner(System.in);
	

	
	public void paymentMethod() {
		
		if(paymentMethod != null)
			System.out.printf("Current method: %s\n", this.paymentMethod);
		
		int method = 0;
		do {
			System.out.println("Enter the new method that you want:");
			System.out.println("[1] Check by mail");
			System.out.println("[2] Check in hands");
			System.out.println("[3] Deposit in account bank");
			method = input.nextInt();
			if(method <= 0 || method >= 4 )
				System.out.println("Invalid input!");
		}while(method <= 0 || method >= 4 );
		
		if(method == 1)
			this.paymentMethod = PaymentMethod.CHECK_MAIL;
		else if(method == 2)
			this.paymentMethod = PaymentMethod.CHECK_HANDS;
		else
			this.paymentMethod = PaymentMethod.DEPOSIT_ACCOUNT;
		
	}
	
	
	
	
	


	public double getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(float serviceFee) {
		this.serviceFee = serviceFee;
	}


	public String getName() {
		return name;
	}

	public String getAddres() {
		return addres;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}



	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}

	public Date getLastPayment() {
		return lastPayment;
	}

	public void setLastPayment(Date lastPayment) {
		this.lastPayment = lastPayment;
	}

	public PaymentSchedule getPaymentSchedule() {
		return paymentSchedule;
	}

	public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
		this.paymentSchedule = paymentSchedule;
	}

	public void addServiceFee(float fee) {
		this.serviceFee += fee;
	}
	public double getSyndicalFee() {
		return syndicalFee;
	}

	public void setSyndicalFee(float syndicalFee) {
		this.syndicalFee = syndicalFee;
	}


	public void setPertenceSindicato(boolean pertenceSindicato) {
		this.pertenceSindicato = pertenceSindicato;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}


	public Card getCardPoint() {
		return cardPoint;
	}

	public void setCardPoint(Card cardPoint) {
		this.cardPoint = cardPoint;
	}

	public int getNumberIdentification() {
		return this.numberIdentification;
	}

	public void setNumberIdentification(int numberIdentification) {
		this.numberIdentification = numberIdentification;
	}

	public int getNumeroUnicoSindicato() {
		return this.numeroUnicoSindicato;
	}

	public void setNumeroUnicoSindicato(int numeroUnicoSindicato) {
		this.numeroUnicoSindicato = numeroUnicoSindicato;
	}

	
	
	
	public boolean isPertenceSindicato() {
		return pertenceSindicato;
	}

	int taxaSindical() {
		if(pertenceSindicato) 
			return 1;
		else
			 return 0;
		
	}
	
}
