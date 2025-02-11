package org.example.taskoop;

import java.util.*;
import static java.util.stream.Collectors.toList;

public class Student extends Human {

    // Карта: Курс -> Список оценок (от 1 до 5)
    Map<Course, List<Byte>> score = new HashMap<>();

    public Student(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public void learning() {
        Random random = new Random();
        for (Map.Entry<Course, List<Byte>> entry : score.entrySet()) {
            Course c = entry.getKey();
            List<Byte> grades = entry.getValue();
            // Генерируем оценки для каждого курса
            int count = random.nextInt(1, 9);
            for (int i = 0; i < count; i++) {
                byte sc = (byte) (random.nextInt(5) + 1);
                grades.add(sc);
            }
        }
    }

    public void addScoreToMap(Course course, Byte value) {
        if (value < 1 || value > 5) {
            throw new IllegalArgumentException("Оценка должна быть от 1 до 5");
        }
        score.computeIfAbsent(course, c -> new ArrayList<>()).add(value);
    }

    public void addCourse(Course course) {
        score.put(course, new ArrayList<Byte>());
    }

    public String getAllScores() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Course, List<Byte>> entry : score.entrySet()) {
            Course c = entry.getKey();
            List<Byte> grades = entry.getValue();
            sb.append(c.getSubject()).append(": ")
                    .append(grades.stream().map(String::valueOf).collect(toList()))
                    .append("; ");
        }
        return sb.toString();
    }

    // Новый метод для получения лучшего предмета по среднему баллу
    public Course getBestSubject() {
        if (score.isEmpty()) {
            return null;
        }

        double maxAverage = 0.0;
        Course bestCourse = null;

        for (Map.Entry<Course, List<Byte>> entry : score.entrySet()) {
            List<Byte> grades = entry.getValue();
            if (grades.isEmpty()) continue;

            double sum = 0;
            for (Byte g : grades) {
                sum += g;
            }
            double avg = sum / grades.size();
            if (avg > maxAverage) {
                maxAverage = avg;
                bestCourse = entry.getKey();
            }
        }

        return bestCourse;
    }
}
