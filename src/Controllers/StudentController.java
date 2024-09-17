package Controllers;

import Models.Student;
import Models.StudentModel;
import Views.StudentGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController {
    private StudentModel model;
    private StudentGUI view;

    public StudentController(StudentModel model, StudentGUI view){
        view.attachAddStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentIdFinal;
                String firstName = view.getFirstName();
                String lastName = view.getlastName();
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

                view.addStudentToList(student.toString());
                model.addStudent(new Student(firstName, lastName,studentIdFinal, email));
                view.clearForm();
            }
        });
        view.attachRemoveStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = view.getSelectedIndex();

                if(index > -1) {
                model.removeStudent(index);
                view.removeStudentToList(index);
                }
            }
        });
    }
}
