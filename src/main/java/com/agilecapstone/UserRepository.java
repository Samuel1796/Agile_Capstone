package com.agilecapstone;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * In-memory repository for User CRUD operations.
 */
public class UserRepository {
    private final List<User> users = new CopyOnWriteArrayList<>();

    public User save(User user) {
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public Optional<User> findById(String id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    public boolean update(User user) {
        Optional<User> existing = findById(user.getId());
        if (existing.isEmpty()) return false;
        User e = existing.get();
        e.setName(user.getName());
        e.setEmail(user.getEmail());
        return true;
    }

    public boolean deleteById(String id) {
        return users.removeIf(u -> u.getId().equals(id));
    }

    public boolean existsById(String id) {
        return findById(id).isPresent();
    }
}
