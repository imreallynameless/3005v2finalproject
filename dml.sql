-- Inserting data into the members table
INSERT INTO members (member_email, member_password, first_name, last_name, outstanding_balance) 
VALUES ('john@example.com', 'password123', 'John', 'Doe', 0),
       ('alice@example.com', 'alicepass', 'Alice', 'Smith', 0),
       ('bob@example.com', 'bobpassword', 'Bob', 'Johnson', 50);

-- Inserting data into the fitness_goals table
INSERT INTO fitness_goals (member_id, goal_name, goal_description) 
VALUES (1, 'Weight Loss', 'Lose 10 pounds in 2 months'),
       (2, 'Muscle Gain', 'Gain 5 pounds of muscle mass'),
       (3, 'Endurance', 'Run a marathon in under 4 hours');

-- Inserting data into the fitness_achievements table
INSERT INTO fitness_achievements (member_id, achievement_name, achievement_description) 
VALUES (1, 'Ran 5K', 'Completed a 5K run in 30 minutes'),
       (2, 'Deadlift Personal Best', 'Achieved a personal best of 250 lbs deadlift'),
       (3, 'Improved Marathon Time', 'Completed a marathon in 3 hours 45 minutes');

-- Inserting data into the exercise_routines table
INSERT INTO exercise_routines (member_id, routine_name, routine_description) 
VALUES (1, 'Cardio Routine', '30 minutes of running, 20 minutes of cycling'),
       (2, 'Strength Training', '3 sets of bench press, 3 sets of squats'),
       (3, 'Marathon Training', 'Long distance running, increasing mileage weekly');

-- Inserting data into the health_statistics table
INSERT INTO health_statistics (member_id, weight, height) 
VALUES (1, 180, 70),
       (2, 160, 65),
       (3, 150, 72);

-- Inserting data into the trainers table
INSERT INTO trainers (trainer_email, trainer_password, first_name, last_name, avaliable) 
VALUES ('trainer1@example.com', 'trainerpass', 'Trainer', 'One', true),
       ('trainer2@example.com', 'trainerpass2', 'Trainer', 'Two', false),
       ('trainer3@example.com', 'trainerpass3', 'Trainer', 'Three', true);

-- Inserting data into the administrators table
INSERT INTO administrators (admin_email, admin_password, first_name, last_name) 
VALUES ('admin@example.com', 'adminpass', 'Admin', 'Smith'),
       ('admin2@example.com', 'adminpass2', 'Admin', 'Doe');

-- Inserting data into the group_classes table
INSERT INTO group_classes (class_name, class_time) 
VALUES ('Yoga Class', '2024-04-10 09:00:00'),
       ('Spin Class', '2024-04-11 18:00:00'),
       ('Zumba Class', '2024-04-12 17:30:00');

-- Inserting data into the class_members table
INSERT INTO class_members (class_id, member_id, trainer_id) 
VALUES (1, 1, 1),
       (2, 2, 2),
       (3, 3, 3);

-- Inserting data into the personal_training table
INSERT INTO personal_training (member_id, trainer_id, training_time) 
VALUES (1, 1, '2024-04-13 10:00:00'),
       (2, 2, '2024-04-14 15:00:00'),
       (3, 3, '2024-04-15 16:00:00');

-- Inserting data into the equipment table
INSERT INTO equipment (equipment_name, equipment_broken, maintenance_time) 
VALUES ('Treadmill', false, null),
       ('Dumbbells', false, null),
       ('Exercise Bike', true, '2024-04-09 08:00:00');

-- Inserting data into the room table
INSERT INTO room (room_name) 
VALUES ('Room 1'),
       ('Room 2'),
       ('Room 3');

-- Inserting data into the room_bookings table
INSERT INTO room_bookings (room_id, member_id, booking_time) 
VALUES (1, 1, '2024-04-10 09:00:00'),
       (2, 2, '2024-04-11 18:00:00'),
       (3, 3, '2024-04-12 17:30:00');
