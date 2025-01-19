package com.lucas.think_fool.thinker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("thinker")
public class ThinkerController {
    @Autowired
    private ThinkerService thinkerService;

    @GetMapping("")
    public List<Thinker> findAll() {
        return thinkerService.findAll();
    }

}
