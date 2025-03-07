package com.thanmayee.joblisting.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.thanmayee.joblisting.model.Post;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

@Repository
public class SearchRepositoryImpl implements SearchRepository {

  @Autowired MongoClient mongoClient;

  @Autowired MongoConverter mongoConverter;

  @Override
  public List<Post> searchByText(String text) {
    List<Post> postList = new ArrayList<>();
    MongoDatabase database = mongoClient.getDatabase("mydatabase");
    MongoCollection<Document> collection = database.getCollection("JobPost");
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
    result.forEach(document -> postList.add(mongoConverter.read(Post.class, document)));
    return postList;
  }
}
