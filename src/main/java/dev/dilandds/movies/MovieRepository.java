package dev.dilandds.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Does the job of talking to the database
//Default methods are to search via Object ID's of mongoDB data
// To search using imdbId we need to include a different function
// why <Movie, ObjectId> ?
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //Mongo Rep is intelligent enough to identify below search
    Optional<Movie> findMovieByImdbId(String imdbId);
}
