package org.example;

import java.util.Scanner;

public class Main {

    private static String name;
    private static String city;

    public static void main(String[] args) {
        System.out.println("Робот-помощник v1.0.");

        sayHello();
        sayHelloByTime();
        welcomeUserByName();
        printCity();

        System.out.println("Рад познакомиться," + name + " из " + city);

        printSuccess();

    }

    public static void welcomeUserByName() { // Объявите метод welcomeUserByName
        Scanner scanner = new Scanner(System.in);
        System.out.println("Как вас зовут?");
        name = scanner.nextLine();// Сохраните введённое пользователем имя в переменную name
        System.out.println("Рад познакомиться, " + name);
    }

    private static void sayHelloByTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Который час? (1-24)");
        byte currentHour = scanner.nextByte();

        while (currentHour >= 0 || currentHour <= 24) {
            if (currentHour <= 22 || currentHour < 6) {
                System.out.println("Доброй ночи!");
                break;

            } else if (currentHour >= 6 && currentHour < 12) {
                System.out.println("Доброе утро!");
                break;

            } else if (currentHour >= 12 && currentHour < 18) {
                System.out.println("Добрый день!");
                break;

            } else if (currentHour >= 18 && currentHour < 22) {
                System.out.println("Добрый вечер!");
                break;

            } else {
                System.out.println("Неправильный формат!");
                sayHelloByTime();
                break;
            }
        }

    }
    private static void printSuccess(){
        System.out.println("У вас уже неплохо получается программировать!");
    } // Объявите метод printSuccess

    private static void sayHello(){
        System.out.println("Привет!");
    }         // Допишите метод sayHello(), который печатает: Привет!

    public static void printCity(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Из какого вы города?");
        city = scanner.nextLine();

    }// Допишите метод printCity(), который печатает: Из какого вы города?
}