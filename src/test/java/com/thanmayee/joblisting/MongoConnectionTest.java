package com.thanmayee.joblisting;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
public class MongoConnectionTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testMongoConnection() {
        assertNotNull(mongoTemplate);
    // This will throw an exception if connection fails
    System.out.println("-------------------------------------------------------------------------------------------");
    System.out.println(
    mongoTemplate.getDb().getName());
    }
} 