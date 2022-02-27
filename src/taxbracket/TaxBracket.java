package taxbracket;

import java.util.Scanner;
import java.text.DecimalFormat;

public class TaxBracket {

	static public final double RATE1 = 0.0505; // Provincial tax rates
	static public final double RATE2 = 0.0915;
	static public final double RATE3 = 0.116;
	static public final double RATE4 = 0.1216;
	static public final double RATE5 = 0.1316;

	static public final double T1 = 45142; // Provincial tax brackets
	static public final double T2 = 90287;
	static public final double T3 = 150000;
	static public final double T4 = 220000;

	static public final double fRATE1 = 0.15; // Federal tax rates
	static public final double fRATE2 = 0.205;
	static public final double fRATE3 = 0.26;
	static public final double fRATE4 = 0.29;
	static public final double fRATE5 = 0.33;

	static public final double fT1 = 49020; // Federal tax brackets
	static public final double fT2 = 98040;
	static public final double fT3 = 151978;
	static public final double fT4 = 216511;

	static String Province = "Ontario";
	static String Country = "Canada";
	static double income = 0;
	static double tax = 0;
	static double ftax = 0;
	static DecimalFormat money = new DecimalFormat("###,###,###.##$");
	
	
	public static void DataCollection(String[] args) {

		
		if (income <= 0) {
			System.out.println("Income cannot be less than or equal to 0, try again");
			main(null);

		} else {

			TaxMath(null);
		}

	}

	public static void TaxMath(String[] args) {

		if (Province == "Ontario") { // PROVINCIAL TAX
										// ---------------------------------------------------------------------------
			if (income <= T1) // Bracket 1 between 1 and 45142
				tax = RATE1 * income;
			else if (income <= T2) // Bracket 2 between 45142 and 90287
				tax = RATE1 * T1 + RATE2 * (income - T1);
			else if (income <= T3) // Bracket 3 between 90287 and 150000
				tax = RATE1 * T1 + RATE2 * (income - T1) + RATE3 * (income - T2);
			else if (income <= T4) // Bracket 4 between 150000 and 200000
				tax = RATE1 * T1 + RATE2 * (income - T1) + RATE3 * (income - T2) + RATE4 * (income - T3);
			else // Bracket 5 above 200000
				tax = RATE1 * T1 + RATE2 * (income - T1) + RATE3 * (income - T2) + RATE4 * (income - T3)
						+ RATE5 * (income - T4);
		}
		System.out.println("Provincial tax: " + money.format(tax));

		if (Country == "Canada") { // FEDERAL TAX
						// ---------------------------------------------------------------------------------------------
			if (income <= fT1) // Bracket 1 between 1 and 45142
				ftax = fRATE1 * income;
			else if (income <= fT2) // Bracket 2 between 45142 and 90287
				ftax = fRATE1 * fT1 + fRATE2 * (income - fT1);
			else if (income <= fT3) // Bracket 3 between 90287 and 150000
				ftax = fRATE1 * fT1 + fRATE2 * (income - fT1) + fRATE3 * (income - fT2);
			else if (income <= fT4) // Bracket 4 between 150000 and 200000
				ftax = fRATE1 * fT1 + fRATE2 * (income - fT1) + fRATE3 * (income - fT2) + fRATE4 * (income - fT3);
			else // Bracket 5 above 200000
				ftax = fRATE1 * fT1 + fRATE2 * (income - fT1) + fRATE3 * (income - fT2) + fRATE4 * (income - fT3)
						+ RATE5 * (income - fT4);
		}
		System.out.println("Federal tax: " + money.format(ftax));
	}

	public static void main(String[] args) {

		DataCollection(args); // Call scanner input TODO Replace me with a GUI input

	}

}
