

import java.util.*;

public class PhoneBook {
    private final Map<String, String> nameToNumber = new HashMap<>();

    // Добавление контакта
    public int add(String name, String number) {
        nameToNumber.putIfAbsent(name, number);
        return nameToNumber.size();
    }

    // Поиск имени по номеру
    public String findByNumber(String number) {
        for (Map.Entry<String, String> entry : nameToNumber.entrySet()) {
            if (entry.getValue().equals(number)) {
                return entry.getKey();
            }
        }
        return null;
    }

    // Поиск номера по имени
    public String findByName(String name) {
        return nameToNumber.get(name);
    }

    // Печать всех имён в алфавитном порядке
    public List<String> printAllNames() {
        return new ArrayList<>(new TreeSet<>(nameToNumber.keySet()));
    }
}
