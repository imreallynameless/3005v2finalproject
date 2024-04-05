package dbOps.src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseOperations {

    private final String url = "jdbc:postgresql://localhost:5432/3005a3q1";
    private final String user = "postgres";
    private final String password = "postgres";

public void getAllStudents() {
    String SQL = "SELECT * FROM students";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            int studentId = rs.getInt("student_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String enrollmentDate = rs.getString("enrollment_date");

            System.out.println("Student ID: " + studentId);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Enrollment Date: " + enrollmentDate);
            System.out.println();
        }

        System.out.println("Students retrieved successfully!");

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


    // Add a user
    public void addStudent(String first_name, String last_name, String email, String enrollment_date) {
        String SQL = "INSERT INTO students(first_name, last_name, email, enrollment_date) VALUES(?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setDate(4, java.sql.Date.valueOf(enrollment_date));
            pstmt.executeUpdate();
            System.out.println("Student added successfully!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Update student's email based on ID
    public void updateStudentEmail(int student_id, String new_email){
        String SQL = "UPDATE students SET email=? WHERE student_id=?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, new_email);
            pstmt.setInt(2, student_id);
            pstmt.executeUpdate();
            System.out.println("Student email updated!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Delete student based on ID
    public void deleteStudent(int student_id) {
        String SQL = "DELETE FROM students WHERE student_id=?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, student_id);
            pstmt.executeUpdate();
            System.out.println("Student deleted!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
      DatabaseOperations dbOps = new DatabaseOperations();
      Scanner scanner = new Scanner(System.in);
      Boolean flag = true;
      while (flag){
        System.out.println("1. get all students");
        System.out.println("2. add a student");
        System.out.println("3. update student email");
        System.out.println("4. delete student");
        System.out.println("5. exit");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1){
            dbOps.getAllStudents();
        }
        else if (choice == 2){
            System.out.println("Enter first name: ");
            String first_name = scanner.nextLine();
            System.out.println("Enter last name: ");
            String last_name = scanner.nextLine();
            System.out.println("Enter email: ");
            String email = scanner.nextLine();
            System.out.println("Enter enrollment date: ");
            String enrollment_date = scanner.nextLine();
            dbOps.addStudent(first_name, last_name, email, enrollment_date);
        }
        else if (choice == 3){
            System.out.println("Enter student id: ");
            int student_id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter new email: ");
            String new_email = scanner.nextLine();
            dbOps.updateStudentEmail(student_id, new_email);
        }
        else if (choice == 4){
            System.out.println("Enter student id: ");
            int student_id = scanner.nextInt();
            dbOps.deleteStudent(student_id);
        }
        else if (choice == 5){
            flag = false;
        }
        else{
            System.out.println("Invalid choice");
        }
    }
      scanner.close();
  }
}