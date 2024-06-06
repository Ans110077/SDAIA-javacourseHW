package HW2;


import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    // Constructor to initialize the list
    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to get a student by ID
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Method to get all students
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    // Method to remove a student by ID
    public boolean removeStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }
}

