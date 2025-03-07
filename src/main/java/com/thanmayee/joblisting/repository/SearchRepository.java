package com.thanmayee.joblisting.repository;

import com.thanmayee.joblisting.model.Post;
import java.util.List;

public interface SearchRepository {
    List<Post> searchByText(String text);
}
