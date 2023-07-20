package CarRentalSystem;

import java.util.List;

public class VehicleRentalSystem {
	List<Store> storeList;
	List<User> userList; 
	
	VehicleRentalSystem(List<Store> storeList,List<User> userList){
		this.storeList = storeList;
		this.userList = userList; 
	}
	
	public Store getStore(Location location) {
		//based on location, we will filter out the Store from storeList
		return storeList.get(0);
	}
	
	//addUsers
	//remove users
	
	//add stores
	//remove stores
	
}
