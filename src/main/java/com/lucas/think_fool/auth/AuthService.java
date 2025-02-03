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

    // throws InvalidJwtException
    public Thinker signUp(SignUpDto data) throws Exception {
        if (!thinkerRepo.findByUsername(data.login()).isEmpty()) {
            throw new Exception("Username already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        
        // Mudar isso pra service
        Thinker newThinker = new Thinker();

        newThinker.setUsername(data.login());
        newThinker.setName("Nome teste");
        newThinker.setPassword(encryptedPassword);

        return thinkerRepo.save(newThinker);
    }
}
