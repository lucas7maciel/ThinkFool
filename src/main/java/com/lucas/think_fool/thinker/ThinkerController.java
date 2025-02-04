package com.lucas.think_fool.thinker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("thinker")
public class ThinkerController {
    @Autowired
    private ThinkerService thinkerService;

    @GetMapping("")
    public ResponseEntity<Page<Thinker>> findAll(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.status(HttpStatus.OK).body(thinkerService.findAll(page, pageSize));
    }

    // @PostMapping("")
    // public ResponseEntity<Thinker> createThinker(@RequestParam(required = true) String username,
    //         @RequestParam(required = true) String fullname) {
    //     // + Validar os request params

    //     return ResponseEntity.status(HttpStatus.OK).body(thinkerService.createThinker(username, fullname));
    // }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateThinker(@PathVariable Long id, @RequestParam @NotBlank() @Size(min=5, max=15) String username,
            @RequestParam @NotBlank() @Size(min=8, max=35) String fullname) {
        return thinkerService.updateThinker(id, username, fullname);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteThinker(@PathVariable Long id) {
        return thinkerService.deleteThinker(id);
    }

}
