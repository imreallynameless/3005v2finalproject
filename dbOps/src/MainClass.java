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
                          logInFlag = false;
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
                      System.out.println("Weight in lbs: ");
                      int weight = scanner.nextInt();
                      scanner.nextLine();
                      System.out.println("Height in cm: ");
                      int height = scanner.nextInt();
                      scanner.nextLine();
                      dbOps.addMember(first_name, last_name, email, weight, height);
                      id = dbOps.getMemberByEmail(email);
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
                            System.out.println("4. exit");
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
                                scanner.nextLine();
                                int height = scanner.nextInt();
                                dbOps.updateHealthMetrics(id, weight, height);
                            }
                            else if (profileChoice == 4){
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
                            System.out.println("3. Register for Group Classes");
                            System.out.println("4. exit");
                            System.out.println("Enter your choice: ");
                            int scheduleChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (scheduleChoice == 1){
                                dbOps.viewSchedule(id);
                            }

                            else if (scheduleChoice == 2){
                                System.out.println("Enter trainer id: ");
                                int trainer_id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Enter session time: ");
                                String session_time = scanner.nextLine();
                                dbOps.schedulePersonalTraining(id, trainer_id, session_time);
                            }

                            else if (scheduleChoice == 3){
                                System.out.println("Enter exercise routine name: ");
                                String routine_name = scanner.nextLine();
                                dbOps.removeExerciseRoutine(id, routine_name);
                            }
                            else if (scheduleChoice == 4){
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
  
  
        //   else if (choice == 2){
        //       System.out.println("Enter first name: ");
        //       String first_name = scanner.nextLine();
        //       System.out.println("Enter last name: ");
        //       String last_name = scanner.nextLine();
        //       System.out.println("Enter email: ");
        //       String email = scanner.nextLine();
        //       System.out.println("Enter enrollment date: ");
        //       String enrollment_date = scanner.nextLine();
        //       dbOps.addStudent(first_name, last_name, email, enrollment_date);
        //   }
        //   else if (choice == 3){
        //       System.out.println("Enter student id: ");
        //       int student_id = scanner.nextInt();
        //       scanner.nextLine();
        //       System.out.println("Enter new email: ");
        //       String new_email = scanner.nextLine();
        //       dbOps.updateStudentEmail(student_id, new_email);
        //   }
        //   else if (choice == 4){
        //       System.out.println("Enter student id: ");
        //       int student_id = scanner.nextInt();
        //       dbOps.deleteStudent(student_id);
        //   }
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
