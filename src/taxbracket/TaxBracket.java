package taxbracket;

import java.util.Scanner;

public class TaxBracket {
	
	public final double RATE1 = 0.0505; // Tax rates
	public final double RATE2 = 0.0915;
	public final double RATE3 = 0.116;
	public final double RATE4 = 0.1216;
	public final double RATE5 = 0.1316;

	public final double T1 = 45142; // Tax brackets 
	public final double T2 = 90287;
	public final double T3 = 150000;
	public final double T4 = 220000;
	
	public final boolean BR1 = false; // True/False for determining brackets in receipt
	public final boolean BR2 = false;
	public final boolean BR3 = false;
	public final boolean BR4 = false;
	
			
			
	double income = 0;
	double tax = 0;
	
	public void DataCollection(String[] args) {
		
		Scanner IncomeIn = new Scanner(System.in); // Construct Scanner
		System.out.print("Enter income = ");
		income = IncomeIn.nextDouble(); // Read in next double into income

		System.out.println("Tax = " + tax);

		
	}
	
	
	public void TaxMath(String[] args) {
		
		if (income <= T1) {
			
			tax = RATE1 * income;

		}else if (income <= T2) {
			tax = RATE1 * T1 + RATE2 * (income - T1);

		} else if (income <= T3) {
			tax = RATE1 * T1 + RATE2 * (income - T2) + RATE3 * (income - T3);

		} else if (income <= T4) {
			tax = RATE1 * T1 + RATE2 * (income - T2) + RATE3 * (income - T3) + RATE4 * (income - T4);
			
		} else 
			tax = income * RATE5;
			
		}
	
	
	
	public void main(String[] args) {
		
		
		DataCollection(args); // Call scanner input TODO Replace me with a GUI input
		TaxMath(args); // Call TaxMath to handle data gathered by DataCollection
		

	}


}
