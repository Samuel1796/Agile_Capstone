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
    void isValidId_boundaryLength() {
        String id64 = "a".repeat(64);
        assertTrue(Validation.isValidId(id64));
        assertFalse(Validation.isValidId("a".repeat(65)));
    }

    @Test
    void isValidName() {
        assertFalse(Validation.isValidName(null));
        assertFalse(Validation.isValidName(""));
        assertTrue(Validation.isValidName("Alice"));
    }

    @Test
    void isValidName_boundaryLength() {
        assertTrue(Validation.isValidName("a".repeat(200)));
        assertFalse(Validation.isValidName("a".repeat(201)));
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

    @Test
    void isValidEmail_boundaryLengthAndFormats() {
        String email255 = "a@".concat("b".repeat(252));
        assertTrue(Validation.isValidEmail(email255));
        assertFalse(Validation.isValidEmail("a@".concat("b".repeat(253))));
        assertTrue(Validation.isValidEmail("x@y.z"));
    }
}
