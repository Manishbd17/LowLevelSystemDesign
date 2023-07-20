package SnakeAndLadder;

public class Player {
	
	String id;
	int currentPosition; 
	
	public Player(String id,int currentPosition) {
		this.id=id;
		this.currentPosition=currentPosition; 
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

}
