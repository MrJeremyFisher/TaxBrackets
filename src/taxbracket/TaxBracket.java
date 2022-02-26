package taxbracket;

import java.util.Scanner;

public class TaxBracket {

	public static final double RATE1 = 0.0505; // Tax rates
	public static final double RATE2 = 0.0915;
	public static final double RATE3 = 0.116;
	public static final double RATE4 = 0.1216;
	public static final double RATE5 = 0.1316;

	public static final double T1 = 45142; // Tax brackets
	public static final double T2 = 90287;
	public static final double T3 = 150000;
	public static final double T4 = 220000;

	public static boolean BR1 = false; // True/False for determining brackets in receipt
	public static boolean BR2 = false;
	public static boolean BR3 = false;
	public static boolean BR4 = false;
	public static boolean BR5 = false;

	static double income = 0;
	static double tax = 0;
	static double totalTax = 0;

	public static double netIncome() {

		Scanner IncomeIn = new Scanner(System.in); // Construct Scanner
		System.out.print("Enter income = ");
		income = IncomeIn.nextDouble(); // Read in next double into income

		double tax1 = 0;
		double tax2 = 0;
		double tax3 = 0;
		double tax4 = 0;
		double tax5 = 0;

		double part1 = 0;
		double part2 = 0;
		double part3 = 0;
		double part4 = 0;

		// Low Income bracket
		if (income >= T1) {
			part1 = income - T1; // part = income - 45142

			System.out.println("BLARGH: " + part1);

			tax1 = part1 * RATE1; // tax = tax + part * 5%
			System.out.println("LowTax, less than 45142 " + tax1);
			totalTax = tax1;

		}

		if (part1 <= 0) {

			Output(null); // if drops to zero or less abort and finalize

		}

		// Med income bracket
		if (part1 > T1 && part1 <= T2) {

			part2 = T2 - part1;
			tax2 = part2 * RATE2;

			System.out.println("BLARGH: " + part2);

			System.out.println("MedTax, more than 45142, less than 90287 " + tax2);
			totalTax = tax1 + tax2;

		}

		if (part2 <= 0) {

			Output(null); // if drops to zero or less abort and finalize

		}

		// MedHigh income bracket
		if (part2 > T2 && part1 <= T3) {
			part3 = T3 - part2;
			tax3 = part3 * RATE3;
			System.out.println("MedHighTax, more than 90287, less than 150000 " + tax3);
			totalTax = tax1 + tax2 + tax3;

		}

		if (part3 <= 0) {

			Output(null); // if drops to zero or less abort and finalize

		}

		// High income bracket
		if (part1 > T3 && part1 <= T4) {
			part4 = T4 - part3;
			tax4 = part4 * RATE4;
			System.out.println("MedTax, more than 150000, less than 220000 " + tax4);
			totalTax = tax1 + tax2 + tax3 + tax4;

		}

		return totalTax;

	}

	public static void Output(String[] args) {

		System.out.println(totalTax);

	}

	public static void main(String[] args) {
		netIncome();
	}

}
