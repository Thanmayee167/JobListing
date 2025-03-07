package com.thanmayee.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thanmayee.joblisting.model.Post;

/**
 * Repository interface for managing Job Post entities.
 * Extends MongoRepository to provide standard CRUD operations for Post documents.
 * This interface automatically implements basic database operations like save, delete,
 * findById, etc. through Spring Data MongoDB.
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
