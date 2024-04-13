-- Inserting into the members table
INSERT INTO members (member_email, member_password, first_name, last_name, outstanding_balance) 
VALUES 
    ('john@example.com', 'pass123', 'John', 'Doe', 0),
    ('jane@example.com', 'pass456', 'Jane', 'Smith', 25),
    ('mike@example.com', 'pass789', 'Mike', 'Johnson', 10);

-- Inserting into the fitness_goals table
INSERT INTO fitness_goals (member_id, goal_name, goal_description) 
VALUES 
    (1, 'Lose Weight', 'Goal is to lose 10 pounds in 2 months.'),
    (2, 'Build Muscle', 'Goal is to gain 5 pounds of muscle mass.'),
    (3, 'Improve Flexibility', 'Goal is to touch toes without bending knees.');

-- Inserting into the exercise_routines table
INSERT INTO exercise_routines (member_id, routine_name, routine_description) 
VALUES 
    (1, 'Cardio Routine', '30 minutes of running, 20 minutes of cycling.'),
    (2, 'Strength Training', 'Work on upper body strength using dumbbells and barbells.'),
    (3, 'Yoga Routine', 'Practice various yoga poses for flexibility and relaxation.');

-- Inserting into the health_statistics table
INSERT INTO health_statistics (member_id, weight, height) 
VALUES 
    (1, 160, 170),
    (2, 180, 172),
    (3, 150, 165);

-- Inserting into the trainers table
INSERT INTO trainers (trainer_email, trainer_password, first_name, last_name) 
VALUES 
    ('david@gym.com', 'pass123', 'David', 'Brown'),
    ('emily@gym.com', 'pass456', 'Emily', 'Wilson'),
    ('taylor@gym.com', 'pass789', 'Michael', 'Taylor');

-- Inserting into the personal_training table
INSERT INTO personal_training (member_id, trainer_id, training_time) 
VALUES 
    (1, 1, '2024-04-13 10:00:00'),
    (2, 2, '2024-04-13 11:00:00'),
    (3, 3, '2024-04-13 12:00:00'),
    (NULL, 1 , '2024-04-13 11:00:00'),
    (NULL, 2 , '2024-04-13 12:00:00'),
    (NULL, 3 , '2024-04-13 13:00:00');


-- Inserting into the equipment table
INSERT INTO equipment (equipment_name, equipment_broken) 
VALUES 
    ('Treadmill', true),
    ('Dumbbells', false),
    ('Yoga Mats', false);

-- Inserting into the room table
INSERT INTO room (room_name, room_capacity) 
VALUES 
    ('Gym Room A', 30),
    ('Studio Room B', 20),
    ('Yoga Room C', 15);

-- Inserting into the administrators table
INSERT INTO administrators (admin_email, admin_password, first_name, last_name) 
VALUES 
    ('larry@gym.com', 'adminpass123', 'Larry', 'Bird'),
    ('victor@gym.com', 'adminpass456', 'Victor', 'Lai');

-- Inserting into the group_classes table
INSERT INTO group_classes (admin_id, class_name, class_time) 
VALUES 
    (1, 'Yoga Class', '2024-04-13 09:00:00'),
    (2, 'Zumba Class', '2024-04-13 10:00:00'),
    (2, 'Pilates Class', '2024-04-13 11:00:00');

-- Inserting into the registers table
INSERT INTO registers (class_id, member_id) 
VALUES 
    (1, 1),
    (2, 2),
    (3, 3);

-- Inserting into the maintains table
INSERT INTO maintains (equipment_id, admin_id, maintenance_time) 
VALUES 
    (1, 1, '2024-04-13 08:00:00');
