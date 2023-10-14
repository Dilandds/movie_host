package dev.dilandds.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//Most businnes  logics
//Purpose- uses the repository class and use its functionality to extract data from databases
import java.util.List;
import java.util.Optional;
//Class will have database access methods

@Service
public class MovieService {
    //Reference of the repository
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }
    //Use optional because some id might not have any movies
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
