package com.thanmayee.joblisting.repository;

import java.util.List;

import com.thanmayee.joblisting.model.Post;

/**
 * Repository interface for searching job posts.
 * Provides custom search functionality for job posts using text-based search criteria.
 */
public interface SearchRepository {
    
    /**
     * Searches for job posts based on text input.
     * The search is performed across multiple fields including profile, description,
     * and technologies.
     *
     * @param text the search text to match against job posts
     * @return a list of Post objects that match the search criteria
     */
    List<Post> searchByText(String text);
}
