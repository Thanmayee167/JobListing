package com.thanmayee.joblisting.controller;

import com.thanmayee.joblisting.model.Post;
import com.thanmayee.joblisting.repository.PostRepository;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobPostController {

    @Autowired PostRepository postRepository;
    
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(value = "/posts")
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @PostMapping(value = "/post")
    public Post addPost(@RequestBody Post post){
        return postRepository.save(post);
    }

}
