package CarRentalSystem;

import java.util.Date;

import CarRentalSystem.Product.Vehicle;

public class Reservation {
	int reservationId;
	User user;
	Vehicle vehicle;
	Date bookingDate;
	Date dateBookedFrom;
	Date dateBookedTo; 
	Long fromTimeStamp;
	Long toTimeStamp;
	Location pickupLocation;
	Location dropLocation; 
	ReservationType reservationType;
	ReservationStatus reservationStatus;
	Location location; 
	
	public int createReserve(User user,Vehicle vehicle) {
		reservationId = 12324;
		this.user=user;
		this.vehicle=vehicle; 
		reservationType = reservationType.DAILY;
		reservationStatus = reservationStatus.SCHEDULED;
		
		return reservationId; 
	}
}
