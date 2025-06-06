// src/main/java/com/example/phonebook/PhoneBook.java
package com.example.phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class PhoneBook {
    private final Map<String, String> nameToNumber = new HashMap<>();
    private final Map<String, String> numberToName = new HashMap<>();
    
    public int add(String name, String number) {
        if (!nameToNumber.containsKey(name)) {
            nameToNumber.put(name, number);
            numberToName.put(number, name);
        }
        return nameToNumber.size();
    }
    
    public String findByNumber(String number) {
        return numberToName.get(number);
    }
    
    public String findByName(String name) {
        return nameToNumber.get(name);
    }
    
    public void printAllNames() {
        TreeSet<String> sortedNames = new TreeSet<>(nameToNumber.keySet());
        for (String name : sortedNames) {
            System.out.println(name);
        }
    }
}