package org.sylman.seminar4;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        Student student = new Student(1, "John", "Scott", 32);
        Student student1 = new Student(2, "Liza", "Rose", 23);
        Student student2 = new Student(3, "Robert", "Walkman", 41);
        Student student3 = new Student(4, "Max", "Greg", 28);
        Student student4 = new Student(5, "Joe", "O'Connel", 14);
        studentDAO.persistStudent(student);

        Student foundStudent = studentDAO.findStudentById(1);
        System.out.println("Found student: " + foundStudent.getFirstName() + " " + foundStudent.getSecondName());

        foundStudent.setAge(33);
        studentDAO.mergeStudent(foundStudent);

        studentDAO.removeStudent(foundStudent);

        studentDAO.persistStudent(student1);
        studentDAO.persistStudent(student2);
        studentDAO.persistStudent(student3);
        studentDAO.persistStudent(student4);

        List<Student> studentsOlderThan20 = studentDAO.findStidentsOlderThan(20);
        System.out.println("Students older than 20: ");
        for (Student s : studentsOlderThan20) {
            System.out.println(s.getFirstName() + " " + s.getSecondName() + ", age: " + s.getAge());
        }

        studentDAO.closeSessionFactory();
//
////        studentDAO.closeSessionFactory();
//        Student student = new Student(1, "John", "Scott", 32);
//        Student student1 = new Student(2, "Liza", "Rose", 23);
//        Student student2 = new Student(3, "Robert", "Walkman", 41);
//
//        StudentDAO.createTable();
//
//        StudentDAO.persistStudent(student);
//        StudentDAO.persistStudent(student1);
//        StudentDAO.persistStudent(student2);
//
//        Student foundStudent = StudentDAO.findStudentById(1);
//        System.out.println("Found student: " + foundStudent.getFirstName() + " " + foundStudent.getSecondName());
//        foundStudent.setAge(33);
//        StudentDAO.mergeStudent(foundStudent);
//        System.out.println("Now: " + foundStudent.getFirstName() + " " + foundStudent.getSecondName());
//
//        StudentDAO.removeStudent(foundStudent);
//
//        List<Student> studentsOlderThan20 = StudentDAO.findStidentsOlderThan(20);
//        System.out.println("Students older than 20: ");
//        for (Student s : studentsOlderThan20) {
//            System.out.println(s.getFirstName() + " " + s.getSecondName() + ", age: " + s.getAge());
//        }
//
//        StudentDAO.closeSessionFactory();
    }
}
