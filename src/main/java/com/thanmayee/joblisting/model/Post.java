package com.thanmayee.joblisting.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JobPost")
public class Post {
  @Id
  private String id;
  private String profile;
  private String description;
  private int experience;
  private String[] technologies;

  public Post() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProfile() {
    return profile;
  }

  public void setProfile(String profile) {
    this.profile = profile;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getExperience() {
    return experience;
  }

  public void setExperience(int experience) {
    this.experience = experience;
  }

  public String[] getTechnologies() {
    return technologies;
  }

  public void setTechnologies(String[] technologies) {
    this.technologies = technologies;
  }

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
