package org.example.TaskList3;

public class HandMadeLinkedList<T> {

    // Вложенный класс для узла списка
    private static class Node<E> {
        E data;           // Данные узла
        Node<E> next;     // Ссылка на следующий узел
        Node<E> prev;     // Ссылка на предыдущий узел

        Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.prev =prev;
            this.next = next;
        }
    }

    // Указатели на первый и последний элементы списка
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    // Добавить элемент в начало списка
    public void addFirst(T element) {
        Node<T> oldHead = first;
        Node<T> newNode = new Node<>(element, null, oldHead);
        first = newNode;
        if (oldHead == null) {
            last = newNode;
        } else {
            oldHead.prev = newNode;
        }
        size++;
    }

    // Получить первый элемент списка
    public T getFirst() {
        if (first == null) {
            throw new IllegalStateException("The list is empty");
        }
        return first.data;
    }

    // Добавить элемент в конец списка
    public void addLast(T element) {
        Node<T> oldTale = last;
        Node<T> newNode = new Node<>(element, null, last);
        last = newNode;
        if (oldTale == null) {
            last = newNode;
        } else {
            oldTale.next = newNode;
        }
        size++;
    }

    // Получить последний элемент списка
    public T getLast() {
        if (last == null) {
            throw new IllegalStateException("The list is empty");
        }
        return last.data;
    }

    // Получить размер списка
    public int size() {
        return this.size;
    }

    // Основной метод для тестирования
    public static void main(String[] args) {
        HandMadeLinkedList<Integer> integers = new HandMadeLinkedList<>();

        // Тестовые операции
        integers.addFirst(1);
        integers.addFirst(2);
        integers.addFirst(3);
        integers.addLast(4);
        integers.addLast(5);
        integers.addFirst(1);

        // Вывод результата
        System.out.println(integers.getFirst()); // Ожидается: 1
        System.out.println(integers.size());    // Ожидается: 6
        System.out.println(integers.getLast()); // Ожидается: 5
        System.out.println(integers.size());    // Ожидается: 6
    }
}
