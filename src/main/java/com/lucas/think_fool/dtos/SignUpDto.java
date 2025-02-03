package com.lucas.think_fool.dtos;

import com.lucas.think_fool.thinker.ThinkerRole;

public record SignUpDto(
        String login, String password, ThinkerRole role) {
}
