package HW;

public class Main {
    public static void main(String[] args) {
        PersonRecord person1 = new Person("anas yab", 23, "dhahrat albadeah");
        PersonRecord student1 = new Student("fyadh ", 25, "dhahrat albadeah", 1234, "CS");

        System.out.println(person1.getDetails());
        System.out.println();
        System.out.println(student1.getDetails());

        System.out.println();
        System.out.println("Comparing Student ID: ");
        Student student2 = new Student("Ahmad", 20, "makkah", 1212, "Math");
        System.out.println("Student ID 1212 matches: " + student2.compareById(1212));
        System.out.println("Student ID 1234 matches: " + student2.compareById(1234));
        School school = new School();

        school.addStudent(new Student("anas", 20, "Riyadh", 1313, "IT"));
        school.addStudent(new Student("fyadh ", 25, "dhahrat albadeah", 1234, "CS"));

        System.out.println("All Students:");
        school.displayStudents();
        System.out.println();

        school.removeStudent(1234);

        System.out.println("Students after remove:");
        school.displayStudents();
        System.out.println();

        school.sortStudentsByName();

        System.out.println("Students after sorting by name:");
        school.displayStudents();
        System.out.println();

        int searchId = 1313;
        Student foundStudent = school.findStudentById(searchId);
        if (foundStudent != null) {
            System.out.println("Found Student with ID " + searchId + ":");
            System.out.println(foundStudent.getDetails());
        } else {
            System.out.println("Student with ID " + searchId + " not found.");
        }
        System.out.println();

        school.writeStudentsToFile("C:\\Users\\dev\\Desktop\\test\\students.txt");

      school.readStudentsFromFile("C:\\Users\\dev\\Desktop\\test\\students.txt");

        System.out.println("Students after reading from the file:");
        school.displayStudents();
    }
}

