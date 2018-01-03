import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//declare arrayLists
		ArrayList<Apartment> apartments = new ArrayList<Apartment>();
		ArrayList<House> houses = new ArrayList<House>();                        
		ArrayList<Villa> villas = new ArrayList<Villa>();
		
		ArrayList<Car> cars = new ArrayList<Car>();
		ArrayList<Truck> trucks = new ArrayList<Truck>();
		
		//use functions
		Property.ReadInputPropertyFile(apartments, houses, villas);
		Vehicle.ReadInputVehicleFile(cars, trucks);
		
		Vehicle.FillInVehicles(cars, trucks);
		
		Property.PrintAllProperties(apartments, houses, villas);
		Vehicle.PrintAllVehicles(cars, trucks);
		
		Property.GiveRentalProperty(apartments, houses, villas);
		
		int totalIncome = Property.CalculateTotalPropertyIncome(apartments, houses, villas) + Vehicle.CalculateTotalVehicleIncome(cars, trucks);
		JOptionPane.showMessageDialog(null, "\nTotal property income: €" + Property.CalculateTotalPropertyIncome(apartments, houses, villas)
				+ "\nTotal vehicle income: €" + Vehicle.CalculateTotalVehicleIncome(cars, trucks)
				+ "\n Total income: €" + totalIncome);
		
		
		System.exit(0);
    }
	

}
