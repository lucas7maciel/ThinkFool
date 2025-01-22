package com.lucas.think_fool.post;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public ResponseEntity<Page<Post>> findAll(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        return postService.findAll(page, pageSize);
    }

    @PostMapping("")
    public ResponseEntity<Object> createPost(@RequestParam(name = "content", required = true) String content,
            @RequestParam(name = "thinker", required = true) Long thinkerId) {
        return postService.createPost(content, thinkerId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

}
