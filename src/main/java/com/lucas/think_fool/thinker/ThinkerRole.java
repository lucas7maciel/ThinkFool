
package com.lucas.think_fool.thinker;

public enum ThinkerRole {
    ADMIN("user"),
    USER("user");

    private String role;

    ThinkerRole(String role) {
        this.role = role;
    }

    public String getValue() {
        return this.role;
    }
}
