package org.example.taksoop6;

import java.util.Scanner;

public class Practicum {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Вас приветствует виртуальная АТС!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваш номер телефона:");
        String number = scanner.next();
        System.out.println("Введите номер пользователя, которому хотите позвонить:");
        String friendNumber = scanner.next();
        System.out.println("Выберите модель телефона собеседника, 1 - стационарный телефон, 2 - мобильный телефон, 3 - смартфон:");
        int type = scanner.nextInt();

        if (type < 1 || type > 3) {
            System.out.println("Введена неверная модель телефона");
            return;
        }

        getPhone(type, number).makeCall(friendNumber);
    }

    public static Phone getPhone(int type, String number) {
        if (type == 1) {
            // Если выбран стационарный телефон, создайте объект класса CellularPhone
            return new CellularPhone(number);
        } else if (type == 2) {
            // Если выбран мобильный телефон, создайте объект класса MobilePhone

            MobilePhone mobilePhone = new MobilePhone(number);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите смс.");
            String massage = scanner.next();
            mobilePhone.sendSms(number, massage);
            return mobilePhone;

        } else {
            // Иначе создайте экземпляр класса Smartphone
            Smartphone smartphone = new Smartphone(number);
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите почту кому хотите отправить письмо.");
            String email = scanner1.next();
            System.out.println("Введите письмо.");
            String massageText = scanner1.next();
            smartphone.sendEmail(email, massageText);
            return new Smartphone(number);
        }
    }

}
