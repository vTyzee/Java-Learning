package org.example.taskoop;

import java.util.List;
import java.util.Map;


public class StatisticsService {
    Student student;

    public StatisticsService(Student student) {
        this.student = student;
    }

    public static double getAverageByAllCourses(Student student) {
        if (student.score.isEmpty()) {
            return 0.0;
        }

        List<List<Byte>> courseScores = student.score.values().stream().toList();
        double sumAverage = 0.0;

        for (List<Byte> singleCourseScores : courseScores) {
            double sum = 0.0;
            for (Byte s : singleCourseScores) {
                sum += s;
            }
            double average = singleCourseScores.isEmpty() ? 0.0 : sum / singleCourseScores.size();
            sumAverage += average;
        }

        return sumAverage / courseScores.size();
    }

    public static String bestScoreOfCourses(Student student) {
        if (student.score.isEmpty()) {
            return "Нет курсов или оценок.";
        }

        double maxAverage = 0.0;
        Course bestCourse = null;

        for (Map.Entry<Course, List<Byte>> entry : student.score.entrySet()) {
            List<Byte> grades = entry.getValue();
            if (grades.isEmpty()) {
                continue;
            }

            double sum = 0.0;
            for (Byte grade : grades) {
                sum += grade;
            }

            double average = sum / grades.size();
            if (average > maxAverage) {
                maxAverage = average;
                bestCourse = entry.getKey();
            }
        }

        if (bestCourse == null) {
            return "Нет оценок для расчета.";
        } else {
            return "Лучший курс: " + bestCourse.getSubject().toString() + " со средним баллом: " + maxAverage;
        }
    }

    public static String worstScoreOfCourses(Student student) {
        if (student.score.isEmpty()) {
            return "Нет курсов или оценок.";
        }

        double minAverage = 6.0;
        Course worstCourse = null;

        for (Map.Entry<Course, List<Byte>> entry : student.score.entrySet()) {
            List<Byte> grades = entry.getValue();
            if (grades.isEmpty()) {
                continue;
            }

            double sum = 0.0;
            for (Byte grade : grades) {
                sum += grade;
            }

            double average = sum / grades.size();
            if (average < minAverage) {
                minAverage = average;
                worstCourse = entry.getKey();
            }
        }

        if (worstCourse == null) {
            return "Нет оценок для расчета.";
        } else {
            return "Худший курс: " + worstCourse.getSubject().toString() + " со средним баллом: " + minAverage;
        }
    }

    // Новые статические методы для определения лучшего и худшего студента в группе
    public static Student getBestStudent(Group group) {
        if (group.getStudents().isEmpty()) {
            return null;
        }

        Student bestStudent = null;
        double bestAverage = Double.NEGATIVE_INFINITY;

        for (Student st : group.getStudents()) {
            double avg = getAverageByAllCourses(st);
            if (avg > bestAverage) {
                bestAverage = avg;
                bestStudent = st;
            }
        }

        return bestStudent;
    }

    public static Student getWorstStudent(Group group) {
        if (group.getStudents().isEmpty()) {
            return null;
        }

        Student worstStudent = null;
        double worstAverage = 6.0; // любое значение будет меньше и он его автоматом

        for (Student st : group.getStudents()) {
            double avg = getAverageByAllCourses(st);
            if (avg < worstAverage) {
                worstAverage = avg;
                worstStudent = st;
            }
        }

        return worstStudent;
    }
}
