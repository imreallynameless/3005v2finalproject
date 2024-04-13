package dbOps.src;
import java.util.Scanner;


public class MainClass {
    public static void main(String[] args) {
        DatabaseOperations dbOps = new DatabaseOperations();
        Scanner scanner = new Scanner(System.in);
        Boolean flag = true;
        while (flag){
            System.out.println("Welcome to the Health and Fitness Club Management System");
            System.out.println("Please select an option below:");
            System.out.println("1. I'm a member");
            System.out.println("2. I'm a trainer");
            System.out.println("3. I'm an administator");
            System.out.println("4. exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            if (choice == 1){
                Boolean logInFlag = true;
                Boolean memberFlag = true;
                int id = 0;
                while (logInFlag){
                    System.out.println("Welcome to the Member Portal");
                    System.out.println("Please select an option below:");
                    System.out.println("1. Log in");
                    System.out.println("2. Sign up");
                    System.out.println("3. exit");
                    System.out.println("Enter your choice: ");
                    int logInChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (logInChoice == 1){
                        System.out.println("Enter your email: ");
                        String email = scanner.nextLine();
                        id = dbOps.getMemberByEmail(email);
                        if (id != 0){
                            System.out.println("Enter your password: ");
                            String password = scanner.nextLine();
                                if (dbOps.memberCheckPassword(id, password)){
                                    logInFlag = false;
                                }
                                else{
                                }
                        }
                        else {
                            System.out.println("Member not found!");
                        }
                    }
                    else if (logInChoice == 2){
                        System.out.println("Enter first name: ");
                        String first_name = scanner.nextLine();
                        System.out.println("Enter last name: ");
                        String last_name = scanner.nextLine();
                        System.out.println("Enter email: ");
                        String email = scanner.nextLine();
                        System.out.println("Enter password: ");
                        String password = scanner.nextLine();
                        System.out.println("Weight in lbs: ");
                        int weight = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Height in cm: ");
                        int height = scanner.nextInt();
                        scanner.nextLine();
                        dbOps.addMember(first_name, last_name, email, password, weight, height);
                        id = dbOps.getMemberByEmail(email);
                        System.out.println("Register for a session to get started!");
                        dbOps.getAvailableSessions();
                        System.out.println("Enter session id (or 0 to skip booking a session): ");
                        int session_id = scanner.nextInt();
                        scanner.nextLine();
                        if (session_id != 0){
                            dbOps.registerForSession(id, session_id);
                        }
                        System.out.println("Your outstanding balance is $5. Please ask an admin to pay it off.");
                        logInFlag = false;
                    }
                    else if (logInChoice == 3){
                        logInFlag = false;
                        memberFlag = false;
                    }
                    else{
                        System.out.println("Invalid choice");
                    }
                    }
    
                while (memberFlag){
                    System.out.println("Welcome to the Member Portal");
                    System.out.println("Please select an option below:");
                    System.out.println("1. Profile Management");
                    System.out.println("2. Dashboard Display");
                    System.out.println("3. Schedule Mangagement");
                    System.out.println("4. exit");
                    System.out.println("Enter your choice: ");
                    int memberChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (memberChoice == 1){
                            boolean profileFlag = true;
                            while (profileFlag){
                                System.out.println("Welcome to the Profile Management");
                                System.out.println("Please select an option below:");
                                System.out.println("1. Update Personal Information");
                                System.out.println("2. Update Fitness Goals");
                                System.out.println("3. Update Health Metrics");
                                System.out.println("4. View Profile");
                                System.out.println("5. exit");
                                System.out.println("Enter your choice: ");
                                int profileChoice = scanner.nextInt();
                                scanner.nextLine();

                                if (profileChoice == 1){
                                    System.out.println("Enter new first name: ");
                                    String first_name = scanner.nextLine();
                                    System.out.println("Enter new last name: ");
                                    String last_name = scanner.nextLine();
                                    System.out.println("Enter new email: ");
                                    String email = scanner.nextLine();
                                    dbOps.updateProfile(id, first_name, last_name, email);
                                }

                                else if (profileChoice == 2){
                                    System.out.println("Enter new fitness goal: ");
                                    String goal_name = scanner.nextLine();
                                    System.out.println("Enter new fitness goal description: ");
                                    String goal_description = scanner.nextLine();
                                    dbOps.updateFitnessGoals(id, goal_name, goal_description);
                                }

                                else if (profileChoice == 3){
                                    System.out.println("Enter new weight in lbs: ");
                                    int weight = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter new height in cm: ");
                                    int height = scanner.nextInt();
                                    scanner.nextLine();
                                    dbOps.updateHealthStatistics(id, weight, height);
                                }
                                    
                                else if (profileChoice == 4){
                                        dbOps.viewMemberProfile(id);
                                }
                                else if (profileChoice == 5){
                                    profileFlag = false;
                                }
                                else{
                                    System.out.println("Invalid choice");
                                }
                            }
                        }
                    else if (memberChoice == 2){
                            System.out.println("Welcome to the Dashboard Display");
                            boolean dashboardFlag = true;
                            while (dashboardFlag){
                                System.out.println("Please select an option below:");
                                System.out.println("1. Display Exercise Routines");
                                System.out.println("2. View Fitness Achievements");
                                System.out.println("3. View Health Statistics");
                                System.out.println("4. exit");
                                System.out.println("Enter your choice: ");
                                int dashboardChoice = scanner.nextInt();
                                scanner.nextLine();

                                if (dashboardChoice == 1){
                                    dbOps.viewExerciseRoutines(id);
                                }

                                else if (dashboardChoice == 2){
                                    dbOps.viewFitnessAchievements(id);
                                }

                                else if (dashboardChoice == 3){
                                    dbOps.viewHealthStatistics(id);
                                }
                                else if (dashboardChoice == 4){
                                    dashboardFlag = false;
                                }
                                else{
                                    System.out.println("Invalid choice");
                                }
                            }
                    }
                    else if (memberChoice == 3){
                            System.out.println("Welcome to the Schedule Management");
                            boolean scheduleFlag = true;
                            while (scheduleFlag){
                                System.out.println("Please select an option below:");
                                System.out.println("1. View Schedule");
                                System.out.println("2. Schedule Personal Training Session");
                                System.out.println("3. Reschedule Personal Training Session");
                                System.out.println("4. Cancel Personal Training Session");
                                System.out.println("5. Register for Group Classes");
                                System.out.println("6. Cancel Group Classes");
                                System.out.println("7. exit");
                                System.out.println("Enter your choice: ");
                                int scheduleChoice = scanner.nextInt();
                                scanner.nextLine();

                                if (scheduleChoice == 1){
                                    dbOps.viewSchedule(id);
                                }

                                else if (scheduleChoice == 2){
                                    dbOps.getAvailableSessions();
                                    System.out.println("Enter session id: ");
                                    int session_id = scanner.nextInt();
                                    scanner.nextLine();
                                    dbOps.registerForSession(id, session_id);
                                }

                                else if (scheduleChoice == 3){
                                    dbOps.viewSchedule(id);
                                    System.out.println("Enter Training id: ");
                                    int session_id = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Enter new session time (in format yyyy-MM-dd HH:mm:ss): ");
                                    String new_session_time = scanner.nextLine();
                                    dbOps.reschedulePersonalTraining(session_id, new_session_time);
                                }

                                else if (scheduleChoice == 4){
                                    dbOps.viewSchedule(id);
                                    System.out.println("Enter session id: ");
                                    int session_id = scanner.nextInt();
                                    scanner.nextLine();
                                    dbOps.cancelPersonalTraining(session_id);
                                }

                                else if (scheduleChoice == 5){
                                    dbOps.getAllClasses();
                                    System.out.println("Enter class id: ");
                                    int class_id = scanner.nextInt();
                                    scanner.nextLine();
                                    dbOps.registerForClass(id, class_id);
                                }
                                else if (scheduleChoice == 6){
                                    dbOps.viewSchedule(id);
                                    System.out.println("Enter class id: ");
                                    int class_id = scanner.nextInt();
                                    scanner.nextLine();
                                    dbOps.cancelClass(id, class_id);
                                }
                                else if (scheduleChoice == 7){
                                    scheduleFlag = false;
                                }
                                else{
                                    System.out.println("Invalid choice");
                                }
                            }
                    }
                    else if (memberChoice == 4){
                        memberFlag = false;
                    }
                    else{
                        System.out.println("Invalid choice");
                    }
                }
                }
    
    
            else if (choice == 2){
                Boolean logInFlag = true;
                Boolean trainerFlag = true;
                int id = 0;
                while (logInFlag){
                    System.out.println("Welcome to the Trainer Portal");
                    System.out.println("Please select an option below:");
                    System.out.println("1. Log in");
                    System.out.println("2. exit");
                    System.out.println("Enter your choice: ");
                    int logInChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (logInChoice == 1){
                        System.out.println("Enter your email: ");
                        String email = scanner.nextLine();
                        id = dbOps.getTrainerByEmail(email);
                        if (id != 0){
                            System.out.println("Enter your password: ");
                            String password = scanner.nextLine();
                                if (dbOps.trainerCheckPassword(id, password)){
                                    logInFlag = false;
                                }
                                else{
                                }
                        }
                        else {
                            System.out.println("Trainer not found!");
                        }
                    }
                    else if (logInChoice == 2){
                        logInFlag = false;
                        trainerFlag = false;
                    }
                    else{
                        System.out.println("Invalid choice");
                    }
                }
    
                while (trainerFlag){
                    System.out.println("Welcome to the Trainer Portal");
                    System.out.println("Please select an option below:");
                    System.out.println("1. Schedule Management");
                    System.out.println("2. Member Profile Viewing");
                    System.out.println("3. exit");
                    System.out.println("Enter your choice: ");
                    int trainerChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (trainerChoice == 1){
                        System.out.println("Welcome to the Schedule Management");
                        boolean scheduleFlag = true;
                        while (scheduleFlag){
                            System.out.println("Please select an option below:");
                            System.out.println("1. View Schedule");
                            System.out.println("2. Set Availability");
                            System.out.println("3. Reschedule Personal Training Session");
                            System.out.println("4. Cancel Personal Training Session");
                            System.out.println("5. exit");
                            System.out.println("Enter your choice: ");
                            int scheduleChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (scheduleChoice == 1){
                                dbOps.viewTrainerSchedule(id);
                            }
                            else if (scheduleChoice == 2){
                                System.out.println("Enter times of which you are available (in format yyyy-MM-dd HH:mm:ss): ");
                                String session_time = scanner.nextLine();
                                dbOps.schedulePersonalTraining (id, session_time);
                            }

                            else if (scheduleChoice == 3){
                                dbOps.viewTrainerSchedule(id);
                                System.out.println("Enter session id: ");
                                int session_id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Enter new session time (in format yyyy-MM-dd HH:mm:ss): ");
                                String new_session_time = scanner.nextLine();
                                dbOps.reschedulePersonalTraining(session_id, new_session_time);
                            }

                            else if (scheduleChoice == 4){
                                dbOps.viewTrainerSchedule(id);
                                System.out.println("Enter Training Session id: ");
                                int session_id = scanner.nextInt();
                                scanner.nextLine();
                                dbOps.cancelSession(session_id);
                            }
                            else if (scheduleChoice == 5){
                                scheduleFlag = false;
                            }
                            else{
                                System.out.println("Invalid choice");
                            }
                        }
                    }

                    else if (trainerChoice == 2){
                        System.out.println("Welcome to the Member Profile Viewing");
                        boolean profileFlag = true;
                        while (profileFlag){
                            System.out.println("Please select an option below:");
                            System.out.println("1. View Member Profile");
                            System.out.println("2. exit");
                            System.out.println("Enter your choice: ");
                            int profileChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (profileChoice == 1){
                                System.out.println("Enter last name of member: ");
                                String last_name = scanner.nextLine();
                                System.out.println("Enter first name of member: ");
                                String first_name = scanner.nextLine();
                                dbOps.viewMemberProfile(last_name, first_name);
                                System.out.println("Select member id to view profile (or 0 to exit): ");
                                int member_id = scanner.nextInt();
                                scanner.nextLine();
                                if (member_id != 0){
                                    dbOps.viewMemberProfile(member_id);
                                }
                            }
                            else if (profileChoice == 2){
                                profileFlag = false;
                            }
                            else{
                                System.out.println("Invalid choice");
                            }
                        }
                    }    
                    else if (trainerChoice == 3){
                        trainerFlag = false;
                    }
                    else{
                        System.out.println("Invalid choice");
                    }   
                }
            }
            else if (choice == 3){
                Boolean logInFlag = true;
                Boolean adminFlag = true;
                int id = 0;
                while (logInFlag){
                    System.out.println("Welcome to the Administrator Portal");
                    System.out.println("Please select an option below:");
                    System.out.println("1. Log in");
                    System.out.println("2. exit");
                    System.out.println("Enter your choice: ");
                    int logInChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (logInChoice == 1){
                        System.out.println("Enter your email: ");
                        String email = scanner.nextLine();
                        id = dbOps.getAdminByEmail(email);
                        if (id != 0){
                            System.out.println("Enter your password: ");
                            String password = scanner.nextLine();
                                if (dbOps.adminCheckPassword(id, password)){
                                    logInFlag = false;
                                }
                                else{
                                }
                        }
                        else {
                            System.out.println("Admin not found!");
                        }
                    }
                    else if (logInChoice == 2){
                        logInFlag = false;
                        adminFlag = false;
                    }
                    else{
                        System.out.println("Invalid choice");
                    }
                }
    
                while (adminFlag){
                    System.out.println("Welcome to the Administrator Portal");
                    System.out.println("Please select an option below:");
                    System.out.println("1. Room Booking Management");
                    System.out.println("2. Equipment Maintenance Management");
                    System.out.println("3. Class Management");
                    System.out.println("4. Payment Processing Management");
                    System.out.println("5. exit");
                    System.out.println("Enter your choice: ");
                    int adminChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (adminChoice == 1){
                        System.out.println("Welcome to the Room Booking Management");
                        boolean roomBookingFlag = true;
                        while (roomBookingFlag){
                            System.out.println("Please select an option below:");
                            System.out.println("1. View Room Bookings");
                            System.out.println("2. Book Room");
                            System.out.println("3. Reschedule Room Booking");
                            System.out.println("4. Cancel Room Booking");
                            System.out.println("5. exit");
                            System.out.println("Enter your choice: ");
                            int roomChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (roomChoice == 1){
                                dbOps.viewRoomBookings();
                            }
                            else if (roomChoice == 2){
                                dbOps.viewRooms();
                                System.out.println("Enter room id: ");
                                int room_id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Enter Event name: ");
                                String event_name = scanner.nextLine();
                                System.out.println("Enter Event time (in format yyyy-MM-dd HH:mm:ss): ");
                                String booking_time = scanner.nextLine();
                                dbOps.bookRoom(room_id, event_name, booking_time, id);
                            }
                            else if (roomChoice == 3){
                                dbOps.viewRoomBookings();
                                System.out.println("Enter booking id: ");
                                int booking_id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Enter new booking time (in format yyyy-MM-dd HH:mm:ss): ");
                                String new_booking_time = scanner.nextLine();
                                dbOps.rescheduleRoomBooking(booking_id, new_booking_time);
                            }
                            else if (roomChoice == 4){
                                dbOps.viewRoomBookings();
                                System.out.println("Enter booking id: ");
                                int booking_id = scanner.nextInt();
                                scanner.nextLine();
                                dbOps.cancelRoomBooking(booking_id);
                            }
                            else if (roomChoice == 5){
                                roomBookingFlag = false;
                            }
                            else{
                                System.out.println("Invalid choice");
                            }
                        }
                    }
                    else if (adminChoice == 2){
                        System.out.println("Welcome to the Equipment Maintenance Management");
                        boolean equipmentFlag = true;
                        while (equipmentFlag){
                            System.out.println("Please select an option below:");
                            System.out.println("1. View Equipment Maintenance Schedule");
                            System.out.println("2. Schedule Equipment Maintenance");
                            System.out.println("3. exit");
                            System.out.println("Enter your choice: ");
                            int equipmentChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (equipmentChoice == 1){
                                dbOps.viewEquipmentMaintenance();
                            }
                            else if (equipmentChoice == 2){
                                dbOps.viewAllEquipment();
                                System.out.println("Enter equipment id: ");
                                int equipment_id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Enter maintenance time (in format yyyy-MM-dd HH:mm:ss): ");
                                String maintenance_time = scanner.nextLine();
                                dbOps.scheduleEquipmentMaintenance(equipment_id, maintenance_time, id);
                            }
                            else if (equipmentChoice == 3){
                                equipmentFlag = false;
                            }
                            else{
                                System.out.println("Invalid choice");
                            }
                        }
                    }
                    else if (adminChoice == 3){
                        System.out.println("Welcome to the Class Management");
                        boolean classFlag = true;
                        while (classFlag){
                            System.out.println("Please select an option below:");
                            System.out.println("1. View Classes");
                            System.out.println("2. Update Class Schedule");
                            System.out.println("3. Schedule New Class");
                            System.out.println("4. Cancel Class");
                            System.out.println("5. exit");
                            System.out.println("Enter your choice: ");
                            int classChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (classChoice == 1){
                                dbOps.viewClasses();
                            }
                            else if (classChoice == 2){
                                dbOps.viewClasses();
                                System.out.println("Enter class id: ");
                                int class_id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Enter new class time (in format yyyy-MM-dd HH:mm:ss): ");
                                String class_time = scanner.nextLine();
                                dbOps.updateClassSchedule(class_id, class_time);
                            }
                            else if (classChoice == 3){
                                System.out.println("Enter class name: ");
                                String class_name = scanner.nextLine();
                                System.out.println("Enter class time (in format yyyy-MM-dd HH:mm:ss): ");
                                String class_time = scanner.nextLine();
                                dbOps.scheduleClass(id, class_name, class_time);
                            }
                            else if (classChoice == 4){
                                dbOps.viewClasses();
                                System.out.println("Enter class id: ");
                                int class_id = scanner.nextInt();
                                scanner.nextLine();
                                dbOps.cancelClass(class_id);
                            }
                            else if (classChoice == 5){
                                classFlag = false;
                            }
                            else{
                                System.out.println("Invalid choice");
                            }

                        }
                    }
                    else if (adminChoice == 4){
                        System.out.println("Welcome to the Payment Processing Management");
                        boolean paymentFlag = true;
                        while (paymentFlag){
                            System.out.println("Please select an option below:");
                            System.out.println("1. View Balances");
                            System.out.println("2. Process Payment");
                            System.out.println("3. Bill Member");
                            System.out.println("4. View Transactions");
                            System.out.println("5. exit");
                            System.out.println("Enter your choice: ");
                            int paymentChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (paymentChoice == 1){
                                dbOps.viewBalances();
                            }
                            else if (paymentChoice == 2){
                                dbOps.viewBalances();
                                System.out.println("Enter member email: ");
                                String email = scanner.nextLine();
                                int member_id = dbOps.getMemberByEmail(email);
                                System.out.println("Enter amount to pay: ");
                                int amount = scanner.nextInt();
                                scanner.nextLine();
                                dbOps.payBalance(id, member_id, amount);
                            }
                            else if (paymentChoice == 3){
                                dbOps.viewBalances();
                                System.out.println("Enter member email: ");
                                String email = scanner.nextLine();
                                int member_id = dbOps.getMemberByEmail(email);
                                System.out.println("Enter amount to bill: ");
                                int amount = scanner.nextInt();
                                scanner.nextLine();
                                dbOps.billMember(id, member_id, amount);
                            }
                            else if (paymentChoice == 4){
                                dbOps.viewTransactions();
                            }
                            else if (paymentChoice == 5){
                                paymentFlag = false;
                            }
                            else{
                                System.out.println("Invalid choice");
                            }
                        }
                    }
                    else if (adminChoice == 5){
                        adminFlag = false;
                    }
                    else{
                        System.out.println("Invalid choice");
                    
                    }
                }
            }
            else if (choice == 4){
                flag = false;
            }
            else{
                System.out.println("Invalid choice");
            }
      }
        scanner.close();
    }
}
