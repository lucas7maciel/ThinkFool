package com.lucas.think_fool.thinker;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ThinkerRepo extends JpaRepository<Thinker, Long> {
    Optional<Thinker> findByUsername(String username);
}
