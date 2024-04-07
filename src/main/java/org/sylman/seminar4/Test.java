package org.sylman.seminar4;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        Student student = new Student(1, "John", "Scott", 32);
        Student student1 = new Student(2, "Liza", "Rose", 23);
        Student student2 = new Student(3, "Robert", "Walkman", 41);
        studentDAO.persistStudent(student);

        Student foundStudent = studentDAO.findStudentById(1);
        System.out.println("Found student: " + foundStudent.getFirstName() + " " + foundStudent.getSecondName());

        foundStudent.setAge(33);
        studentDAO.mergeStudent(foundStudent);

        studentDAO.removeStudent(foundStudent);

        studentDAO.persistStudent(student1);
        studentDAO.persistStudent(student2);

        List<Student> studentsOlderThan20 = studentDAO.findStidentsOlderThan(20);
        System.out.println("Students older than 20: ");
        for (Student s : studentsOlderThan20) {
            System.out.println(s.getFirstName() + " " + s.getSecondName() + ", age: " + s.getAge());
        }

        studentDAO.closeSessionFactory();
    }
}
