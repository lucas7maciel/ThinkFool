package com.lucas.think_fool.thinker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThinkerService {
    @Autowired
    private ThinkerRepo thinkerRepo;

    public List<Thinker> findAll() {
        return null;
    }
}
