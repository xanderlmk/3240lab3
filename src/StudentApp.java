import Controllers.StudentController;
import Models.StudentModel;
import Views.StudentGUI;

public class StudentApp {
    public static void main(String[] args) {
        StudentGUI view = new StudentGUI();
        StudentModel model = new StudentModel();
        new StudentController(model, view);
        view.setVisible(true);
    }
}
