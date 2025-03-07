package com.thanmayee.joblisting.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thanmayee.joblisting.model.Post;
import com.thanmayee.joblisting.repository.PostRepository;
import com.thanmayee.joblisting.repository.SearchRepository;

import jakarta.servlet.http.HttpServletResponse;

/**
 * REST Controller for managing job posts.
 * Provides endpoints for creating, retrieving, and searching job posts.
 * All endpoints return JSON responses.
 */
@RestController
public class JobPostController {

    /**
     * Repository for basic CRUD operations on job posts.
     */
    @Autowired 
    PostRepository postRepository;

    /**
     * Repository for searching job posts.
     */
    @Autowired 
    SearchRepository searchRepository;

    /**
     * Redirects the root URL to Swagger UI documentation.
     * 
     * @param response HTTP response object used for redirection
     * @throws IOException if redirection fails
     */
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    /**
     * Retrieves all job posts from the database.
     * 
     * @return List of all job posts
     */
    @GetMapping(value = "/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    /**
     * Searches for job posts based on text input.
     * The search is performed across multiple fields including profile,
     * description, and technologies.
     * 
     * @param text the search text to match against job posts
     * @return List of matching job posts, sorted by experience
     */
    @GetMapping(value = "/posts/{text}")
    public List<Post> getPostBy(@PathVariable String text) {
        return searchRepository.searchByText(text);
    }

    /**
     * Creates a new job post.
     * 
     * @param post the job post object to create
     * @return the created job post with generated ID
     */
    @PostMapping(value = "/post")
    public Post addPost(@RequestBody Post post) {
        return postRepository.save(post);
    }
}
