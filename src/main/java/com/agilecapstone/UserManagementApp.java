package com.agilecapstone;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Console entry point for User Management (CRUD).
 */
public class UserManagementApp {
    private final UserRepository repository;
    private final Scanner scanner;

    public UserManagementApp(UserRepository repository, Scanner scanner) {
        this.repository = repository;
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        UserRepository repo = new UserRepository();
        try (Scanner sc = new Scanner(System.in)) {
            UserManagementApp app = new UserManagementApp(repo, sc);
            app.run();
        }
    }

    public void run() {
        printMenu();
        while (true) {
            System.out.print("Choice: ");
            String line = scanner.nextLine();
            if (line == null || line.isBlank()) continue;
            String choice = line.trim().toLowerCase();
            switch (choice) {
                case "1" -> createUser();
                case "2" -> listUsers();
                case "3" -> updateUser();
                case "4" -> deleteUser();
                case "5" -> healthCheck();
                case "0", "q", "quit" -> {
                    System.out.println("Bye.");
                    return;
                }
                default -> System.out.println("Unknown option. Try 1-5 or 0 to quit.");
            }
            System.out.println();
            printMenu();
        }
    }

    private void printMenu() {
        System.out.println("--- User Management ---");
        System.out.println("1. Create user");
        System.out.println("2. List all users");
        System.out.println("3. Update user");
        System.out.println("4. Delete user");
        System.out.println("5. Health check");
        System.out.println("0. Quit");
    }

    private void createUser() {
        System.out.print("Id: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (!Validation.isValidId(id)) {
            AppLogger.error("Create failed: invalid id");
            System.out.println("Error: Invalid id.");
            return;
        }
        if (!Validation.isValidName(name)) {
            AppLogger.error("Create failed: invalid name");
            System.out.println("Error: Invalid name.");
            return;
        }
        if (!Validation.isValidEmail(email)) {
            AppLogger.error("Create failed: invalid email");
            System.out.println("Error: Invalid email.");
            return;
        }
        if (repository.existsById(id)) {
            AppLogger.error("Create failed: duplicate id=" + id);
            System.out.println("Error: User with id '" + id + "' already exists.");
            return;
        }

        User user = new User(id.trim(), name.trim(), email.trim());
        repository.save(user);
        AppLogger.info("User created: id=" + user.getId());
        System.out.println("User created: " + user.getId());
    }

    private void listUsers() {
        List<User> users = repository.findAll();
        if (users.isEmpty()) {
            System.out.println("No users in the list.");
            return;
        }
        for (User u : users) {
            System.out.println(u.getId() + " | " + u.getName() + " | " + u.getEmail());
        }
    }

    private void updateUser() {
        System.out.print("User id to update: ");
        String id = scanner.nextLine();
        if (Validation.isBlank(id)) {
            System.out.println("Error: Id is required.");
            return;
        }
        Optional<User> opt = repository.findById(id.trim());
        if (opt.isEmpty()) {
            System.out.println("Error: User not found: " + id);
            return;
        }
        System.out.print("New name (Enter to keep current): ");
        String name = scanner.nextLine();
        System.out.print("New email (Enter to keep current): ");
        String email = scanner.nextLine();

        User existing = opt.get();
        if (!Validation.isBlank(name) && Validation.isValidName(name)) existing.setName(name.trim());
        if (!Validation.isBlank(email) && Validation.isValidEmail(email)) existing.setEmail(email.trim());
        repository.update(existing);
        AppLogger.info("User updated: id=" + existing.getId());
        System.out.println("User updated: " + existing.getId());
    }

    private void deleteUser() {
        System.out.print("User id to delete: ");
        String id = scanner.nextLine();
        if (Validation.isBlank(id)) {
            System.out.println("Error: Id is required.");
            return;
        }
        boolean removed = repository.deleteById(id.trim());
        if (removed) {
            AppLogger.info("User deleted: id=" + id);
            System.out.println("User deleted: " + id);
        } else {
            AppLogger.error("Delete failed: user not found id=" + id);
            System.out.println("Error: User not found: " + id);
        }
    }

    private void healthCheck() {
        AppLogger.info("Health check requested");
        System.out.println("Status: healthy");
    }
}
