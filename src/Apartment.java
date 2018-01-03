
public class Apartment extends Property{

	int storeyNumber, noOfBeds;
	
	public Apartment(String ownerName, String postalAddress, int rentalCostPerDay, int totalRentalDays, int storeyNumber, int noOfBeds) {
		super(ownerName, postalAddress, rentalCostPerDay, totalRentalDays);
		this.storeyNumber = storeyNumber;
		this.noOfBeds = noOfBeds;
	}
	
	
	public int getStoreyNumber(){
		return storeyNumber;
	}
	
	public int getNoOfBeds(){
		return noOfBeds;
	}
	
	
}
