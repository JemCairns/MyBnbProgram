
public class Villa extends Property{

	int noOfRooms, roomServiceCostPerDay, luxuryTaxPerDay;
	
	
	public Villa(String ownerName, String postalAddress, int rentalCostPerDay, int totalRentalDays,
			int noOfRooms, int roomServiceCostPerDay, int luxuryTaxPerDay) {
		super(ownerName, postalAddress, rentalCostPerDay, totalRentalDays);
		this.noOfRooms = noOfRooms;
		this.roomServiceCostPerDay = roomServiceCostPerDay;
		this.luxuryTaxPerDay = luxuryTaxPerDay;
	}
	
	
	public int getNoOfRooms(){
		return noOfRooms;
	}
	
	public int getRoomServiceCostPerDay(){
		return roomServiceCostPerDay;
	}
	
	public int getLuxuryTaxPerDay(){
		return luxuryTaxPerDay;
	}
}
