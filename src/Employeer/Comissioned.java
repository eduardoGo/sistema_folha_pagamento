package Employeer;

import java.util.ArrayList;

import Sales.Sale;

public class Comissioned extends Empregado{

	private ArrayList<Sale> sales = new ArrayList<Sale>();
	private double percentageSales = 0.15;
	
	
	public ArrayList<Sale> getSales() {
		return sales;
	}
	public void addSales(Sale sale) {
		this.sales.add(sale);
	}
	public double getPercentageSales() {
		return percentageSales;
	}
	public void setPercentageSales(double percentageSales) {
		this.percentageSales = percentageSales;
	}
	
	

}
