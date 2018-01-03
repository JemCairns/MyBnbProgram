
public class Truck extends Vehicle {

	int cargoWeight;
	
	
	public Truck(String ownerName, int rentalCostPerDay, int totalRentalDays, int cargoWeight) {
		super(ownerName, rentalCostPerDay, totalRentalDays);
		this.cargoWeight = cargoWeight;
	}
	
	
	
	public int getCargoWeight() {
		return cargoWeight;
	}
	
}
