
public class Car extends Vehicle {

	int noOfPassengers;
	
	
	public Car(String ownerName, int rentalCostPerDay, int totalRentalDays, int noOfPassengers) {
		super(ownerName, rentalCostPerDay, totalRentalDays);
		this.noOfPassengers = noOfPassengers;
	}
	
	
	
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	
	
	
	
}
