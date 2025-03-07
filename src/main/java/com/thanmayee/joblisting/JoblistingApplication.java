package com.thanmayee.joblisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Job Listing Application - Main Spring Boot Application Class
 *
 * <p>This application provides a RESTful API for managing job listings using Spring Boot and
 * MongoDB Atlas as the database. It allows users to create, read job postings, as well as search
 * for jobs using various criteria.
 *
 * <p>Features: - MongoDB Atlas integration for data persistence - RESTful API endpoints for job
 * management - Search functionality for job listings
 */
@SpringBootApplication
public class JoblistingApplication {

  /**
   * The main method that starts the Spring Boot application.
   *
   * @param args Command line arguments passed to the application
   */
  public static void main(String[] args) {
    SpringApplication.run(JoblistingApplication.class, args);
  }
}
