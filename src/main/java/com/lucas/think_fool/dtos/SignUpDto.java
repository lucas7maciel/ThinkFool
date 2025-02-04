package com.lucas.think_fool.dtos;

import com.lucas.think_fool.thinker.ThinkerRole;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// + Usar composição
public record SignUpDto(
                @NotBlank() @Size(min = 5, max = 15) String username,
                @NotBlank() @Size(min = 8, max = 20) String password,
                ThinkerRole role) {
}
