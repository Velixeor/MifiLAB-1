package org.example;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Group1", 1, Map.of("Math", 4, "English", 5, "History", 3)));
        students.add(new Student("Bob", "Group2", 2, Map.of("Math", 2, "English", 2, "History", 3)));
        students.add(new Student("Charlie", "Group1", 3, Map.of("Math", 5, "English", 5, "History", 5)));
        System.out.println("Исходный список студентов:");
        students.forEach(System.out::println);
        processStudents(students);
        System.out.println("\nСписок студентов после обработки:");
        students.forEach(System.out::println);
        System.out.println("\nСтуденты 2 курса:");
        printStudents(students, 2);
    }

    public static void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            } else {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }
}
