package BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
	MovieController movieController; 
	TheatreController theatreController;
	
	BookMyShow() {
		movieController = new MovieController();
		theatreController = new TheatreController(); 
	}
	
	public static void main(String args[]) {
		BookMyShow bookMyShow = new BookMyShow(); 
		bookMyShow.initialize(); 
		//user1
		bookMyShow.createBooking(City.BANGALORE,"AVENGERS"); 
		//user2
		bookMyShow.createBooking(City.BANGALORE,"AVATAR");
	}
	
	private void createBooking(City userCity,String movieName) {
		//1. search movie by my location 
		List<Movie> movies = movieController.getMoviesByCity(userCity); 
		
		//2. select the movie which you want to see.
		Movie interestMovie =null;
		for(Movie movie: movies) {
			if((movie.getMovieName()).equals(movieName)) {
				interestMovie=movie; 
			}
		}
		
		//3. Get all show of the movie in Bangalore 
		Map<Theatre,List<Show>> showsTheatreWise = theatreController.getAllShow(interestMovie,userCity);
		
		//4. Select the particular show user is interested in
		Map.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
		List<Show> runningShows = entry.getValue();
		Show interestShow = runningShows.get(0); 
		
		//5. Select the seat 
		int seatNumber = 30; 
		List<Integer> bookedSeats= interestShow.getBookedSeatIds(); 
		if(!bookedSeats.contains(seatNumber)) {
			bookedSeats.add(seatNumber); 
			//start payment
			Booking booking = new Booking(); 
			List<Seat> myBookedSeats = new ArrayList<> (); 
			for(Seat screenSeat : interestShow.getScreen().getSeats()) {
				if(screenSeat.getSeatId() == seatNumber) {
					myBookedSeats.add(screenSeat); 
				}
			}
			booking.setBookedSeats(myBookedSeats); 
			booking.setShow(interestShow); 
		} else {
			//throw exception 
			System.out.println("Seat Already booked ,try again");
			return ; 
		}
		System.out.println("Booking Successful");
	}
	
	private void initialize() {
		createMovies(); 
		createTheatre(); 
	}
	
	private void createTheatre() {
		Movie Avenger = movieController.getMovieByName("AVENGERS"); 
		Movie Avatar = movieController.getMovieByName("AVATAR"); 
		
		Theatre inoxTheatre = new Theatre(); 
		inoxTheatre.setTheatreId(1); 
		inoxTheatre.setScreen(createScreen()); 
		inoxTheatre.setCity(City.BANGALORE); 
		List<Show> inoxShows = new ArrayList<>(); 
		Show inoxMorningShow = createShows(1,inoxTheatre.getScreen().get(0),Avenger,8);
		Show inoxEveningShow = createShows(2,inoxTheatre.getScreen().get(0),Avatar,16); 
		inoxShows.add(inoxMorningShow);
		inoxShows.add(inoxEveningShow);
		inoxTheatre.setShows(inoxShows); 
		
		
		Theatre pvrTheatre = new Theatre(); 
		pvrTheatre.setTheatreId(2); 
		pvrTheatre.setScreen(createScreen()); 
		pvrTheatre.setCity(City.DELHI);
		List<Show> pvrShows = new ArrayList<>();
		Show pvrMorningShow = createShows(3,pvrTheatre.getScreen().get(0),Avenger,11);
		Show pvrEveningShow = createShows(4,pvrTheatre.getScreen().get(0),Avatar,17); 
		pvrShows.add(pvrMorningShow); 
		pvrShows.add(pvrEveningShow);
		pvrTheatre.setShows(pvrShows); 
		
		theatreController.addTheatre(inoxTheatre,City.BANGALORE);
		theatreController.addTheatre(pvrTheatre,City.DELHI); 
	}
	
	private List<Screen> createScreen() {
		List<Screen> screens = new ArrayList<> (); 
		Screen screen1 = new Screen(); 
		screen1.setScreenId(1); 
		screen1.setSeats(createSeats()); 
		screens.add(screen1); 
		return screens; 
	}
	
	private Show createShows(int showId,Screen screen,Movie movie,int showStartTime) {
		Show show = new Show(); 
		show.setShowId(showId); 
		show.setScreen(screen); 
		show.setMovie(movie); 
		show.setShowStartTime(showStartTime);
		return show; 
	}
	
	//Creating 100 seats 
	private List<Seat> createSeats() {
		List<Seat> seats = new ArrayList<> (); 
		//1 to 40 : SILVER
		for(int i=0;i<40;i++) {
			Seat seat = new Seat(); 
			seat.setSeatId(i); 
			seat.setSeatCategory(SeatCategory.SILVER); 
			seats.add(seat); 
		}
		//41 to 70 : GOLD 
		for(int i=40;i<70;i++) {
			Seat seat = new Seat(); 
			seat.setSeatId(i); 
			seat.setSeatCategory(SeatCategory.GOLD);	
			seats.add(seat); 
		}
		//70 to 100 : PLATINUM
		for(int i=70;i<100;i++) {
			Seat seat = new Seat();
			seat.setSeatId(i);
			seat.setSeatCategory(SeatCategory.PLATINUM); 
			seats.add(seat); 
		}
		return seats; 
	}
	
	private void createMovies() {
		//create Movies1
		Movie avengers = new Movie(); 
		avengers.setMovieId(1); 
		avengers.setMovieName("AVENGERS"); 
		avengers.setMovieDurationInMinutes(128);
		
		//create Movies2
		Movie avatar = new Movie(); 
		avatar.setMovieId(2); 
		avatar.setMovieName("AVATAR"); 
		avatar.setMovieDurationInMinutes(180); 
		
		//add movies against the cities 
		movieController.addMovie(avengers,City.BANGALORE);
		movieController.addMovie(avengers,City.DELHI);
		movieController.addMovie(avatar,City.BANGALORE); 
		movieController.addMovie(avatar,City.DELHI); 
		
	}
	
	
}
