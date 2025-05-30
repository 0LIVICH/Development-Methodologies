

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    @Test
    void testAddReturnsCorrectCount() {
        PhoneBook phoneBook = new PhoneBook();
        assertEquals(1, phoneBook.add("Alice", "123"));
        assertEquals(1, phoneBook.add("Alice", "123")); // Повтор
        assertEquals(2, phoneBook.add("Bob", "456"));
    }

    @Test
    void testFindByNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123");
        phoneBook.add("Bob", "456");

        assertEquals("Alice", phoneBook.findByNumber("123"));
        assertEquals("Bob", phoneBook.findByNumber("456"));
        assertNull(phoneBook.findByNumber("789"));
    }

    @Test
    void testFindByName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123");

        assertEquals("123", phoneBook.findByName("Alice"));
        assertNull(phoneBook.findByName("Unknown"));
    }

    @Test
    void testPrintAllNamesSorted() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Charlie", "789");
        phoneBook.add("Alice", "123");
        phoneBook.add("Bob", "456");

        List<String> expected = List.of("Alice", "Bob", "Charlie");
        assertEquals(expected, phoneBook.printAllNames());
    }
}
