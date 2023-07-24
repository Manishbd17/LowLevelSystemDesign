package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	int theatreId; 
	String address;
	City city; 
	List<Show> shows = new ArrayList<> (); 
	List<Screen> screen = new ArrayList<> ();
	
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	public List<Screen> getScreen() {
		return screen;
	}
	public void setScreen(List<Screen> screen) {
		this.screen = screen;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	} 
}
