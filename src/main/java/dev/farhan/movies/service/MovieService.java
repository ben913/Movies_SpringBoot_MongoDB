package dev.farhan.movies.service;


import dev.farhan.movies.model.Movie;
import dev.farhan.movies.service.impl.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovie(String id){
        return movieRepository.findMovieByImdbId(id);
    }


}
