package com.lucas.think_fool.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucas.think_fool.dtos.SignUpDto;
import com.lucas.think_fool.thinker.Thinker;
import com.lucas.think_fool.thinker.ThinkerRepo;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    ThinkerRepo thinkerRepo;

    @Override
    public Thinker loadUserByUsername(String username) {
        Optional<Thinker> thinker = thinkerRepo.findByUsername(username);
        return thinker.get();
    }

    // Trocar por 'throws InvalidJwtException'
    public Thinker signUp(SignUpDto data) throws Exception {
        if (!thinkerRepo.findByUsername(data.username()).isEmpty()) {
            throw new Exception("Username already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        
        Thinker newThinker = new Thinker(data.username(), "Nome teste", encryptedPassword);
        return thinkerRepo.save(newThinker);
    }
}
