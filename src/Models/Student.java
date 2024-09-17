package Models;

public class Student {
    private String firstName;
    private String lastName;
    private int studentId;
    public Student(String firstName, String lastName, int studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }
    @Override
    public String toString() {
        return String.format("%s %s (%d)", firstName, lastName, studentId);
    }
}
