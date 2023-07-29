package Cricbuzz.Innings;

import java.util.ArrayList;
import java.util.List;

import Cricbuzz.Team.Team;
import Cricbuzz.Team.Player.PlayerDetails;

public class OverDetails {
	int overNumber; 
	List<BallDetails> balls; 
	int extraBallsCount;
	PlayerDetails bowledBy;
	
	OverDetails(int overNumber,PlayerDetails bowledBy) {
		this.overNumber=overNumber; 
		balls=new ArrayList<> (); 
		this.bowledBy=bowledBy;
	}
	
	public boolean startOver(Team battingTeam, Team bowlingTeam,int runsToWin) throws Exception {
		int ballCount=1; 
		while(ballCount<=6) {
			BallDetails ball = new BallDetails(ballCount); 
			ball.startBallDelivery(battingTeam,bowlingTeam,this);
			if(ball.ballType==BallType.NORMAL) {
				balls.add(ball); 
				if(ball.wicket!=null) {
					battingTeam.chooseNextBatsMan(); 
				}
				if(runsToWin!=-1 && battingTeam.getTotalRuns()>=runsToWin) {
					battingTeam.isWinner = true; 
					return true; 
				}
			}
		}
		return false; 
	}
	
}
