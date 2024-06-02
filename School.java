package HW;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class School {
    private ArrayList<Student> students;
    public School() {
        students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(int studentId) {
        students.removeIf(student -> student.getStudentId() == studentId);
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student.getDetails());
        }
    }

    public void sortStudentsByName() {
        Collections.sort(students, (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
    }

    public Student findStudentById(int studentId) {
        int index = Collections.binarySearch(students, new Student("", 0, "", studentId, ""), (s1, s2) -> s1.getStudentId() - s2.getStudentId());
        if (index >= 0) {
            return students.get(index);
        }
        return null;
    }

    public void writeStudentsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(student.getDetails());
            }
            System.out.println("Student details written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }


        }
    public void readStudentsFromFile(String s) {
        try (BufferedReader reader = new BufferedReader(new FileReader(s))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 5) {
                    String name = details[0];
                    int age = Integer.parseInt(details[1]);
                    String address = details[2];
                    int studentId = Integer.parseInt(details[3]);
                    String course = details[4];
                    students.add(new Student(name, age, address, studentId, course));
                }
            }
            System.out.println("Student details read from the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        }
    }
}




