package org.example.taskoop;

import java.util.List;

public class  Main {
    public static void main(String[] args) {
        // Создаем колледж
        Collage collage = new Collage("My Collage");

        // Создаем группы
        Group groupA = new Group(2023, "NPTV23");
        Group groupB = new Group(2022, "JPTV22");

        // Создаем курсы
        Course java = new Course(Subject.JAVA);
        Course python = new Course(Subject.PYTHON);
        Course ruby = new Course(Subject.RUBY);
        Course golang = new Course(Subject.GOLANG);

        // Создаем студентов
        Student emil = new Student("Emil", "Ivanov", 20);
        emil.addCourse(java);
        emil.addCourse(java);
        emil.addCourse(python);
        emil.addCourse(ruby);

        Student anna = new Student("Anna", "Petrova", 19);
        anna.addCourse(java);
        anna.addCourse(python);
        anna.addCourse(ruby);
        anna.addCourse(golang);

        Student ivan = new Student("Ivan", "Sidorov", 21);
        ivan.addCourse(java);
        ivan.addCourse(python);
        ivan.addCourse(golang);

        // Добавляем студентов в группы
        groupA.addStudent(emil);
        groupA.addStudent(anna);
        groupB.addStudent(ivan);

        // Генерируем оценки
        emil.learning();
        anna.learning();
        ivan.learning();

        // Выводим информацию о колледже
        System.out.println("Collage: " + collage.getName());

        for (Group g : List.of(groupA, groupB)) {
            System.out.println("Group: " + g.getGroupName());

            for (Student s : g.getStudents()) {
                double avg = switch (s.name) {
                    case "Emil" -> StatisticsService.getAverageByAllCourses(emil);
                    case "Anna" -> StatisticsService.getAverageByAllCourses(anna);
                    case "Ivan" -> StatisticsService.getAverageByAllCourses(ivan);
                    default -> 0.0;
                };

                Course bestSubject = s.getBestSubject();
                String bestSubjectName = (bestSubject != null) ? bestSubject.getSubject().toString() : "Нет данных";

                System.out.println("    " + g.getGroupName() + " " + s.getName() + " " + s.getSurname()
                        + " Scores: [" + s.getAllScores() + "] Average: " + avg
                        + " Best Subject: " + bestSubjectName);
            }

            Student best = StatisticsService.getBestStudent(g);
            Student worst = StatisticsService.getWorstStudent(g);

            if (best != null) {
                System.out.println("Лучший студент в группе " + g.getGroupName() + ": "
                        + best.getName() + " " + best.getSurname());
            } else {
                System.out.println("Нет лучших студентов (пустая группа) в " + g.getGroupName());
            }

            // Проверяем, чтобы лучший и худший студент не совпадали, если больше одного студента
            if (worst != null) {
                if (worst == best && g.getStudents().size() > 1) {
                    // Если в группе более одного студента, но лучший и худший совпадают —
                    // можно вывести сообщение, что однозначно худшего нет
                    System.out.println("Не удалось определить худшего студента в группе " + g.getGroupName());
                } else if (worst == best && g.getStudents().size() == 1) {
                    // Если студент в группе один, то он же лучший и худший
                    System.out.println("В группе " + g.getGroupName() + " один студент, он же и лучший, и худший: "
                            + worst.getName() + " " + worst.getSurname());
                } else {
                    System.out.println("Худший студент в группе " + g.getGroupName() + ": "
                            + worst.getName() + " " + worst.getSurname());
                }
            } else {
                System.out.println("Нет худших студентов (пустая группа) в " + g.getGroupName());
            }
        }
    }
}
