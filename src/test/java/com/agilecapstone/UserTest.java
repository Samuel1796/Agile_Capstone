package com.agilecapstone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void createUser_withValidFields_succeeds() {
        User u = new User("u1", "Alice", "alice@example.com");
        assertEquals("u1", u.getId());
        assertEquals("Alice", u.getName());
        assertEquals("alice@example.com", u.getEmail());
    }

    @Test
    void setterUpdatesNameAndEmail() {
        User u = new User("u1", "Alice", "alice@example.com");
        u.setName("Alicia");
        u.setEmail("alicia@test.com");
        assertEquals("Alicia", u.getName());
        assertEquals("alicia@test.com", u.getEmail());
    }

    @Test
    void equals_byId() {
        User a = new User("u1", "A", "a@x.com");
        User b = new User("u1", "B", "b@x.com");
        User c = new User("u2", "A", "a@x.com");
        assertEquals(a, b);
        assertNotEquals(a, c);
        assertEquals(a, a);
        assertNotEquals(a, null);
        assertNotEquals(a, "u1");
    }

    @Test
    void hashCode_consistentWithEquals() {
        User a = new User("u1", "A", "a@x.com");
        User b = new User("u1", "B", "b@x.com");
        assertEquals(a.hashCode(), b.hashCode());
    }
}
