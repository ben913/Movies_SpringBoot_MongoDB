package dev.farhan.movies.service;


import dev.farhan.movies.model.Movie;
import dev.farhan.movies.model.Review;
import dev.farhan.movies.service.impl.ReviewRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {

    @Autowired
    private ReviewRespository reviewRespository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRespository.insert(new Review(reviewBody, LocalDateTime.now(),LocalDateTime.now()));
       // reviewRespository.insert(review);
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

       return review;

    }
}
