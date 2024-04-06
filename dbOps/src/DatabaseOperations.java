package dbOps.src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatabaseOperations {

    private final String url = "jdbc:postgresql://localhost:5432/3005test1";
    private final String user = "postgres";
    private final String password = "postgres";

    // ----------------- Members -----------------

    public int getMemberByEmail(String email){
        
        String SQL = "SELECT * FROM members WHERE member_email = ?";
        int memberId = 0;

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                memberId = rs.getInt("member_id");
                System.out.println("Member ID: " + memberId);
                System.out.println("Member retrieved successfully!");
                return memberId;
            }
            if (memberId == 0){
                return memberId;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return memberId;
    }

    public boolean memberCheckPassword(int member_id, String password){
        String SQL = "SELECT * FROM members WHERE member_id = ? AND password = ?";
        boolean valid = false;

        try (Connection conn = DriverManager.getConnection(url, user, this.password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, member_id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                valid = true;
                System.out.println("Password is correct!");
                return valid;
            }
            if (!valid){
                System.out.println("Password is incorrect!");
                return valid;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return valid;
    }

    public void getAllMembers() {
        String SQL = "SELECT * FROM members";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int memberId = rs.getInt("member_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                System.out.println("Member ID: " + memberId);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println();
            }

            System.out.println("Members retrieved successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateProfile(int member_id, String first_name, String last_name, String email) {
        String SQL = "UPDATE members SET first_name = ?, last_name = ?, member_email = ? WHERE member_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setInt(4, member_id);
            pstmt.executeUpdate();
            System.out.println("Profile updated successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateFitnessGoals(int member_id, String goal_name, String goal_description) {
        String SQL = "UPDATE fitness_goals SET goal_name = ?, goal_description = ? WHERE member_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, goal_name);
            pstmt.setString(2, goal_description);
            pstmt.setInt(3, member_id);
            pstmt.executeUpdate();
            System.out.println("Fitness goals updated successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateHealthMetrics(int member_id, int weight, int height){
        String SQL = "UPDATE health_metrics SET weight = ?, height = ? WHERE member_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, weight);
            pstmt.setInt(2, height);
            pstmt.setInt(3, member_id);

            pstmt.executeUpdate();
            System.out.println("Health metrics updated successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addMember(String first_name, String last_name, String member_email, String member_password, int weight, int height) {
        String SQL = "INSERT INTO members(member_email, member_password, first_name, last_name, outstanding_balance) VALUES(?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, member_email);
            pstmt.setString(2, member_password);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.setInt(4, 5);
            pstmt.executeUpdate();
            System.out.println("Member registered successfully!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        SQL = "INSERT INTO fitness_goals(member_id, goal_name, goal_description) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            int member_id = getMemberByEmail(member_email);
            pstmt.setInt(1, member_id);
            pstmt.setString(2, "No goal set");
            pstmt.setString(3, "No goal set");
            pstmt.executeUpdate();
            System.out.println("Fitness goals registered successfully!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        SQL = "INSERT INTO fitness_achievements(member_id, achievement_name, achievement_description) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            int member_id = getMemberByEmail(member_email);
            pstmt.setInt(1, member_id);
            pstmt.setString(2, "No achievement yet");
            pstmt.setString(3, "No achievement yet");
            pstmt.executeUpdate();
            System.out.println("Fitness achievements registered successfully!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        SQL = "INSERT INTO exercise_routines(member_id, routine_name, routine_description) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            int member_id = getMemberByEmail(member_email);
            pstmt.setInt(1, member_id);
            pstmt.setString(2, "No routine set");
            pstmt.setString(3, "No routine set");
            pstmt.executeUpdate();
            System.out.println("Exercise routines registered successfully!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        SQL = "INSERT INTO health_metrics(member_id, weight, height) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            int member_id = getMemberByEmail(member_email);
            pstmt.setInt(1, member_id);
            pstmt.setInt(2, weight);
            pstmt.setInt(3, height);
            pstmt.executeUpdate();
            System.out.println("Health metrics registered successfully!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void payBalance(int member_id, int amount) {
        String SQL = "UPDATE members SET outstanding_balance = outstanding_balance - ? WHERE member_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, amount);
            pstmt.setInt(2, member_id);
            pstmt.executeUpdate();
            System.out.println("Balance paid successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void viewExerciseRoutines(int member_id) {
        String SQL = "SELECT * FROM exercise_routines WHERE member_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, member_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String routine_name = rs.getString("routine_name");
                String routine_description = rs.getString("routine_description");

                System.out.println("Routine Name: " + routine_name);
                System.out.println("Routine Description: " + routine_description);
                System.out.println();
            }

            System.out.println("Exercise routines retrieved successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void viewFitnessAchievements(int member_id) {
        String SQL = "SELECT * FROM fitness_achievements WHERE member_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, member_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String achievement_name = rs.getString("achievement_name");
                String achievement_description = rs.getString("achievement_description");

                System.out.println("Achievement Name: " + achievement_name);
                System.out.println("Achievement Description: " + achievement_description);
                System.out.println();
            }

            System.out.println("Fitness achievements retrieved successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void viewHealthStatistics(int member_id) {
        String SQL = "SELECT * FROM health_metrics WHERE member_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, member_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int weight = rs.getInt("weight");
                int height = rs.getInt("height");

                System.out.println("Weight: " + weight);
                System.out.println("Height: " + height);
                System.out.println();
            }

            System.out.println("Health metrics retrieved successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void viewSchedule(int member_id) {
        String SQL = "SELECT gc.class_id, gc.class_name, gc.class_time " +
                     "FROM group_classes gc " +
                     "INNER JOIN class_members cm ON gc.class_id = cm.class_id " +
                     "WHERE cm.member_id = ?";
    
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
    
            pstmt.setInt(1, member_id);
            ResultSet rs = pstmt.executeQuery();
    
            while (rs.next()) {
                int class_id = rs.getInt("class_id");
                String class_name = rs.getString("class_name");
                Timestamp class_time = rs.getTimestamp("class_time");
    
                System.out.println("Class ID: " + class_id);
                System.out.println("Class Name: " + class_name);
                System.out.println("Class Time: " + class_time);
                System.out.println();
            }
    
            System.out.println("Classes retrieved successfully!");
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        SQL =   "SELECT pt.training_id, pt.training_time, t.first_name AS trainer_first_name, t.last_name AS trainer_last_name " +
                 "FROM personal_training pt " +
                 "INNER JOIN trainers t ON pt.trainer_id = t.trainer_id " +
                 "WHERE pt.member_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, member_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int training_id = rs.getInt("training_id");
                Timestamp training_time = rs.getTimestamp("training_time");
                String trainer_first_name = rs.getString("trainer_first_name");
                String trainer_last_name = rs.getString("trainer_last_name");

                System.out.println("Training ID: " + training_id);
                System.out.println("Training Time: " + training_time);
                System.out.println("Trainer: " + trainer_first_name + " " + trainer_last_name);
                System.out.println();
            }

            System.out.println("Training sessions retrieved successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void schedulePersonalTraining(int member_id, int trainer_id, String training_time) {
        String SQL = "INSERT INTO personal_training(member_id, trainer_id, training_time) VALUES(?,?,?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp session_time;
        try {
            session_time = new Timestamp(dateFormat.parse(training_time).getTime());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd HH:mm:ss");
            return; // Exit the method if the date format is invalid
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, member_id);
            pstmt.setInt(2, trainer_id);
            pstmt.setTimestamp(3, session_time);
            pstmt.executeUpdate();
            System.out.println("Personal training session scheduled successfully!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void reschedulePersonalTraining(int training_id, String training_time) {
        String SQL = "UPDATE personal_training SET training_time = ? WHERE training_id = ?";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp session_time;
        try {
            session_time = new Timestamp(dateFormat.parse(training_time).getTime());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd HH:mm:ss");
            return; // Exit the method if the date format is invalid
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setTimestamp(1, session_time);
            pstmt.setInt(2, training_id);
            pstmt.executeUpdate();
            System.out.println("Personal training session rescheduled successfully!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cancelPersonalTraining(int training_id) {
        String SQL = "DELETE FROM personal_training WHERE training_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, training_id);
            pstmt.executeUpdate();
            System.out.println("Personal training session cancelled successfully!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void getAvaliableTrainers(){
        String SQL = "SELECT * FROM trainers WHERE available = true";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery()) {

            if (!rs.next()){
                System.out.println("No trainers avaliable at the moment!");
                return;
            }
            
            while (rs.next()) {
                int trainer_id = rs.getInt("trainer_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");

                System.out.println("Trainer ID: " + trainer_id);
                System.out.println("First Name: " + first_name);
                System.out.println("Last Name: " + last_name);
                System.out.println();
            }

            System.out.println("Avaliable Trainers retrieved successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getAllClasses(){
        String SQL = "SELECT * FROM group_classes";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int class_id = rs.getInt("class_id");
                String class_name = rs.getString("class_name");
                Time class_time = rs.getTime("class_time");

                System.out.println("Class ID: " + class_id);
                System.out.println("Class Name: " + class_name);
                System.out.println("Class Time: " + class_time);
                System.out.println();
            }

            System.out.println("Classes retrieved successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void registerForClass(int member_id, int class_id) {
        String SQL = "INSERT INTO class_members(member_id, class_id) VALUES(?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, member_id);
            pstmt.setInt(2, class_id);
            pstmt.executeUpdate();
            System.out.println("Class Registered successfully!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }



    // ----------------- Trainers -----------------

    public int getTrainerByEmail(String email){
        
        String SQL = "SELECT * FROM trainers WHERE trainer_email = ?";
        int trainerId = 0;

        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                trainerId = rs.getInt("trainer_id");
                System.out.println("Trainer ID: " + trainerId);
                System.out.println("Trainer retrieved successfully!");
                return trainerId;
            }
            if (trainerId == 0){
                System.out.println("Trainer not found!");
                return trainerId;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return trainerId;
    }

    public boolean trainerCheckPassword(int trainer_id, String password){
        String SQL = "SELECT * FROM trainers WHERE trainer_id = ? AND password = ?";
        boolean valid = false;

        try (Connection conn = DriverManager.getConnection(url, user, this.password);
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, trainer_id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                valid = true;
                System.out.println("Password is correct!");
                return valid;
            }
            if (!valid){
                System.out.println("Password is incorrect!");
                return valid;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return valid;
    }

    public void viewTrainerSchedule(int trainer_id){
        
    }

    // ----------------- Administrators -----------------
}

