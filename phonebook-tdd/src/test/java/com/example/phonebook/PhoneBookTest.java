// src/test/java/com/example/phonebook/PhoneBookTest.java
package test.java.com.example.phonebook;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PhoneBookTest {
    @Test
    public void testAddReturnsCorrectCount() {
        PhoneBook phoneBook = new PhoneBook();
        assertEquals(1, phoneBook.add("Alice", "123-456-789"));
        assertEquals(2, phoneBook.add("Bob", "987-654-321"));
    }
    
    @Test
    public void testAddDuplicateName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123-456-789");
        assertEquals(1, phoneBook.add("Alice", "999-999-999"));
    }
    
    @Test
    public void testFindByNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123-456-789");
        assertEquals("Alice", phoneBook.findByNumber("123-456-789"));
        assertNull(phoneBook.findByNumber("000-000-000"));
    }
    
    @Test
    public void testFindByName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123-456-789");
        assertEquals("123-456-789", phoneBook.findByName("Alice"));
        assertNull(phoneBook.findByName("Bob"));
    }
    
    @Test
    public void testPrintAllNames() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Charlie", "111-111-111");
        phoneBook.add("Alice", "222-222-222");
        phoneBook.add("Bob", "333-333-333");
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        phoneBook.printAllNames();
        
        String expected = "Alice" + System.lineSeparator() +
                         "Bob" + System.lineSeparator() +
                         "Charlie" + System.lineSeparator();
        assertEquals(expected, outContent.toString());
    }
}