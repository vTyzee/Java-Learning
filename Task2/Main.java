package org.example.Task2;

public class Main {
    public static void main(String[] args) {
        int roubles = 5000; // сумма на счету
        int yearRate = 4; // годовая процентная ставка
        int numOfMonth = 36; // количество месяцев, на который открыт вклад
        int monthRefill = 1000; // ежемесячное пополнение

        double monthRate = yearRate / 12; // вычислите месячную процентную ставку

        for (int i = 0; i < 36; i ++) { // дополните условие цикла
        double depositInterest = roubles * monthRate / 100; // вычислите доход от процентов
        roubles += depositInterest; // добавьте доход от процентов
        roubles += monthRefill;// учтите ежемесячное пополнение
        }

        System.out.println("Через " + numOfMonth + " месяцев накопится " + roubles + " рублей");

        if (roubles >= 41000) { // определите, удалось ли достичь цели
            System.out.println("Ура! Можно идти в магазин за новым объективом!");
        } else {
            System.out.println("Нужно ещё немного подкопить.");
        }
    }
}