package com.lucas.think_fool.thinker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("thinker")
public class ThinkerController {
    @Autowired
    private ThinkerService thinkerService;

    @GetMapping("")
    public ResponseEntity<List<Thinker>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(thinkerService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Thinker> createThinker(@RequestParam(required = true) String username,
            @RequestParam(required = true) String fullname) {
        // + Validar os request params

        return ResponseEntity.status(HttpStatus.OK).body(thinkerService.createThinker(username, fullname));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateThinker(@PathVariable Long id, @RequestParam String username, @RequestParam String fullname) {
        // + Validar os requests params
        // + Mudar pra responseentity
        
        return thinkerService.updateThinker(id, username, fullname);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteThinker(@PathVariable Long id) {
        return thinkerService.deleteThinker(id);
    }

}
