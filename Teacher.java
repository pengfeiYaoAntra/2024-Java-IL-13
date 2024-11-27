public class Teacher {
    public String firstName;
    public String lastName;
    public int age;
    public String address;
    public boolean isActive;

    private double salary;
    Teacher(String firstName){
        this.firstName = firstName;
        System.out.println("constructor with one param: firstName: " + firstName);
    }
    public Teacher(){
        System.out.println("No param constructor");
    }
    public Teacher(String firstName, String lastName, int age, String address){
        this.firstName = firstName;
        this.address = address;
        this.lastName = lastName;
        this.age = age;
        System.out.println("all param constructor");
    }

    protected Teacher(int age){
        System.out.println("this is protected constructor age: " + age);
    }
    private Teacher(boolean isActive){
        this.isActive = isActive;
        System.out.println("this is private constructor: isActive " + isActive);
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
