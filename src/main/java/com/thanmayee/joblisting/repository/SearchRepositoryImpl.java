package com.thanmayee.joblisting.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.thanmayee.joblisting.model.Post;

/**
 * Implementation of the SearchRepository interface.
 * Provides MongoDB text search functionality for job posts using aggregation pipeline.
 * This implementation uses MongoDB Atlas Search for efficient full-text search capabilities
 * across multiple fields of job posts.
 */
@Repository
public class SearchRepositoryImpl implements SearchRepository {

    /**
     * MongoDB client for database operations.
     * Automatically injected by Spring.
     */
    @Autowired 
    MongoClient mongoClient;

    /**
     * Converter for transforming MongoDB documents to Java objects.
     * Automatically injected by Spring.
     */
    @Autowired 
    MongoConverter mongoConverter;

    /**
     * {@inheritDoc}
     * 
     * This implementation uses MongoDB Atlas Search with the following features:
     * - Full-text search across profile, description, and technologies fields
     * - Results are sorted by experience in descending order
     * - Limited to 2 results per search
     * 
     * @param text the search text to match against job posts
     * @return a list of matching Post objects, sorted by experience
     */
    @Override
    public List<Post> searchByText(String text) {
        List<Post> postList = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        
        // Create and execute the aggregation pipeline
        AggregateIterable<Document> result =
            collection.aggregate(
                Arrays.asList(
                    new Document(
                        "$search",
                        new Document("index", "default")
                            .append(
                                "text",
                                new Document("query", text)
                                    .append(
                                        "path",
                                        Arrays.asList("profile", "description", "technologies")))),
                    new Document("$sort", new Document("experience", -1L)),
                    new Document("$limit", 2L)));
        
        // Convert results to Post objects
        result.forEach(document -> postList.add(mongoConverter.read(Post.class, document)));
        return postList;
    }
}
