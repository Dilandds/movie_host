package dev.dilandds.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

//Will represent each document in the movies collection
@Document(collection = "movies")
//Getters and setters auto generation
@Data
//constructors
@AllArgsConstructor
@NoArgsConstructor

public class Movie {
    //framework will take Id as a uniques identifier for each movie
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    //This annotation will cause the review to be in a separate collection ( wiill only save IDs here )
    //One movie can have many review one to many relationship

    @DocumentReference
    private List<Review> reviewIds;

}
