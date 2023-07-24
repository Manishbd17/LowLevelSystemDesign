package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
	Map<City, List<Movie>> cityVsMovies;
	List<Movie> allMovies; 
	
	MovieController() {
		cityVsMovies = new HashMap<> (); 
		allMovies = new ArrayList<> (); 
	}
	
	//add movie to particular city using cityVsMovies map
	void addMovie(Movie movie,City city) {
		allMovies.add(movie);
		List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
		movies.add(movie); 
		cityVsMovies.put(city,movies); 
	}
	
	Movie getMovieByName(String movieName) {
		for(Movie movie: allMovies) {
			if((movie.getMovieName()).equals(movieName))
				return movie; 
		}
		return null;
	}
	
	List<Movie> getMoviesByCity(City city){
		return cityVsMovies.get(city); 
	}
	
	//Remove movie from a particular city using cityVsMovies map
	
	//Update movie of a particular city using cityVsMovies map
	
	//CRUD operation based on Movie ID,using allMovies list. 

}
