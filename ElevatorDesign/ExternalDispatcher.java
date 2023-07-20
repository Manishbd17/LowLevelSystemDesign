package ElevatorDesign;

import java.util.List;

public class ExternalDispatcher {
	
	List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;
	
	public void submitExternalRequest(int floor, Direction direction) {
		for(ElevatorController elevatorController: elevatorControllerList) {
			int elevatorId = elevatorController.elevatorCar.id;
			if(elevatorId%2==0 && floor%2==0)
				elevatorController.submitExternalRequest(floor,direction); 
			if(elevatorId%2==1 && floor%2==1)
				elevatorController.submitExternalRequest(floor,direction); 
			
		}
	}
}
