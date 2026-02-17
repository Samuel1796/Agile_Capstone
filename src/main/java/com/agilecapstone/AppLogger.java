package com.agilecapstone;

import java.time.Instant;

/**
 * Simple console logger for key actions and errors (Sprint 2 - US-6).
 */
public final class AppLogger {

    private AppLogger() {}

    public static void info(String message) {
        log("INFO", message);
    }

    public static void error(String message) {
        log("ERROR", message);
    }

    public static void error(String message, Throwable t) {
        log("ERROR", message + " " + (t != null ? t.getMessage() : ""));
    }

    private static void log(String level, String message) {
        String line = String.format("[%s] %s %s", Instant.now(), level, message);
        System.out.println(line);
    }
}
