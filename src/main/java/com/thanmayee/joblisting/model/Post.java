package com.thanmayee.joblisting.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a job posting in the system.
 * This class is mapped to the "JobPost" collection in MongoDB.
 * It contains all the relevant information about a job posting including
 * the job profile, description, required experience, and technologies.
 */
@Document(collection = "JobPost")
public class Post {
    
    /**
     * Unique identifier for the job post.
     * Automatically generated by MongoDB.
     */
    @Id
    private String id;
    
    /**
     * The job profile or title of the position.
     */
    private String profile;
    
    /**
     * Detailed description of the job role and responsibilities.
     */
    private String description;
    
    /**
     * Required years of experience for the position.
     */
    private int experience;
    
    /**
     * Array of required technologies/skills for the position.
     */
    private String[] technologies;

    /**
     * Default constructor for Post.
     */
    public Post() {
    }

    /**
     * Gets the unique identifier of the job post.
     * @return the job post ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the job post.
     * @param id the job post ID to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the job profile/title.
     * @return the job profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Sets the job profile/title.
     * @param profile the job profile to set
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * Gets the job description.
     * @return the job description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the job description.
     * @param description the job description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the required years of experience.
     * @return the required experience in years
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Sets the required years of experience.
     * @param experience the required experience to set
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Gets the array of required technologies.
     * @return array of required technologies/skills
     */
    public String[] getTechnologies() {
        return technologies;
    }

    /**
     * Sets the array of required technologies.
     * @param technologies array of required technologies/skills to set
     */
    public void setTechnologies(String[] technologies) {
        this.technologies = technologies;
    }

    /**
     * Returns a string representation of the Post object.
     * @return a string containing all the job post details
     */
    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", profile='" + profile + '\'' +
                ", description='" + description + '\'' +
                ", experience=" + experience +
                ", technologies=" + Arrays.toString(technologies) +
                '}';
    }
}
