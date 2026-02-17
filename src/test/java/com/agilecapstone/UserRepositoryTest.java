package com.agilecapstone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository repository;

    @BeforeEach
    void setUp() {
        repository = new UserRepository();
    }

    @Test
    void save_addsUser_andFindAllReturnsIt() {
        User u = new User("id1", "Alice", "alice@example.com");
        repository.save(u);
        List<User> all = repository.findAll();
        assertEquals(1, all.size());
        assertEquals("id1", all.get(0).getId());
    }

    @Test
    void findById_returnsEmptyWhenNotFound() {
        assertTrue(repository.findById("none").isEmpty());
    }

    @Test
    void findById_returnsUserWhenPresent() {
        User u = new User("id1", "Alice", "alice@example.com");
        repository.save(u);
        Optional<User> found = repository.findById("id1");
        assertTrue(found.isPresent());
        assertEquals("Alice", found.get().getName());
    }

    @Test
    void update_modifiesExistingUser() {
        User u = new User("id1", "Alice", "alice@example.com");
        repository.save(u);
        User updated = new User("id1", "Alicia", "alicia@example.com");
        assertTrue(repository.update(updated));
        assertEquals("Alicia", repository.findById("id1").get().getName());
    }

    @Test
    void update_returnsFalseWhenUserNotFound() {
        User u = new User("id1", "Alice", "alice@example.com");
        assertFalse(repository.update(u));
    }

    @Test
    void deleteById_removesUser() {
        User u = new User("id1", "Alice", "alice@example.com");
        repository.save(u);
        assertTrue(repository.deleteById("id1"));
        assertTrue(repository.findById("id1").isEmpty());
        assertEquals(0, repository.findAll().size());
    }

    @Test
    void deleteById_returnsFalseWhenNotFound() {
        assertFalse(repository.deleteById("none"));
    }

    @Test
    void existsById_returnsTrueWhenPresent() {
        repository.save(new User("id1", "A", "a@x.com"));
        assertTrue(repository.existsById("id1"));
        assertFalse(repository.existsById("id2"));
    }
}
