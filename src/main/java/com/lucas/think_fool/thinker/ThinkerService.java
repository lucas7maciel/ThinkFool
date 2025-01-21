package com.lucas.think_fool.thinker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ThinkerService {
    @Autowired
    private ThinkerRepo thinkerRepo;

    public List<Thinker> findAll() {
        List<Thinker> thinkers = thinkerRepo.findAll();

        // + Fazer contador de posts

        return thinkers;
    }

    public Thinker createThinker(String username, String fullname) {
        // + Checar se username ja existe

        Thinker newThinker = new Thinker();

        newThinker.setUsername(username);
        newThinker.setName(fullname);

        return thinkerRepo.save(newThinker);
    }

    public ResponseEntity<String> updateThinker(Long id, String username, String fullname) {
        // * Transformar args em dict

        if (!thinkerRepo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(String.format("User with id %d does not exist", id));
        }

        Thinker newThinker = new Thinker();

        newThinker.setId(id);
        newThinker.setUsername(username);
        newThinker.setName(fullname);

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
