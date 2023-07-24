package NullObjectDesignPattern;

public class Main {
	public static void main(String args[]) {
		Vehicle vehicle = VehicleFactory.getVehicleObject("Bike"); 
		printVehicleDetails(vehicle); 
	}
	
	private static void printVehicleDetails(Vehicle vehicle) {
		System.out.println("Seating capacity : " + vehicle.getSeatingCapacity());
		System.out.println("Fuel Tank Capacity: "+vehicle.getTankCapacity());
	}
}
