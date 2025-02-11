package org.example.TaskList2;

public class MountainHare {
    int age;
    double weight;
    double jumpLength;
    String color;

    public MountainHare(int age, double weight, double jumpLength) {
        this.age = age;
        this.weight = weight;
        this.jumpLength = jumpLength;
        this.color = "серо-рыжий";
    }

    @Override
    public String toString() {
        return "Заяц-беляк: " +
                "age=" + age +
                ", weight=" + weight +
                ", jumpLength=" + jumpLength +
                ", color=" + color +
                '.';
    }
}