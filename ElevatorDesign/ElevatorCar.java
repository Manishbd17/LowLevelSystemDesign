package ElevatorDesign;

public class ElevatorCar {
	int id; 
	ElevatorDisplay display;
	ElevatorState elevatorState;
	InternalButtons internalButtons; 
	int currentFloor; 
	ElevatorDoor elevatorDoor; 
	Direction elevatorDirection;
	
	public ElevatorCar() {
		display = new ElevatorDisplay();
		internalButtons = new InternalButtons();
		elevatorState = ElevatorState.IDLE; 
		currentFloor = 0;
		elevatorDirection = Direction.UP;
		elevatorDoor = new ElevatorDoor();
	}
	
	public void showDisplay() {
		display.showDisplay(currentFloor,elevatorDirection);
	}
	
	public void pressButton() {
		
	}
	
	public void setDisplay() {
		this.display.setDisplay(currentFloor,elevatorDirection);
	}
	
	boolean moveElevator(Direction dir, int destinationFloor) {
		return false;
	}

}
