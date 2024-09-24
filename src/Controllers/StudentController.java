package Controllers;

import Models.Student;
import Models.StudentModel;
import Views.StudentGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentController {
    private StudentModel model;
    private StudentGUI view;



    public StudentController(StudentModel model, StudentGUI view){
        this.model = model;
        this.view = view;

        ArrayList<Student> students = model.getStudents();

        students.forEach(s -> view.addStudentToList(students.toString()));

        view.attachAddStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentIdFinal;
                String firstName = view.getFirstName();
                String lastName = view.getLastName();
                String email = view.getEmail();
                String studentID = view.getStudentId();

                if(firstName.isBlank() || lastName.isBlank() || studentID.isBlank() || email.isBlank()){
                    view.alertError("ALL FIELDS ARE REQUIRED!");
                    return;
                }

                try{
                   studentIdFinal = Integer.parseInt(studentID);
                } catch (Exception ex) {
                    view.alertError("Student ID must be a valid number!");
                    return;
                }
                Student student = new Student(firstName, lastName,studentIdFinal, email);
                if (!model.addStudent(student)) {
                    view.alertError("Unable to add record");
                    return;
                }
                view.addStudentToList(student.toString());
                model.addStudent(new Student(firstName, lastName,studentIdFinal, email));
                view.clearForm();
            }
        });
        view.attachRemoveStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = view.getSelectedIndex();
                int studentId = view.getSelectedIndexId();
                if(index > -1) {
                    model.removeStudent(studentId);
                    view.removeStudentToList(index);
                }
            }
        });
    }
}
