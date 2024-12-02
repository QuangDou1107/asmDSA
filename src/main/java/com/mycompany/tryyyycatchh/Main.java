/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tryyyycatchh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrList studentList = new ArrList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nStudent Management System");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Search Student by ID");
                System.out.println("5. Display All Students");
                System.out.println("6. Sort Students by Marks");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();

                if (choice < 0 || choice > 6) {
                    throw new IllegalArgumentException("Invalid option. Please choose a number between 0 and 6.");
                }

                switch (choice) {
                    case 1:
                        int id;
                        String name;
                        double marks;

                        System.out.print("Enter ID: ");
                        id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        // enter name 
                        while (true) {
                            System.out.print("Enter Name: ");
                            name = scanner.nextLine();
                            if (name.matches("[a-zA-Z ]+")) {
                                break;
                            } else {
                                System.out.println("Invalid name. Please enter letters only.");
                            }
                        }

                        // Nhập điểm và kiểm tra
                        while (true) {
                            System.out.print("Enter Marks: ");
                            marks = scanner.nextDouble();
                            if (marks >= 0 && marks <= 10) {
                                break;
                            } else {
                                System.out.println("Invalid marks. Please enter a value between 0 and 10.");
                            }
                        }

                        studentList.addStudent(id, name, marks);
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter ID of student to edit: ");
                        int editId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        // Check if student exists
                        Student studentToEdit = studentList.searchStudentById(editId);
                        if (studentToEdit == null) {
                            System.out.println("Student not found.");
                            break;
                        }

                        String newName;
                        double newMarks;

                        // Nhập lại tên nếu sai
                        while (true) {
                            System.out.print("Enter new Name: ");
                            newName = scanner.nextLine();
                            if (newName.matches("[a-zA-Z ]+")) {
                                break;
                            } else {
                                System.out.println("Invalid name. Please enter letters only.");
                            }
                        }

                        // Nhập lại điểm nếu sai
                        while (true) {
                            System.out.print("Enter new Marks: ");
                            newMarks = scanner.nextDouble();
                            if (newMarks >= 0 && newMarks <= 10) {
                                break;
                            } else {
                                System.out.println("Invalid marks. Please enter a value between 0 and 10.");
                            }
                        }

                        studentList.editStudent(editId, newName, newMarks);
                        break;

                    case 3:
                        System.out.print("Enter ID of student to delete: ");
                        int deleteId = scanner.nextInt();
                        if (studentList.deleteStudent(deleteId)) {
                            System.out.println("Student deleted successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter ID of student to search: ");
                        int searchId = scanner.nextInt();
                        Student student = studentList.searchStudentById(searchId);
                        if (student != null) {
                            System.out.println(student);
                        } else {
                            System.out.println("Not found Student.");
                        }
                        break;

                    case 5:
                        studentList.displayStudents();
                        break;

                    case 6:
                        studentList.sortStudentsByMarks();
                        System.out.println("Students sorted by marks.");
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
}
