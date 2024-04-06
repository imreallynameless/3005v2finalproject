-- Populate members table
INSERT INTO members (member_email, first_name, last_name)
VALUES
    ('john@example.com', 'John', 'Doe'),
    ('jane@example.com', 'Jane', 'Smith'),
    ('michael@example.com', 'Michael', 'Johnson');

-- Populate fitness_goals table
INSERT INTO fitness_goals (member_id, goal_name, goal_description)
VALUES
    (1, 'Weight Loss', 'Lose 10 pounds in 2 months'),
    (2, 'Muscle Gain', 'Increase muscle mass by 15% in 3 months'),
    (3, 'Cardio Fitness', 'Run a 10k in under 1 hour');

-- Populate fitness_achievements table
INSERT INTO fitness_achievements (member_id, achievement_name, achievement_description)
VALUES
    (1, 'Completed 5k Run', 'Ran a 5k in under 30 minutes'),
    (2, 'Bench Press Record', 'Bench pressed 250 pounds'),
    (3, 'Climbed Mount Everest', 'Summited Mount Everest');

-- Populate exercise_routines table
INSERT INTO exercise_routines (member_id, routine_name, routine_description)
VALUES
    (1, 'Daily Cardio', '30 minutes of jogging'),
    (2, 'Strength Training', '3 sets of squats, deadlifts, and bench press'),
    (3, 'Endurance Workout', '1 hour of cycling followed by 30 minutes of swimming');

-- Populate health_statistics table
INSERT INTO health_statistics (member_id, weight, height)
VALUES
    (1, 180, 172),
    (2, 200, 168),
    (3, 160, 160);

-- Populate trainers table
INSERT INTO trainers (trainer_email, first_name, last_name)
VALUES
    ('emily@example.com', 'Emily', 'Anderson'),
    ('david@example.com', 'David', 'Wilson');

-- Populate administrators table
INSERT INTO administrators (admin_email, first_name, last_name)
VALUES
    ('sarah@example.com', 'Sarah', 'Johnson'),
    ('mark@example.com', 'Mark', 'Taylor');

-- Populate group_classes table
INSERT INTO group_classes (trainer_id, class_name, class_time)
VALUES
    (1, 'Yoga Class', '2024-04-05 10:00:00'),
    (2, 'Bootcamp', '2024-04-06 15:00:00');

-- Populate class_members table
INSERT INTO class_members (class_id, member_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (2, 3);

-- Populate personal_training table
INSERT INTO personal_training (member_id, trainer_id, training_time)
VALUES
    (1, 1, '2024-04-05 12:00:00'),
    (2, 2, '2024-04-06 14:00:00');

-- Populate equipment table
INSERT INTO equipment (equipment_name, equipment_status)
VALUES
    ('Treadmill', true),
    ('Barbell', true),
    ('Yoga Mat', false);

-- Populate room table
INSERT INTO room (room_name, room_time)
VALUES
    ('Studio A', '2024-04-05 10:00:00'),
    ('Studio B', '2024-04-06 15:00:00');
