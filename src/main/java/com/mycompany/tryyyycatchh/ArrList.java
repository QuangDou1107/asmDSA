/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tryyyycatchh;

import java.util.ArrayList;

/**
 *
 * @author vuqua
 */
public class ArrList {

    private ArrayList<Student> students;

    public ArrList() {
        students = new ArrayList<>();
    }

    // Add student
    public void addStudent(int id, String name, double marks) {
        Student student = new Student(id, name, marks);
        students.add(student);
    }

    // edit student by ID
    public void editStudent(int id, String newName, double newMarks) {
        boolean found = false;
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(newName);
                student.setMarks(newMarks);
                System.out.println("Update student successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No students to have ID: " + id);
        }
    }

    // Delete studet by ID
    public boolean deleteStudent(int id) {
        return students.removeIf(student -> student.getId() == id);
    }

    // Search student by ID
    public Student searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // (Bubble Sort)
    public void sortStudentsByMarks() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {

                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }
    // (Selection Sort)

    public void sortStudentsById() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students.get(j).getId() < students.get(minIndex).getId()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Student temp = students.get(i);
                students.set(i, students.get(minIndex));
                students.set(minIndex, temp);
            }
        }
    }

    // Binary Search by Marks
    public Student binarySearchByMarks(int targetMarks) {
        // First sort the students list by marks
        sortStudentsByMarks();
        int left = 0, right = students.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (students.get(mid).getMarks() == targetMarks) {
                return students.get(mid);
            }
            if (students.get(mid).getMarks() < targetMarks) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // If not found
    }

      // Linear Search - Search for a student by name
    public ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }
   

}
