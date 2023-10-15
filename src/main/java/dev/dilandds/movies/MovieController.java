package dev.dilandds.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//Request to below address will be controlled by this annotation
//What rest-controller classes does is just returning data when a end point is triggered
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    //Response entities can return valuable information like status code
    public ResponseEntity<List<Movie>> getAllMovies(){ return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);
    }
    //@patriarchates is to tell the function to use the variable coming from the path
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> singleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);

    }
}
