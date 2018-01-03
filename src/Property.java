import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Property implements RentItem {

	static int counter = 100; //static so that it can be used in functions below as the number of properties+1
	int totalIncome, registerNumber, rentalCostPerDay, totalRentalDays;
	String ownerName, postalAddress;
	static int[][] regNumTypes = new int[50][2]; //used to know property type and order of properties
	static int pCounter=0, aCounter=0, hCounter=0, vCounter=0; //used for regNumTypes
	
	//mutators
	public Property (String ownerName, String postalAddress, int rentalCostPerDay, int totalRentalDays) {
		this.registerNumber = counter++;
        this.ownerName = ownerName;
        this.postalAddress = postalAddress;
		this.rentalCostPerDay = rentalCostPerDay;
        this.totalRentalDays = totalRentalDays;
	}
	
	
	//accessors
	public int getRegisterNumber(){
		return registerNumber;
	}
	
	public int getRentalCostPerDay(){
		return rentalCostPerDay;
	}
	
	public int getTotalRentalDays(){
		return totalRentalDays;
	}
	
	public String getOwner(){
		return ownerName;
	}
	
	public String getPostalAddress(){
		return postalAddress;
	}
	
	

	//implement RentItem interface
	@Override
	public int RentalItem(int rentalDays) {
		totalRentalDays += rentalDays;
		return totalRentalDays;
	}

	
	
	
	
	public static void ReadInputPropertyFile(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas) {
		
		//declaring all variables that will be used, including String and int variables for JOptionPane and parseInt
		String myInputFileName = "Files/InputProperty.txt";
		String SpropertyType, SrentalCostPerDay, StotalRentalDays;
		int propertyType, rentalCostPerDay, totalRentalDays;
		String SstoreyNumber, SnoOfBeds, SnoOfStoreys, SclearingFees, SnoOfRooms, SroomServiceCostPerDay, SluxuryTaxPerDay;
		int storeyNumber, noOfBeds, noOfStoreys, clearingFees, noOfRooms, roomServiceCostPerDay, luxuryTaxPerDay;
		String ownerName, postalAddress;
		
		try {
			FileReader myInputFile = new FileReader(myInputFileName);
			Scanner myScanner = new Scanner(myInputFile);
			
			//begin reading in values from inputProperty.txt
			while(myScanner.hasNext()) {
				SpropertyType = myScanner.next();
				propertyType = Integer.parseInt(SpropertyType);
				ownerName = myScanner.next();
				postalAddress = myScanner.next();
				SrentalCostPerDay = myScanner.next();
				rentalCostPerDay = Integer.parseInt(SrentalCostPerDay);
				StotalRentalDays = myScanner.next();
				totalRentalDays = Integer.parseInt(StotalRentalDays);
				//above are the same regardless of vehicle type, below are specific to each type

				if(propertyType == 1) {
					SstoreyNumber = myScanner.next();
					storeyNumber = Integer.parseInt(SstoreyNumber);
					SnoOfBeds = myScanner.next();
					noOfBeds = Integer.parseInt(SnoOfBeds);
					
					apartments.add(new Apartment(ownerName, postalAddress, rentalCostPerDay, totalRentalDays, 
							storeyNumber, noOfBeds));
					
					regNumTypes[pCounter][0] = propertyType; //used to denote property type
					regNumTypes[pCounter][1] = aCounter; //used to denote which number of each type the variable is
					pCounter++;
					aCounter++;
				}
				else if(propertyType == 2) {
					SnoOfStoreys = myScanner.next();
					noOfStoreys = Integer.parseInt(SnoOfStoreys);
					SclearingFees = myScanner.next();
					clearingFees = Integer.parseInt(SclearingFees);
					
					houses.add(new House(ownerName, postalAddress, rentalCostPerDay, totalRentalDays, 
							noOfStoreys, clearingFees));
					
					regNumTypes[pCounter][0] = propertyType;
					regNumTypes[pCounter][1] = hCounter;
					pCounter++;
					hCounter++;
				}
				else if(propertyType == 3) {
					SnoOfRooms = myScanner.next();
					noOfRooms = Integer.parseInt(SnoOfRooms);
					SroomServiceCostPerDay = myScanner.next();
					roomServiceCostPerDay = Integer.parseInt(SroomServiceCostPerDay);
					SluxuryTaxPerDay = myScanner.next();
					luxuryTaxPerDay = Integer.parseInt(SluxuryTaxPerDay);
					
					villas.add(new Villa(ownerName, postalAddress, rentalCostPerDay, totalRentalDays, 
							noOfRooms, roomServiceCostPerDay, luxuryTaxPerDay));
					
					regNumTypes[pCounter][0] = propertyType;
					regNumTypes[pCounter][1] = vCounter;
					pCounter++;
					vCounter++;
				}
				else {
					System.out.println("input error!!!!!!!!!!");
				}

			}
			myScanner.close();
		}
		//catch exceptions
		catch (Exception ex) {//if an exception is thrown when we attempt to access the file the following code is executed
            JOptionPane.showMessageDialog(null, " There was a problem with that file:\n exception " + ex.getMessage() + " 111111111");
		}
		
		
	}

	
	
	public static void PrintAllProperties(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas) {
		
		//print property information to outputProperty
		String myOutputFileName = "Files/OutputProperty.txt";
		
		try {
			int i;
			String textAreaOutput="", apartmentOutput="", houseOutput="", villaOutput="";
			
			textAreaOutput += "MyBnb\n\nProperty\n";
			
			//use accessor methods to retrieve information to be printed
			for(i=0; i<apartments.size(); i++) {
				apartmentOutput += String.format("Register number: " + apartments.get(i).getRegisterNumber() + ",\tOwner: " + apartments.get(i).getOwner() 
						+ ",\tPostal address: " + apartments.get(i).getPostalAddress() + ",\tTotal Rental days: " + apartments.get(i).getTotalRentalDays()
						+ ",\tRent per day: €" + apartments.get(i).getRentalCostPerDay() + ",\tStorey number: " + apartments.get(i).getStoreyNumber()
						+ ",\tNumber of beds: " + apartments.get(i).getNoOfBeds() + ".\n");
			}
			textAreaOutput += "\n\nApartments:\n" + apartmentOutput;
			
			for(i=0; i<houses.size(); i++) {
				houseOutput += String.format("Register number:  " + houses.get(i).getRegisterNumber() + ",\tOwner:  " + houses.get(i).getOwner()
						+ ",\tPostal address:  " + houses.get(i).getPostalAddress() + ",\tTotal Rental Days:  " + houses.get(i).getTotalRentalDays()
						+ ",\tRent per day:  €" + houses.get(i).getRentalCostPerDay() + ",\tNo. of storeys:  " + houses.get(i).getNoOfStoreys()
						+ ",\tClearing fees:  €" + houses.get(i).getClearingFees() + ".\n");
			}
			textAreaOutput += "\nHouses:\n" + houseOutput;

			for(i=0; i<villas.size(); i++) {
				villaOutput += String.format("Register number: " + villas.get(i).getRegisterNumber() + ",\tOwner: " + villas.get(i).getOwner()
						+ ",\tPostal Address: " + villas.get(i).getPostalAddress() + ",\tTotal Rental Days: " + villas.get(i).getTotalRentalDays()
						+ ",\tRent per day: €" + villas.get(i).getRentalCostPerDay() + ",\tNo. of rooms: " + villas.get(i).getNoOfRooms()
						+ ",\tRoom service cost per day: €" + villas.get(i).getRoomServiceCostPerDay() + ",\tLuxury tax per day: €" + villas.get(i).getLuxuryTaxPerDay() + ".\n");
			}
			textAreaOutput += "\nVillas:\n" + villaOutput;

			//add all information to a JTextArea and then add it to outputVehicle.txt
			PrintWriter myOutputFile = new PrintWriter(myOutputFileName);
			myOutputFile.print(textAreaOutput);
			
			
			myOutputFile.close();
		}
		catch(Exception ex) {
            JOptionPane.showMessageDialog(null, " There was a problem with the output file:\n exception: " + ex.getMessage() + " 333333333");
		}
	}


	
	public static void GiveRentalProperty(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas) {
	
		String Stimes = JOptionPane.showInputDialog(null, "How many times would you like to rent out a property?");
		int times = Integer.parseInt(Stimes);
		
		for(int i=0; i<times; i++) {
			
			//add JFrame and JPanel
			JFrame myJFrame = new JFrame("MyBnb");
			myJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			myJFrame.setSize(600, 100);
			
			JPanel panel = new JPanel();
			
			//fill in JPanel with labels and textfields
	        JLabel label1 = new JLabel("Register Number:");
	        panel.add(label1);
	        
	        JTextField textField1 = new JTextField(4);
	        panel.add(textField1);
	        
	        JLabel label2 = new JLabel("Rental Days:");
	        panel.add(label2);
	        
	        JTextField textField2 = new JTextField(4);
	        panel.add(textField2);
	        
	        //display OK and CANCEL buttons
	        int k = i+1;
	        JOptionPane.showConfirmDialog(null, panel, "Fill in properties " + k + " of " + times, JOptionPane.OK_CANCEL_OPTION);
	        
	        
	        myJFrame.getContentPane().add(panel);
			
	        myJFrame.setVisible(false); //only show JPanel
	        
	        String SregNum = textField1.getText();
	        String SnoDays = textField2.getText();
	        //make sure all info is inputted and is done so correctly
	        if(SregNum.equals("")){
	        	JOptionPane.showMessageDialog(null, "Error: Please fill in 'Register Number' field.");
	        	i--;
	        }
	        else if(SnoDays.equals("")) {
	        	JOptionPane.showMessageDialog(null, "Error: Please fill in 'Rental Days' field.");
	        	i--;
	        }
	        else {
	        	int regNum = Integer.parseInt(SregNum);
		        int noDays = Integer.parseInt(SnoDays);
		        
		        
		        if(regNum<100 || regNum>=counter) {
		        	JOptionPane.showMessageDialog(null, regNum +  " is an invalid register number."
		        			+ " Register numbers must be between 100 and " + counter);
		        	i--;
		        }
		        else if(noDays<1){
		        	JOptionPane.showMessageDialog(null, "Error: Invalid number of days.");
		        	i--;
		        }
		        //check what type of property it is by the regNum-100 (each register number is 100 more than the array positions
		        else if(regNumTypes[regNum-100][0] == 1) {
		        	apartments.get(regNumTypes[regNum-100][1]).RentalItem(noDays); //rent item using regNumTypes to find out which number each vehicle is
		        }
		        else if(regNumTypes[regNum-100][0] == 2) {
		        	houses.get(regNumTypes[regNum-100][1]).RentalItem(noDays);
		        }
		        else if(regNumTypes[regNum-100][0] == 3) {
		        	villas.get(regNumTypes[regNum-100][1]).RentalItem(noDays);
		        }
		        else {
		        	JOptionPane.showMessageDialog(null, "Error in code!");
		        }
	        }   
		}
	}
	
	
	public static int CalculateTotalPropertyIncome(ArrayList<Apartment> apartments, ArrayList<House> houses, ArrayList<Villa> villas) {
		
		int totalIncome=0, i;
		
		//implement income formualas
		for(i=0; i<apartments.size(); i++) {
			totalIncome += (apartments.get(i).getTotalRentalDays() * apartments.get(i).getRentalCostPerDay());
		}

		for(i=0; i<houses.size(); i++) {
			totalIncome += (houses.get(i).getTotalRentalDays() * (houses.get(i).getRentalCostPerDay() + houses.get(i).getClearingFees()));
		}
		
		for(i=0; i<villas.size(); i++) {
			totalIncome += (villas.get(i).getTotalRentalDays() * (villas.get(i).getRoomServiceCostPerDay() 
					+ villas.get(i).getLuxuryTaxPerDay() + villas.get(i).getRentalCostPerDay()));
		}

		return totalIncome;
	}
}
	
	

	

