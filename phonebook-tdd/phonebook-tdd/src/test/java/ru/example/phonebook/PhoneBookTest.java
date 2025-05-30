package ru.example.phonebook;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PhoneBookTest {

    private PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    void testAddReturnsCount() {
        int count = phoneBook.add("Alice", "123");
        assertEquals(1, count);

        count = phoneBook.add("Bob", "456");
        assertEquals(2, count);
    }

    @Test
    void testAddDuplicateNameDoesNotIncreaseCount() {
        phoneBook.add("Alice", "123");
        int count = phoneBook.add("Alice", "999");
        assertEquals(1, count);
    }

    @Test
    void testFindByNumber() {
        phoneBook.add("Alice", "123");
        phoneBook.add("Bob", "456");

        assertEquals("Alice", phoneBook.findByNumber("123"));
        assertEquals("Bob", phoneBook.findByNumber("456"));
        assertNull(phoneBook.findByNumber("999"));
    }

    @Test
    void testFindByName() {
        phoneBook.add("Alice", "123");
        phoneBook.add("Bob", "456");

        assertEquals("123", phoneBook.findByName("Alice"));
        assertEquals("456", phoneBook.findByName("Bob"));
        assertNull(phoneBook.findByName("Charlie"));
    }

    @Test
    void testPrintAllNames() {
        phoneBook.add("Charlie", "789");
        phoneBook.add("Alice", "123");
        phoneBook.add("Bob", "456");

        List<String> names = phoneBook.printAllNames();
        assertEquals(List.of("Alice", "Bob", "Charlie"), names);
    }
}
