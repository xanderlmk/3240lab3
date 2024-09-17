package Models;

import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    private List<Student> students;
    public StudentModel() {
        students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(int index) {
        students.remove(index);
    }
    public List<Student> getStudents() {
        return students;
    }
}
