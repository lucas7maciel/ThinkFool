package com.lucas.think_fool.post;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lucas.think_fool.thinker.Thinker;
import com.lucas.think_fool.thinker.ThinkerRepo;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ThinkerRepo thinkerRepo;

    public ResponseEntity<Page<Post>> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Post> posts = postRepo.findAll(pageable);

        return ResponseEntity.ok().body(posts);
    }

    public ResponseEntity<Object> createPost(String content, Long thinkerId) {
        Optional<Thinker> thinker = thinkerRepo.findById(thinkerId);

        if (!thinker.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(String.format("User with id %d was not found", thinkerId));
        }

        // Usar construtor
        Post newPost = new Post();

        newPost.setContent(content);
        newPost.setThinker(thinker.get());
        newPost.setCreatedAt(LocalDateTime.now());

        return ResponseEntity.ok().body(postRepo.save(newPost));
    }

    public ResponseEntity<Object> deletePost(Long id) {
        if (!postRepo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(String.format("Post with id %d does not exist", id));
        }

        postRepo.deleteById(id);

        return ResponseEntity.ok().body("Post deleted successfully");
    }
}
