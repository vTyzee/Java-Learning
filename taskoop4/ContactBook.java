package org.example.taskoop4;

// Ограничьте класс ContactBook так, чтобы он мог хранить в себе только список контактов
import java.util.ArrayList;
import java.util.List;

public class ContactBook {
    // Объявите поле класса contacts - список контактов книги
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void printList() {
        // Выведите на экран весь список контактов книги
        for (Contact contact : contacts) {
            System.out.println("Имя: " + contact.getName());
            contact.print();
        }
    }

    public void congratulate(String name) {
        boolean contactPresented = false; // проверяем есть ли контакт в базе
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contactPresented = true;
                System.out.println("Поздравим с Новым годом ваш контакт из записной книжки: " + name);
                contact.sendMessage();
                break;
            }
        }

        // Если контакт не найден, выведите соответствующее сообщение
        if (!contactPresented) {
            System.out.println("Не найден контакт с указанным именем.");
        }
    }
}