package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;

public class Store {
	int storeId;
	VehicleInventoryManagement inventoryManagement;
	Location storeLocation; 
	List<Reservation> reservations = new ArrayList<> ();
	
	public List<Vehicle> getVehicles(VehicleType vehicleType){
		return inventoryManagement.getVehicles(); 
	}
	
	//add Vehicles,  //update Vehicles //use inventory management to update those 
	
	public void setVehicles(List<Vehicle> vehicles) {
		inventoryManagement = new VehicleInventoryManagement(vehicles);
	}
	
	public Reservation createReservation(Vehicle vehicle,User user) {
		Reservation reservation = new Reservation(); 
		reservation.createReserve(user,vehicle);
		reservations.add(reservation); 
		return reservation; 
	}
	
	public boolean completeReservation(int reservationId) {
		//take out the reservation from the list and call complete reservation method
		return true; 
	}
	
	//update reservation 
}
