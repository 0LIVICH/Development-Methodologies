package ru.example.phonebook;

import java.util.*;

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
        return numberToName.getOrDefault(number, null);
    }

    public String findByName(String name) {
        return nameToNumber.getOrDefault(name, null);
    }

    public List<String> printAllNames() {
        TreeSet<String> sorted = new TreeSet<>(nameToNumber.keySet());
        return new ArrayList<>(sorted);
    }
}
