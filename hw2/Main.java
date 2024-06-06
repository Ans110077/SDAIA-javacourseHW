package HW2;


public class Main {
    public static void main(String[] args) {
        // Create the StudentManager instance
        var manager = new StudentManager();

        // Create several Student objects
        Student student1 = new Student("Ali", 1);
        Student student2 = new Student("Mohammed", 2);
        Student student3 = new Student("Abdulrhman", 3);

        // Add these students to the StudentManager
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        // Retrieve and display a student by their ID
        Student retrievedStudent = manager.getStudentById(2);
        if (retrievedStudent != null) {
            System.out.println("Retrieved Student: " + retrievedStudent.getName() + ", ID: " + retrievedStudent.getId());
        } else {
            System.out.println("Student not found.");
        }

        // Display all students in the list
        System.out.println("All Students:");
        for (Student student : manager.getAllStudents()) {
            System.out.println(student.getName() + ", ID: " + student.getId());
        }

        // Remove a student by their ID and display the list of students again to confirm removal
        boolean removed = manager.removeStudentById(2);
        if (removed) {
            System.out.println("Student with ID 2 removed.");
        } else {
            System.out.println("Student with ID 2 not found.");
        }

        // Display all students after removal
        System.out.println("All Students after removal:");
        for (Student student : manager.getAllStudents()) {
            System.out.println(student.getName() + ", ID: " + student.getId());
        }
    }
}

