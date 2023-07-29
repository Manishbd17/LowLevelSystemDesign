package Cricbuzz.ScoreUpdater;

import Cricbuzz.Innings.BallDetails;

public interface ScoreUpdaterObserver {
	public void update(BallDetails ballDetails);
}
