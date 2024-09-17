package Views;

import javax.swing.*;
import java.awt.event.ActionListener;


public class StudentGUI extends JFrame{
    private JPanel panel;
    private DefaultListModel<String> studentListModel;
    private JList<String> studentList;
    private JTextField inputFirstName;
    private JTextField inputLastName;
    private JTextField inputStudentID;
    private JLabel labelFirstName;
    private JLabel labelLastName;
    private JLabel labelStudentID;
    private JPanel studentInput;
    private JPanel studentAction;
    private JButton buttonAddStudent;
    private JButton buttonRemoveStudent;

    public StudentGUI(){
        setContentPane(panel);
        setTitle("Student App");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentListModel = new DefaultListModel<>();
    }

    public void attachAddStudentListener(ActionListener listener) {
        buttonAddStudent.addActionListener(listener);
    }
    public void attachRemoveStudentListener(ActionListener listener){
        buttonRemoveStudent.addActionListener(listener);
    }

    public void clearForm() {
        inputFirstName.setText("");
        inputLastName.setText("");
        inputStudentID.setText("");
    }
    public String getFirstName() {
        return inputFirstName.getText();
    }
    public String lastName() {
        return inputLastName.getText();
    }
    public String getStudentId(){
        return inputStudentID.getText();
    }
    public int getSelectedIndex() {
        return studentList.getSelectedIndex();
    }


    public void addStudentToList(String student) {
        studentListModel.addElement(student) ;
        studentList.setModel(studentListModel);
    }
    public void removeStudentToList(int index) {
        if(index > -1){
            studentListModel.remove(index);
            studentList.setModel(studentListModel);
        }
    }
}
