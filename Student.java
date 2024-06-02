package HW;
class Student extends PersonRecord implements ComparableById {
    private int studentId;
    private String course;
 String name;
  String address;
 int age;
    public Student(String name, int age, String address, int studentId, String course) {
        super();
        setName(name);
        setAge(age);
        setAddress(address);
        setStudentId(studentId);
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getters and setters

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Invalid student ID! Student ID should be a positive integer.");
        }
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Implementing the abstract method from PersonRecord
    @Override
    public String getDetails() {
        return "Student Details:\n" +
                "Name: " + getName() + "\n" +
                "Age: " + getAge() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Student ID: " + studentId + "\n" +
                "Course: " + course;
    }

    @Override
    public boolean compareById(int id) {
        return studentId == id;
    }
}