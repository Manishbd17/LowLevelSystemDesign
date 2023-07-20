package SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class SnakeAndLadderGame {
	Board board; 
	Dice dice; 
	Deque<Player> playerList = new LinkedList<> (); 
	Player winner; 
	
	public SnakeAndLadderGame() {
		initializeGame(); 
	}
	
	private void initializeGame() {
		board = new Board(10,4,5); 
		dice = new Dice(1);
		winner = null;
		addPlayers(); 
	}
	
	private void addPlayers() {
		Player player1 = new Player("p1", 0);
		Player player2 = new Player("p2", 0); 
		playerList.add(player1); 
		playerList.add(player2); 
	}
	
	
	public void startGame() {
		
		while(winner==null) {
			//check whose turn now
			Player playerTurn = findPlayerTurn(); 
			System.out.println("Player turn is " + playerTurn.id + "current position is "+ playerTurn.currentPosition); 
			
			//roll the dice
			int diceNumbers = dice.rollDice(); 
			
			//get the new position 
			int playerNewPosition = playerTurn.currentPosition + diceNumbers;
			playerNewPosition = jumpCheck(playerNewPosition); 
			playerTurn.currentPosition = playerNewPosition; 
			
			System.out.println("Player turn is" + playerTurn.id + "new position is" + playerNewPosition); 
			
			//check for winning condition 
			if(playerNewPosition >= board.cells.length*board.cells.length-1) {
				winner = playerTurn; 
			}
		}
		System.out.println("Winner is "+ winner.id);
	}
	
	private Player findPlayerTurn() {
		Player playerTurns = playerList.removeFirst(); 
		playerList.addLast(playerTurns);
		return playerTurns; 
	}
	
	private int jumpCheck(int playerNewPosition) {
		if(playerNewPosition > board.cells.length*board.cells.length-1)
			return playerNewPosition;
		
		Cell cell = board.getCell(playerNewPosition); 
		if(cell.jump!=null && cell.jump.start == playerNewPosition) {
			String jumpBy = (cell.jump.start < cell.jump.end) ? "ladder" : "snake"; 
			System.out.println("Jump done by: " + jumpBy); 
			return cell.jump.end; 
		}
		
		return playerNewPosition;
	}
	
}
