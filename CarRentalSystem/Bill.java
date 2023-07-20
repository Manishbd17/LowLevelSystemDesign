package CarRentalSystem;

public class Bill {
	Reservation reservation;
	Double totalBillAmount;
	Boolean isBillPaid;
	
	public Bill(Reservation reservation){
		this.reservation = reservation;
		totalBillAmount = computeBillAmount();
		isBillPaid = false;
	}
	
	private double computeBillAmount() {
		return 100.0; 
	}
}
