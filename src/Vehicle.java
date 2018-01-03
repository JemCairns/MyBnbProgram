import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Vehicle implements RentItem {

	static int counter=201; //static so that it can be used in functions below as the number of properties+1
	String ownerName;
	int registerNumber, totalRentalDays, rentalCostPerDay;
	
	//mutators
	public Vehicle(String ownerName, int rentalCostPerDay, int totalRentalDays) {
		this.registerNumber = counter++;
		this.ownerName = ownerName;
		this.rentalCostPerDay = rentalCostPerDay;
		this.totalRentalDays = totalRentalDays;
	}
	
	//accessors
	public int getRegisterNumber() {
		return registerNumber;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public int getTotalRentalDays() {
		return totalRentalDays;
	}
	
	public int getRentalCostPerDay() {
		return rentalCostPerDay;
	}
	
	


	//implement RentItme interface 
	@Override
	public int RentalItem(int rentalDays) {
		totalRentalDays += rentalDays-1; //-1 complementary day
		return totalRentalDays;
	}
	
	
	
	
	
	
	
	public static void ReadInputVehicleFile(ArrayList<Car> cars, ArrayList<Truck> trucks) {
		
		//declaring all variables that will be used, including String and int variables for JOptionPane and parseInt
		String myInputFileName = "Files/InputVehicle.txt";
		String SvehicleType, SrentalCostPerDay, StotalRentalDays;
		int vehicleType, rentalCostPerDay, totalRentalDays;
		String SnoOfPassengers, ScargoWeight;
		int noOfPassengers, cargoWeight;
		String ownerName;
		
		try {
			FileReader myInputFile = new FileReader(myInputFileName);
			Scanner myScanner = new Scanner(myInputFile);
			
			//begin reading in values from inputVehicle.txt
			while(myScanner.hasNext()) {
				SvehicleType = myScanner.next();
				vehicleType = Integer.parseInt(SvehicleType);
				ownerName = myScanner.next();
				SrentalCostPerDay = myScanner.next();
				rentalCostPerDay = Integer.parseInt(SrentalCostPerDay);
				StotalRentalDays = myScanner.next();
				totalRentalDays = Integer.parseInt(StotalRentalDays);
				
				//above are the same regardless of vehicle type, below are specific to each type
				if(vehicleType == 1) {
					SnoOfPassengers = myScanner.next();
					noOfPassengers = Integer.parseInt(SnoOfPassengers);
					
					cars.add(new Car(ownerName, rentalCostPerDay, totalRentalDays, noOfPassengers));
				}
				else if(vehicleType == 2) {
					ScargoWeight = myScanner.next();
					cargoWeight = Integer.parseInt(ScargoWeight);
					
					trucks.add(new Truck(ownerName, rentalCostPerDay, totalRentalDays, cargoWeight));
				}
				else {
					System.out.println("input error!!!!!!!!!!");
				}
			
			}
			myScanner.close();
		}
		//catch exceptions
		catch (Exception ex) {//if an exception is thrown when we attempt to access the file the following code is executed
            JOptionPane.showMessageDialog(null, " There was a problem with that file:\n exception " + ex.getMessage() + " 22222222");
		}
		
	}
	
	
	
	public static void FillInVehicles(ArrayList<Car> cars, ArrayList<Truck> trucks) {
		//rent out the cars and trucks
		
		cars.get(0).RentalItem(14);
	    cars.get(0).RentalItem(10); 
	    cars.get(1).RentalItem(5); 
	    cars.get(1).RentalItem(11); 
	    cars.get(2).RentalItem(12); 
	    cars.get(2).RentalItem(3);
	    
	    trucks.get(0).RentalItem(3);
	    trucks.get(0).RentalItem(4);
	    trucks.get(1).RentalItem(5);
	    trucks.get(1).RentalItem(9);
	    trucks.get(2).RentalItem(12);
	    trucks.get(2).RentalItem(14);
	}
	
	
	
	public static void PrintAllVehicles(ArrayList<Car> cars, ArrayList<Truck> trucks) {

		//print vehicle information to outputVehicle
		String myOutputFileName2 = "Files/OutputVehicle.txt";
		
		try {
			int i;
			String textAreaOutput2="", carOutput="", truckOutput="";
			
			textAreaOutput2 += "MyBnb\n\nVehicles\n";
			
			//use accessor methods to retrieve information to be printed
			for(i=0; i<cars.size(); i++) {
				carOutput += String.format("Register number: " + cars.get(i).getRegisterNumber()
						+ ",\tOwner: " + cars.get(i).getOwnerName() 
						+ ",\tTotal Rental days: " + cars.get(i).getTotalRentalDays()
						+ ",\tRent per day: " + cars.get(i).getRentalCostPerDay() 
						+ " euro,\tNo. of Passengers: " + cars.get(i).getNoOfPassengers() + ".\n");
			}
			textAreaOutput2 += "\n\nCars:\n" + carOutput;
			
			for(i=0; i<trucks.size(); i++) {
				truckOutput += String.format("Register number:  " + trucks.get(i).getRegisterNumber()
						+ ",\tOwner: " + trucks.get(i).getOwnerName() 
						+ ",\tTotal Rental days: " + trucks.get(i).getTotalRentalDays()
						+ ",\tRent per day: " + trucks.get(i).getRentalCostPerDay() 
						+ " euro,\tNo. of Passengers: " + trucks.get(i).getCargoWeight() + ".\n");
			}
			textAreaOutput2 += "\nTrucks:\n" + truckOutput;

			//add all information to a JTextArea and then add it to outputVehicle.txt
			PrintWriter myOutputFile2 = new PrintWriter(myOutputFileName2);
			myOutputFile2.print(textAreaOutput2);
			
			myOutputFile2.close();
		}
		catch(Exception ex) {
            JOptionPane.showMessageDialog(null, " There was a problem with the output file:\n exception: " + ex.getMessage() + " 444444444");
		}

	}
	
	
	
	public static int CalculateTotalVehicleIncome(ArrayList<Car> cars, ArrayList<Truck> trucks) {
		
		int totalIncome=0, i;
		
		for(i=0; i<cars.size(); i++) {
			totalIncome += cars.get(i).getTotalRentalDays() * cars.get(i).getRentalCostPerDay() * cars.get(i).getNoOfPassengers();
			//fee is multiplied by noOfPassengers
		}
		
		for(i=0; i<trucks.size(); i++) {
			totalIncome += trucks.get(i).getTotalRentalDays() * (trucks.get(i).getRentalCostPerDay() + trucks.get(i).getCargoWeight()/10);
			//cargoWeight divided by 10 (and rounded off as it is an int value) is added to rental cost per day
		}

		return totalIncome;
	}
	
	
	
}
