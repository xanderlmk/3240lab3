import Controllers.StudentController;
import Models.StudentModel;
import Views.StudentGUI;

import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentApp {
    public static void main(String[] args) {
        if (checkDrivers()) {
            StudentGUI view = new StudentGUI();
            StudentModel model = new StudentModel();
            new StudentController(model, view);
            view.setVisible(true);
        }
    }

    private static boolean checkDrivers(){
        try{
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new org.sqlite.JDBC());
            return true;
        }
        catch (ClassNotFoundException |SQLException classNotFoundException)
        {
            System.out.println("Could not start SQLite Drivers");
            return false;
        }
    }
}
