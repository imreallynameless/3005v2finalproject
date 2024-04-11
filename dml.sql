-- Inserting data into the members table
INSERT INTO members (member_email, member_password, first_name, last_name, outstanding_balance)
VALUES 
    ('john@example.com', 'password123', 'John', 'Doe', 50),
    ('jane@example.com', 'password456', 'Jane', 'Smith', 75),
    ('alice@example.com', 'password789', 'Alice', 'Johnson', 0);

-- Inserting data into the fitness_goals table
INSERT INTO fitness_goals (member_id, goal_name, goal_description)
VALUES 
    (1, 'Weight Loss', 'Lose 10 pounds in 2 months'),
    (2, 'Muscle Gain', 'Gain 5 pounds of muscle mass in 3 months'),
    (3, 'Endurance Improvement', 'Run a 10k race without stopping');

-- Inserting data into the fitness_achievements table
INSERT INTO fitness_achievements (member_id, achievement_name, achievement_description)
VALUES 
    (1, 'Completed 5k Run', 'Ran a 5k race in under 30 minutes'),
    (2, 'Squatted 200 lbs', 'Achieved a personal best squat of 200 lbs'),
    (3, 'Completed Marathon', 'Completed a full marathon in under 4 hours');

-- Inserting data into the exercise_routines table
INSERT INTO exercise_routines (member_id, routine_name, routine_description)
VALUES 
    (1, 'Morning Workout', '30 minutes of cardio followed by weightlifting'),
    (2, 'Full Body Workout', 'Targeting all muscle groups with compound exercises'),
    (3, 'Running Routine', 'Interval training to improve endurance and speed');

-- Inserting data into the health_statistics table
INSERT INTO health_statistics (member_id, weight, height)
VALUES 
    (1, 180, 170),
    (2, 160, 165),
    (3, 150, 162);

-- Inserting data into the trainers table
INSERT INTO trainers (trainer_email, trainer_password, first_name, last_name)
VALUES 
    ('trainer1@example.com', 'trainerpass1', 'Mike', 'Johnson'),
    ('trainer2@example.com', 'trainerpass2', 'Sarah', 'Smith'),
    ('trainer3@example.com', 'trainerpass3', 'David', 'Brown');

-- Inserting data into the administrators table
INSERT INTO administrators (admin_email, admin_password, first_name, last_name)
VALUES 
    ('admin1@example.com', 'adminpass1', 'Admin', 'User1'),
    ('admin2@example.com', 'adminpass2', 'Admin', 'User2');

-- Inserting data into the group_classes table
INSERT INTO group_classes (class_name, class_time)
VALUES 
    ('Yoga Class', '2024-04-10 08:00:00'),
    ('Pilates Class', '2024-04-11 09:00:00'),
    ('Spin Class', '2024-04-12 18:00:00');

-- Inserting data into the class_members table
INSERT INTO class_members (class_id, member_id, trainer_id)
VALUES 
    (1, 1, 1),
    (1, 2, 1),
    (1, 3, 1),
    (2, 2, 2),
    (3, 3, 3);

-- Inserting data into the personal_training table
INSERT INTO personal_training (member_id, trainer_id, training_time)
VALUES 
    (1, 1, '2024-04-10 10:00:00'),
    (2, 2, '2024-04-11 11:00:00'),
    (3, 3, '2024-04-12 12:00:00'),
    (NULL, 1 , '2024-04-11 10:00:00'),
    (NULL, 2 , '2024-04-12 11:00:00'),
    (NULL, 3 , '2024-04-13 12:00:00');

-- Inserting data into the equipment table
INSERT INTO equipment (equipment_name, equipment_broken, maintenance_time)
VALUES 
    ('Treadmill', false, NULL),
    ('Dumbbells', false, NULL),
    ('Exercise Bike', true, '2024-04-05 14:00:00');

-- Inserting data into the room table
INSERT INTO room (room_name)
VALUES 
    ('Studio A'),
    ('Studio B'),
    ('Weight Room');

-- Inserting data into the room_bookings table
INSERT INTO room_bookings (room_id, member_id, booking_time)
VALUES 
    (1, 1, '2024-04-10 10:00:00'),
    (2, 2, '2024-04-11 11:00:00'),
    (3, 3, '2024-04-12 12:00:00');
