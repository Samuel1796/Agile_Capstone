package com.agilecapstone;

/**
 * Simple validation for user input (id, name, email).
 */
public final class Validation {

    private Validation() {}

    public static boolean isBlank(String s) {
        return s == null || s.isBlank();
    }

    public static boolean isValidId(String id) {
        return !isBlank(id) && id.length() <= 64;
    }

    public static boolean isValidName(String name) {
        return !isBlank(name) && name.length() <= 200;
    }

    public static boolean isValidEmail(String email) {
        if (isBlank(email) || email.length() > 255) return false;
        return email.contains("@") && email.indexOf('@') > 0 && email.indexOf('@') < email.length() - 1;
    }
}
