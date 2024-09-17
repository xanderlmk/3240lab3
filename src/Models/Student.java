package Models;

public class Student {
    private String firstName;
    private String lastName;
    private String studentEmail;
    private int studentId;

    public Student(String firstName, String lastName,int studentId, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.studentEmail = email;
    }
    @Override
    public String toString() {
        return String.format("%s %s (%d) %s", firstName, lastName, studentId, studentEmail);
    }
}
