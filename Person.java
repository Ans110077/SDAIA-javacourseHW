package HW;
class Person extends PersonRecord {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        setAge(age);
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Invalid age! Age should be between 0 and 150.");
        }
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getDetails() {
        return "Person Details:\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Address: " + address;
    }
}