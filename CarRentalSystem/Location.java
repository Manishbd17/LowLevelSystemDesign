package CarRentalSystem;

public class Location {
	String address;
	int pinCode;
	String city;
	String state;
	String country; 
	
	Location (int pinCode,String city,String state,String country){
		this.pinCode=pinCode;
		this.city=city;
		this.state=state;
		this.country=country; 
	}
}
