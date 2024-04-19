import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, Set<String>> phoneBook = new HashMap<>();

        // Заполнение телефонной книги
        phoneBook.put("Петров", new HashSet<>(Arrays.asList("34788764690")));
        phoneBook.put("Иванов", new HashSet<>(Arrays.asList("89181653827", "36766567676")));
        phoneBook.put("Сидоров", new HashSet<>(Arrays.asList("61239879046", "09898761232")));

        // Объединение существующих записей с повторяющимися именами
        HashMap<String, Set<String>> mergedPhoneBook = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            if (mergedPhoneBook.containsKey(entry.getKey())) {
                mergedPhoneBook.get(entry.getKey()).addAll(entry.getValue());
            } else {
                mergedPhoneBook.put(entry.getKey(), entry.getValue());
            }
        }

        // Сортировка по убыванию числа телефонов
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(mergedPhoneBook.entrySet());
        sortedEntries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        // Вывод результатов
        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
