package com.agilecapstone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    void isBlank_trueForNullAndEmpty() {
        assertTrue(Validation.isBlank(null));
        assertTrue(Validation.isBlank(""));
        assertTrue(Validation.isBlank("   "));
        assertFalse(Validation.isBlank("a"));
    }

    @Test
    void isValidId() {
        assertFalse(Validation.isValidId(null));
        assertFalse(Validation.isValidId(""));
        assertFalse(Validation.isValidId("   "));
        assertTrue(Validation.isValidId("u1"));
        assertTrue(Validation.isValidId("user-123"));
    }

    @Test
    void isValidName() {
        assertFalse(Validation.isValidName(null));
        assertFalse(Validation.isValidName(""));
        assertTrue(Validation.isValidName("Alice"));
    }

    @Test
    void isValidEmail() {
        assertFalse(Validation.isValidEmail(null));
        assertFalse(Validation.isValidEmail(""));
        assertFalse(Validation.isValidEmail("no-at"));
        assertFalse(Validation.isValidEmail("@nodomain"));
        assertFalse(Validation.isValidEmail("nodomain@"));
        assertTrue(Validation.isValidEmail("a@b.com"));
        assertTrue(Validation.isValidEmail("user@example.org"));
    }
}
