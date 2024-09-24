package Models;

import com.sun.jdi.ArrayReference;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    private final String db = "jdbc:sqlite:sqlite.db";
    public StudentModel() {
        try (Connection conn = DriverManager.getConnection(db)) {
        Statement stmt = conn.createStatement();
        stmt.execute("""
                CREATE TABLE IF NOT EXISTS Student(
                    firstName TEXT,
                    lastName TEXT,
                    studentEmail TEXT,
                    studentId INT UNIQUE
                )
                """);
        stmt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public boolean addStudent(Student student) {
        boolean success;
        try (Connection conn = DriverManager.getConnection(db)) {
            PreparedStatement ps = conn.prepareStatement("""
                    INSERT INTO Student 
                    (firstName, lastName, studentId, studentEmail)
                    VALUES(?, ?, ?, ?)
                    """);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setInt(3, student.getStudentId());
            ps.setString(4, student.getStudentEmail());

            ps.execute();
            ps.close();
            success = true;
        }catch (Exception e) {
            System.err.println(e.getMessage());
            success = false;
        }
        return success;
    }
    public void removeStudent(int studentId) {
        try (Connection conn = DriverManager.getConnection(db)){
            PreparedStatement ps = conn.prepareStatement("""
                    DELETE FROM Student WHERE studentId = ?
                    """);
            ps.setInt(1, studentId);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = null;
        try (Connection conn = DriverManager.getConnection(db)) {
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery("SELECT * FROM STUDENT");

            students = new ArrayList<>();
            while (set.next()) {
                Student s = new Student(
                        set.getString("firstName"),
                        set.getString("lastName"),
                        set.getInt("studentId"),
                        set.getString("studentEmail")
                );
                students.add(s);
            }
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
         return students;
    }
}
