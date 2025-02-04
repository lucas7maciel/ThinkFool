package com.lucas.think_fool.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignInDto(@NotBlank() @Size(min = 5, max = 15) String username,
        @NotBlank() @Size(min = 8, max = 20) String password) {

}
