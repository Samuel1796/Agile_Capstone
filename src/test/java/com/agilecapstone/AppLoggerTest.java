package com.agilecapstone;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppLoggerTest {

    @Test
    void info_printsMessageWithoutThrowing() {
        PrintStream original = System.out;
        try {
            ByteArrayOutputStream captured = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captured));
            AppLogger.info("test info message");
            String output = captured.toString();
            assertTrue(output.contains("INFO"));
            assertTrue(output.contains("test info message"));
        } finally {
            System.setOut(original);
        }
    }

    @Test
    void error_withMessage_printsWithoutThrowing() {
        PrintStream original = System.out;
        try {
            ByteArrayOutputStream captured = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captured));
            AppLogger.error("test error message");
            String output = captured.toString();
            assertTrue(output.contains("ERROR"));
            assertTrue(output.contains("test error message"));
        } finally {
            System.setOut(original);
        }
    }

    @Test
    void error_withMessageAndThrowable_includesThrowableMessage() {
        PrintStream original = System.out;
        try {
            ByteArrayOutputStream captured = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captured));
            AppLogger.error("failed", new RuntimeException("cause"));
            String output = captured.toString();
            assertTrue(output.contains("ERROR"));
            assertTrue(output.contains("cause"));
        } finally {
            System.setOut(original);
        }
    }

    @Test
    void error_withMessageAndNullThrowable_doesNotThrow() {
        PrintStream original = System.out;
        try {
            ByteArrayOutputStream captured = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captured));
            AppLogger.error("msg", null);
            assertTrue(captured.toString().contains("ERROR"));
        } finally {
            System.setOut(original);
        }
    }
}
