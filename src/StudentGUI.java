import javax.swing.*;
import java.awt.event.ActionEvent;
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
        buttonAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = inputFirstName.getText();
                String lastName = inputLastName.getText();
                String studentID = inputStudentID.getText();

                    if(firstName.isBlank() || lastName.isBlank() || studentID.isBlank()){
                        return;
                    }
                    String element = String.format("%s %s %s", firstName, lastName, studentID);
                    studentListModel.addElement(element);
                    studentList.setModel(studentListModel);
                    inputFirstName.setText("");
                    inputLastName.setText("");
                    inputStudentID.setText("");
                }
        });


        buttonRemoveStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentIndex = studentList.getSelectedIndex();
                if(studentIndex > -1){
                    studentListModel.remove(studentIndex);
                    studentList.setModel(studentListModel);
                }


            }
        });
    }
}
