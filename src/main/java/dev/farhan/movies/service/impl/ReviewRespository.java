package dev.farhan.movies.service.impl;

import dev.farhan.movies.model.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRespository extends MongoRepository<Review, ObjectId> {


}
