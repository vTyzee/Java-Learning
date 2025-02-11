package org.example.TaskOrderM;

import java.util.*;
import java.util.stream.Collectors;

public class OrderManager {

    // Класс заказа
    static class Order {
        private final String customerName;
        private final String productName;
        private final int quantity;

        public Order(String customerName, String productName, int quantity) {
            this.customerName = customerName;
            this.productName = productName;
            this.quantity = quantity;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "customerName='" + customerName + '\'' +
                    ", productName='" + productName + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }

    // Группировка заказов по покупателям
    public static Map<String, List<Order>> groupOrdersByCustomer(List<Order> orders){
        return orders.stream().collect(Collectors.groupingBy(Order::getCustomerName));
    }

    // Возвращает топ-3 покупателей по суммарному количеству заказанных товаров
    public static List<String> getTopCustomers(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerName, Collectors.summingInt(Order::getQuantity)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // Подсчёт уникальных товаров для каждого покупателя
    public static Map<String, Integer> getDistinctProductCounts(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        Collectors.mapping(Order::getProductName, Collectors.toSet())))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()));
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Alice", "Laptop", 1),
                new Order("Bob", "Smartphone", 2),
                new Order("Alice", "Tablet", 3),
                new Order("Charlie", "Headphones", 5),
                new Order("Bob", "Monitor", 1),
                new Order("Charlie", "Keyboard", 2)
        );

        // Группировка заказов по покупателям
        Map<String, List<Order>> groupedOrders = groupOrdersByCustomer(orders);
        System.out.println("Grouped Orders: " + groupedOrders);

        // Топ-3 покупателя
        List<String> topCustomers = getTopCustomers(orders);
        System.out.println("Top Customers: " + topCustomers);

        // Уникальные товары для каждого покупателя
        Map<String, Integer> distinctProductCounts = getDistinctProductCounts(orders);
        System.out.println("Distinct Product Counts: " + distinctProductCounts);
    }
}
