package com.lucas.think_fool.thinker;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ThinkerService {
    @Autowired
    private ThinkerRepo thinkerRepo;

    public Page<Thinker> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Thinker> thinkers = thinkerRepo.findAll(pageable);

        return thinkers;
    }

    // public Thinker createThinker(String username, String fullname) {
    // // + Checar se username ja existe

    // Thinker newThinker = new Thinker();

    // newThinker.setUsername(username);
    // newThinker.setName(fullname);

    // return thinkerRepo.save(newThinker);
    // }

    public ResponseEntity<String> updateThinker(Long id, String username, String fullname) {
        Optional<Thinker> optionalThinker = thinkerRepo.findById(id);

        if (!optionalThinker.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(String.format("User with id %d does not exist", id));
        }

        Thinker thinker = optionalThinker.get();

        thinker.setUsername(username);
        thinker.setName(fullname);
        
        thinkerRepo.save(thinker);

        return ResponseEntity.ok(String.format("User with id %d successfully updated!", id));
    }

    public ResponseEntity<String> deleteThinker(Long id) {
        if (!thinkerRepo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The provided user does not exist");
        }

        thinkerRepo.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
