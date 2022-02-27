package com.LucasWall.TAXman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import javax.swing.*;



public class TAXman implements ActionListener{
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel WelcomeLabel;
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
	
	private static JLabel ProvinceLabel;
	private static JLabel CityLabel;
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
	public static String Province = "";
	public static String City = "";
	public static String YrEarnings = "";
	public static JComboBox<String> jComboBox;
	//public static int 
	public static final Color TAX = new Color(158, 182, 222);
	public static final Color DARK_GREY = new Color(102,102,102);
	public static final Color NEWBlUE = new Color(201, 222, 242);
	
	private enum Actions {
		CALCULATE,
		LOAD
	}
	
	public static void main(String[] args)
	{
		TAXman instance = new TAXman();
		String[] optionsToChoose = {"Alberta", "British Colombia", "Manitoba", "NewBrunswick","Newfoundland and Labrador", "Nova Scotia", "Ontario","Prince Edward Island","Quebec","Saskatchewan",};
        
		panel = new JPanel();
		panel.setBackground(TAX);
		panel.setLayout(null);
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.setBackground(DARK_GREY);
		
		
		WelcomeLabel = new JLabel("Welcome to Fast Tax!");
		WelcomeLabel.setBounds(10,10,600,25);
		panel.add(WelcomeLabel);
	    WelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
	    //label.setVerticalAlignment(JLabel.CENTER); For HOrrixzontal


		Divider1Label = new JLabel("____________________");
		Divider1Label.setBounds(10,20,600,25);
		panel.add(Divider1Label);
		Divider1Label.setHorizontalAlignment(JLabel.CENTER);
		
		EnterLabel = new JLabel("Please Enter Your Information Below");
		EnterLabel.setBounds(10,40,250,25);
		panel.add(EnterLabel);
		
		FNameLabel = new JLabel("First Name:");
		FNameLabel.setBounds(30,65,80,25);
		panel.add(FNameLabel);
		
		FNameText = new JTextField(20);
		FNameText.setBounds(115,65,100,25);
		panel.add(FNameText);
		
		LNameLabel = new JLabel("Last Name:");
		LNameLabel.setBounds(275,65,80,25);
		panel.add(LNameLabel);
		
		LNameText = new JTextField(20);
		LNameText.setBounds(360,65,100,25);
		panel.add(LNameText);
	
		SinLabel = new JLabel("9-Digit Social Insurance Number:");
		SinLabel.setBounds(30,110,350,25);
		panel.add(SinLabel);
		
		SinText1 = new JTextField(20);
		SinText1.setBounds(260,110,40,25);
		panel.add(SinText1);
		
		SinText2 = new JTextField(20);
		SinText2.setBounds(300,110,40,25);
		panel.add(SinText2);
		
		SinText3 = new JTextField(20);
		SinText3.setBounds(340,110,40,25);
		panel.add(SinText3);
		
		ProvinceLabel = new JLabel("Province:");
		ProvinceLabel.setBounds(30,160,150,25);
		panel.add(ProvinceLabel);
		
		jComboBox = new JComboBox<>(optionsToChoose);
		jComboBox.setBounds(100, 165, 200, 20);
		panel.add(jComboBox);
		
		CityLabel = new JLabel("City:");
		CityLabel.setBounds(340,160,150,25);
		panel.add(CityLabel);
		
		CityText = new JTextField(20);
		CityText.setBounds(380,160,150,25);
		panel.add(CityText);
		
		
		IncomeLabel = new JLabel("Enter your Income:");
		IncomeLabel.setBounds(30,210,120,25);
		panel.add(IncomeLabel);
		
		IncomeText = new JTextField(20);
		IncomeText.setBounds(160,210,100,25);
		panel.add(IncomeText);
		
		Calculate = new JButton("Calculate");
		Calculate.setBounds(10, 300, 585, 25);
		Calculate.setActionCommand(Actions.CALCULATE.name());
		Calculate.addActionListener(instance);
		panel.add(Calculate);
		
		frame.setVisible(true);
		frame.setTitle("Fast Tax, The Fastest Tax Thing!");
		
		String Income = IncomeText.getText();
	}


	/*public void loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("saveFile.txt"));
			
			save = br.readLine();
			br.close();
		}
		catch(Exception e) {
			
		}
		
		IncomeText.setText(save);
	}
	public void saveData() {
     //if (!saveText.equals(null)) {
  	//   save = "Hi";
    //}
		try { 

          FileWriter fileWriter = new FileWriter("saveFile.txt");
          BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

          bufferedWriter.write(save);

          bufferedWriter.close();
      }
      catch(IOException ex) {
          System.out.println("Error writing to file '");
      }
	}
	*/
	
	public void calculate() {
		panel = new JPanel();
		panel.setBackground(NEWBlUE);
		panel.setLayout(null);
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.setBackground(DARK_GREY);
		
		RevenueCanadaLabel = new JLabel("Revenue Canada");
		RevenueCanadaLabel.setBounds(10,10,600,25);
		panel.add(RevenueCanadaLabel);
	    RevenueCanadaLabel.setHorizontalAlignment(JLabel.CENTER);
	    
	    IncomeTax2021 = new JLabel("Income Tax for 2021");
	    IncomeTax2021.setBounds(10,30,600,25);
		panel.add(IncomeTax2021);
		IncomeTax2021.setHorizontalAlignment(JLabel.CENTER);
		
		InfoEarn = new JLabel("Information of earnings for:");
		InfoEarn.setBounds(10,50,600,25);
	    panel.add(InfoEarn);
	    
	    
	    String FName = FNameText.getText();
	    String LName = LNameText.getText();
	    NameVar = new JLabel("Name: " + FName + " " + LName);
	    NameVar.setBounds(60,85,600,25);
	    panel.add(NameVar);
	    
	    String SIN1 = SinText1.getText();
	    String SIN2 = SinText2.getText();
	    String SIN3 = SinText3.getText();

	    SinVar = new JLabel("SIN#: " + SIN1 + "-" + SIN2 + "-" +SIN3);
	    SinVar.setBounds(60,105,600,25);
	    panel.add(SinVar);
	    
	    String Province = (String) jComboBox.getSelectedItem();
	    String City = CityText.getText();
	    ResidenceVar = new JLabel("Residence: " + City + ", "+ Province);
	    ResidenceVar.setBounds(60,125,600,25);
	    panel.add(ResidenceVar);
	   
	    
	    YrEarnings = IncomeText.getText();
	    YrEarn = new JLabel("Year earnings: " + YrEarnings);
	    YrEarn.setBounds(60,175,600,25);
	    panel.add(YrEarn);

	    //Here on calculations are neccessary.
	    FedTax = new JLabel("Federal Tax:");
	    FedTax.setBounds(60,205,600,25);
	    panel.add(FedTax);
	    
	    ProvTax = new JLabel("Provincial Tax:");
	    ProvTax.setBounds(60,225,600,25);
	    panel.add(ProvTax);
	    
	    TotTax = new JLabel("Total Tax:");
	    TotTax.setBounds(60,265,600,25);
	    panel.add(TotTax);
	    
	    EarnaftTax = new JLabel("Earnings after Tax:");
	    EarnaftTax.setBounds(60,305,600,25);
	    panel.add(EarnaftTax);
	    //End of neccessary calculations.
	    
	    
		frame.setVisible(true);
		frame.setTitle("Fast Tax, The Fastest Tax Thing!");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == Actions.CALCULATE.name()) {
			frame.setVisible(false);
			calculate();
			System.out.println("Tax Calculated");

		}
		else if(e.getActionCommand() == Actions.LOAD.name()){
			//loadData();
			//System.out.println("Progress loaded");
		}
		
	}
}
