
public class House extends Property{

	int noOfStoreys, clearingFees;
	
	public House(String ownerName, String postalAddress, int rentalCostPerDay, int totalRentalDays, int noOfStoreys, int clearingFees) {
		super(ownerName, postalAddress, rentalCostPerDay, totalRentalDays);
		this.noOfStoreys = noOfStoreys;
		this.clearingFees = clearingFees;
	}
	
	
	public int getNoOfStoreys(){
		return noOfStoreys;
	}
	
	public int getClearingFees(){
		return clearingFees;
	}
	
	
	
}
