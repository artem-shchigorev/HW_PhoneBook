import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите 1, чтобы добавить запись в телефонную книгу\nВведите 2, чтобы вывести все имена и номера телефонов\nВведите 3, чтобы завершить программу");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Введите имя:");
                String name = scanner.next();
                System.out.println("Введите номер телефона:");
                String phoneNumber = scanner.next();

                phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
            } else if (choice == 2) {
                phoneBook.entrySet().stream()
                        .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                        .forEach(entry -> {
                            System.out.println("Имя: " + entry.getKey());
                            System.out.println("Номера телефонов: " + entry.getValue());
                        });
            } else if (choice == 3) {
                break;
            }
        }

        scanner.close();
    }
}
