package com.LucasWall.TAXman;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class TaxFinal implements ActionListener {
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel WelcomeLabel;
	private static JLabel label1;
	private static JLabel label2;
	private static JLabel Divider1Label;
	private static JLabel EnterLabel;
	private static JLabel FNameLabel;
	private static JTextField FNameText;
	private static JLabel LNameLabel;
	private static JTextField LNameText;
	private static JLabel SinLabel;
	private static JTextField SinText1;
	private static JTextField SinText2;
	private static JTextField SinText3;
	private static JLabel CityLabel;
	private static JLabel ProvinceLabel;
	private static JTextField CityText;
	private static JLabel IncomeLabel;
	private static JTextField IncomeText;
	private static JButton Calculate;
	private static JLabel RevenueCanadaLabel;
	private static JLabel IncomeTax2021;
	private static JLabel InfoEarn;
	private static JLabel NameVar;
	private static JLabel SinVar;
	private static JLabel ResidenceVar;
	private static JLabel YrEarn;
	private static JLabel FedTax;
	private static JLabel ProvTax;
	private static JLabel TotTax;
	private static JLabel EarnaftTax;
	public static String FName = "";
	public static String LName = "";
	public static double SIN1 = 0;
	public static double SIN2 = 0;
	public static double SIN3 = 0;
	public static String City = "";
	public static String YrEarnings = "";
	public static JComboBox<String> jComboBox;

	// JEremy's Globals
	public static JProgressBar bar = new JProgressBar();
	public static final double RATE1 = 0.0505; // Provincial tax rates
	public static final double RATE2 = 0.0915;
	public static final double RATE3 = 0.116;
	public static final double RATE4 = 0.1216;
	public static final double RATE5 = 0.1316;

	public static final double T1 = 45142; // Provincial tax brackets
	public static final double T2 = 90287;
	public static final double T3 = 150000;
	public static final double T4 = 220000;

	public static final double fRATE1 = 0.15; // Federal tax rates
	public static final double fRATE2 = 0.205;
	public static final double fRATE3 = 0.26;
	public static final double fRATE4 = 0.29;
	public static final double fRATE5 = 0.33;
	
	public static int counter = 0;

	public static boolean BR1 = false;
	public static boolean BR2 = false;
	public static boolean BR3 = false;
	public static boolean BR4 = false;
	public static boolean BR5 = false;

	public static boolean fBR1 = false;
	public static boolean fBR2 = false;
	public static boolean fBR3 = false;
	public static boolean fBR4 = false;
	public static boolean fBR5 = false;

	public static final double fT1 = 49020; // Federal tax brackets
	public static final double fT2 = 98040;
	public static final double fT3 = 151978;
	public static final double fT4 = 216511;

	static String Province = "Ontario";
	static String Country = "Canada";
	static double income = 0;
	static double tax = 0;
	static double ftax = 0;
	static double TotalTax = 0;
	static double TotalEarnAftTax = 0;
	// public static int
	public static final Color TAX = new Color(158, 182, 222);
	public static final Color DARK_GREY = new Color(102, 102, 102);
	public static final Color NEWBlUE = new Color(201, 222, 242);
	static DecimalFormat money = new DecimalFormat("$###,###,###.##");

	private enum Actions {
		CALCULATE, LOAD
	}
	
	public static void fill(){
		int counter = 0;
		
		while(counter<=100) {
			bar.setValue(counter);
			try {
				Thread.sleep(25);
				label1.setVisible(true);
				label2.setVisible(false);
				WelcomeLabel.setVisible(false);
				Divider1Label.setVisible(false);
				EnterLabel.setVisible(false);
				FNameLabel.setVisible(false);
				FNameText.setVisible(false);
				LNameLabel.setVisible(false);
				LNameText.setVisible(false);
				SinLabel.setVisible(false);
				SinText1.setVisible(false);
				SinText2.setVisible(false);
				SinText3.setVisible(false);
				CityLabel.setVisible(false);
				jComboBox.setVisible(false);
				ProvinceLabel.setVisible(false);
				IncomeLabel.setVisible(false);
				IncomeText.setVisible(false);
				Calculate.setVisible(false);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter +=1;
		}
		label1.setVisible(false);
		label2.setVisible(true);
		bar.setVisible(false);
		WelcomeLabel.setVisible(true);
		Divider1Label.setVisible(true);
		EnterLabel.setVisible(true);
		FNameLabel.setVisible(true);
		FNameText.setVisible(true);
		LNameLabel.setVisible(true);
		LNameText.setVisible(true);
		SinLabel.setVisible(true);
		SinText1.setVisible(true);
		SinText2.setVisible(true);
		SinText3.setVisible(true);
		CityLabel.setVisible(true);
		jComboBox.setVisible(true);
		ProvinceLabel.setVisible(true);
		IncomeLabel.setVisible(true);
		IncomeText.setVisible(true);
		Calculate.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		TaxFinal instance = new TaxFinal();
		String[] optionsToChoose = { "Barrie", "Belleville", "Cambridge", "Guelph", "Hamilton", "Kingston", "Kitchener",
				"London", "Markham", "Orillia", "Oshawa", "Ottawa", "Peterborough", "Pickering", "Richmond Hill",
				"Thunder Bay", "Timmins", "Toronto", "Vaughan", "Waterloo", "Welland", "Windsor" };

		panel = new JPanel();
		
		bar.setValue(0);
		bar.setBounds(50,240,500,50);
		bar.setStringPainted(true);
		panel.add(bar);
		
		panel.setBackground(TAX);
		panel.setLayout(null);;
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setBackground(DARK_GREY);
		
		
		WelcomeLabel = new JLabel("Welcome to Fast Tax!");
		WelcomeLabel.setBounds(10, 10, 600, 25);
		panel.add(WelcomeLabel);
		WelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		// label.setVerticalAlignment(JLabel.CENTER); For HOrrixzontal
		
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("FastTax.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(500, 200, 100);
		Image eimg = img.getScaledInstance(100,40,100);
		
		ImageIcon image1 = new ImageIcon(dimg);
		ImageIcon image2 = new ImageIcon(eimg);
		
		label1 = new JLabel(image1);
		label1.setBounds(50,30,500,200);
		panel.add(label1);
		
		label2 = new JLabel(image2);
		label2.setBounds(490,10,100,40);
		panel.add(label2);
		
		Divider1Label = new JLabel("____________________");
		Divider1Label.setBounds(10, 20, 600, 25);
		panel.add(Divider1Label);
		Divider1Label.setHorizontalAlignment(JLabel.CENTER);

		EnterLabel = new JLabel("Please Enter Your Information Below");
		EnterLabel.setBounds(10, 40, 250, 25);
		panel.add(EnterLabel);

		FNameLabel = new JLabel("First Name:");
		FNameLabel.setBounds(30, 65, 80, 25);
		panel.add(FNameLabel);

		FNameText = new JTextField(20);
		FNameText.setBounds(115, 65, 100, 25);
		panel.add(FNameText);

		LNameLabel = new JLabel("Last Name:");
		LNameLabel.setBounds(275, 65, 80, 25);
		panel.add(LNameLabel);

		LNameText = new JTextField(20);
		LNameText.setBounds(360, 65, 100, 25);
		panel.add(LNameText);

		SinLabel = new JLabel("9-Digit Social Insurance Number:");
		SinLabel.setBounds(30, 110, 350, 25);
		panel.add(SinLabel);

		SinText1 = new JTextField(20);
		SinText1.setBounds(260, 110, 40, 25);
		panel.add(SinText1);

		SinText2 = new JTextField(20);
		SinText2.setBounds(300, 110, 40, 25);
		panel.add(SinText2);

		SinText3 = new JTextField(20);
		SinText3.setBounds(340, 110, 40, 25);
		panel.add(SinText3);

		CityLabel = new JLabel("City:");
		CityLabel.setBounds(30, 160, 150, 25);
		panel.add(CityLabel);

		jComboBox = new JComboBox<>(optionsToChoose);
		jComboBox.setBounds(70, 165, 150, 20);
		panel.add(jComboBox);

		ProvinceLabel = new JLabel("Ontario, Canada");
		ProvinceLabel.setBounds(270, 160, 150, 25);
		panel.add(ProvinceLabel);

		IncomeLabel = new JLabel("Enter your Income:");
		IncomeLabel.setBounds(30, 210, 120, 25);
		panel.add(IncomeLabel);

		IncomeText = new JTextField(20);
		IncomeText.setBounds(160, 210, 100, 25);
		panel.add(IncomeText);

		Calculate = new JButton("Calculate");
		Calculate.setBounds(10, 300, 585, 25);
		Calculate.setActionCommand(Actions.CALCULATE.name());
		Calculate.addActionListener(instance);
		panel.add(Calculate);

		frame.setVisible(true);
		frame.setTitle("Fast Tax, The Fastest Tax Thing!");

		String Income = IncomeText.getText();
		
		if (panel.isVisible()) {
			fill();
		}
	}


	public static void DataCollection() {
		YrEarnings = IncomeText.getText();
		int income = Integer.parseInt(YrEarnings);

		if (income <= 0) {
			System.out.println("Income cannot be less than or equal to 0, try again");
			main(null);

		} else {

			TaxMath(null);
		}

	}

	public static void TaxMath(String[] args) {
		YrEarnings = IncomeText.getText();
		int income = Integer.parseInt(YrEarnings);

		if (Province == "Ontario") { // PROVINCIAL TAX
										// ---------------------------------------------------------------------------
			if (income <= T1) { // Bracket 1 between 1 and 45142
				tax = RATE1 * income;
				BR1 = true;
			} else if (income <= T2) { // Bracket 2 between 45142 and 90287
				tax = RATE1 * T1 + RATE2 * (income - T1);
				BR1 = true;
				BR2 = true;
			} else if (income <= T3) { // Bracket 3 between 90287 and 150000
				tax = RATE1 * T1 + RATE2 * (income - T1) + RATE3 * (income - T2);
				BR1 = true;
				BR2 = true;
				BR3 = true;
			} else if (income <= T4) {// Bracket 4 between 150000 and 200000
				tax = RATE1 * T1 + RATE2 * (income - T1) + RATE3 * (income - T2) + RATE4 * (income - T3);
				BR1 = true;
				BR2 = true;
				BR3 = true;
				BR4 = true;

			} else { // Bracket 5 above 200000
				tax = RATE1 * T1 + RATE2 * (income - T1) + RATE3 * (income - T2) + RATE4 * (income - T3)
						+ RATE5 * (income - T4);
				BR1 = true;
				BR2 = true;
				BR3 = true;
				BR4 = true;
				BR5 = true;
			}
		}
		System.out.println("Provincial tax: " + money.format(tax));

		if (Country == "Canada") { // FEDERAL TAX
			// ---------------------------------------------------------------------------------------------
			if (income <= fT1) { // Bracket 1 between 1 and 45142
				ftax = fRATE1 * income;
				fBR1 = true;
			} else if (income <= fT2) { // Bracket 2 between 45142 and 90287
				ftax = fRATE1 * fT1 + fRATE2 * (income - fT1);
				fBR1 = true;
				fBR2 = true;
			} else if (income <= fT3) { // Bracket 3 between 90287 and 150000
				ftax = fRATE1 * fT1 + fRATE2 * (income - fT1) + fRATE3 * (income - fT2);
				fBR1 = true;
				fBR2 = true;
				fBR3 = true;
			} else if (income <= fT4) { // Bracket 4 between 150000 and 200000
				ftax = fRATE1 * fT1 + fRATE2 * (income - fT1) + fRATE3 * (income - fT2) + fRATE4 * (income - fT3);
				fBR1 = true;
				fBR2 = true;
				fBR3 = true;
				fBR4 = true;

			} else { // Bracket 5 above 200000
				ftax = fRATE1 * fT1 + fRATE2 * (income - fT1) + fRATE3 * (income - fT2) + fRATE4 * (income - fT3) + RATE5 * (income - fT4);
				fBR1 = true;
				fBR2 = true;
				fBR3 = true;
				fBR4 = true;
				fBR5 = true;
			}
		}
		System.out.println("Federal tax: " + money.format(ftax));
	}

	public void calculate() {
		panel = new JPanel();
		panel.setBackground(NEWBlUE);
		panel.setLayout(null);

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setBackground(DARK_GREY);
		
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("FastTax.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image eimg = img.getScaledInstance(100,40,100);
		
		ImageIcon image2 = new ImageIcon(eimg);
		
		label2 = new JLabel(image2);
		label2.setBounds(490,10,100,40);
		panel.add(label2);
		
		RevenueCanadaLabel = new JLabel("Revenue Canada");
		RevenueCanadaLabel.setBounds(10, 10, 600, 25);
		panel.add(RevenueCanadaLabel);
		RevenueCanadaLabel.setHorizontalAlignment(JLabel.CENTER);

		IncomeTax2021 = new JLabel("Income Tax for 2021");
		IncomeTax2021.setBounds(10, 30, 600, 25);
		panel.add(IncomeTax2021);
		IncomeTax2021.setHorizontalAlignment(JLabel.CENTER);

		InfoEarn = new JLabel("Information of earnings for:");
		InfoEarn.setBounds(10, 50, 600, 25);
		panel.add(InfoEarn);

		String FName = FNameText.getText();
		String LName = LNameText.getText();
		NameVar = new JLabel("Name: " + FName + " " + LName);
		NameVar.setBounds(60, 85, 600, 25);
		panel.add(NameVar);

		String SIN1 = SinText1.getText();
		String SIN2 = SinText2.getText();
		String SIN3 = SinText3.getText();

		SinVar = new JLabel("SIN#: " + SIN1 + "-" + SIN2 + "-" + SIN3);
		SinVar.setBounds(60, 105, 600, 25);
		panel.add(SinVar);

		String City = (String) jComboBox.getSelectedItem();
		ResidenceVar = new JLabel("Residence: " + City + ", " + Province);
		ResidenceVar.setBounds(60, 125, 600, 25);
		panel.add(ResidenceVar);

		int income = Integer.parseInt(YrEarnings);
		YrEarnings = IncomeText.getText();
		YrEarn = new JLabel("Year earnings: " + money.format(income));
		YrEarn.setBounds(60, 175, 600, 25);
		panel.add(YrEarn);

		// Here on calculations are neccessary.
		FedTax = new JLabel("Federal Tax: " + money.format(ftax));
		FedTax.setBounds(60, 205, 600, 25);
		panel.add(FedTax);

		ProvTax = new JLabel("Provincial Tax: " + money.format(tax));
		ProvTax.setBounds(60, 225, 600, 25);
		panel.add(ProvTax);

		double TotalTax = tax + ftax;
		TotTax = new JLabel("Total Tax: " + money.format(TotalTax));
		TotTax.setBounds(60, 265, 600, 25);
		panel.add(TotTax);

		double TotalEarnAftTax = income - TotalTax;
		EarnaftTax = new JLabel("Earnings after Tax: " + money.format(TotalEarnAftTax));
		EarnaftTax.setBounds(60, 305, 600, 25);
		panel.add(EarnaftTax);
		// End of neccessary calculations.
		
		frame.setVisible(true);
		frame.setTitle("Fast Tax, The Fastest Tax Thing!");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == Actions.CALCULATE.name()) {
			frame.setVisible(false);
			DataCollection();
			System.out.println("Tax Calculated");
			calculate();
			
			

		} else if (e.getActionCommand() == Actions.LOAD.name()) {
			// loadData();
			// System.out.println("Progress loaded");
		}

	}
}
