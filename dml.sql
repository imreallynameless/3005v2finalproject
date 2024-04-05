-- Inserting sample members
INSERT INTO members (first_name, last_name)
VALUES
    ('John', 'Doe'),
    ('Jane', 'Smith'),
    ('Michael', 'Johnson');

-- Inserting fitness goals for members
INSERT INTO fitness_goals (member_id, goal_name, goal_description)
VALUES
    (1, 'Weight Loss', 'Lose 10 pounds in 2 months'),
    (2, 'Muscle Gain', 'Increase muscle mass by 15% in 3 months'),
    (3, 'Cardio Fitness', 'Run a 10k in under 1 hour');

-- Inserting fitness achievements for members
INSERT INTO fitness_achievements (member_id, achievement_name, achievement_description)
VALUES
    (1, 'Completed 5k Run', 'Ran a 5k in under 30 minutes'),
    (2, 'Bench Press Record', 'Bench pressed 250 pounds'),
    (3, 'Climbed Mount Everest', 'Summited Mount Everest');

-- Inserting exercise routines for members
INSERT INTO exercise_routines (member_id, routine_name, routine_description)
VALUES
    (1, 'Daily Cardio', '30 minutes of jogging'),
    (2, 'Strength Training', '3 sets of squats, deadlifts, and bench press'),
    (3, 'Endurance Workout', '1 hour of cycling followed by 30 minutes of swimming');

-- Inserting health statistics for members
INSERT INTO health_statistics (member_id, weight, height, date)
VALUES
    (1, 180, 72, '2024-04-01'),
    (2, 200, 68, '2024-04-01'),
    (3, 160, 70, '2024-04-01');

-- Inserting trainers
INSERT INTO trainers (first_name, last_name)
VALUES
    ('Emily', 'Anderson'),
    ('David', 'Wilson');

-- Inserting administrators
INSERT INTO administrators (first_name, last_name)
VALUES
    ('Sarah', 'Johnson'),
    ('Mark', 'Taylor');

-- Inserting group classes
INSERT INTO group_classes (trainer_id, class_name, class_time)
VALUES
    (1, 'Yoga Class', '2024-04-05 10:00:00'),
    (2, 'Bootcamp', '2024-04-06 15:00:00');

-- Inserting class members
INSERT INTO class_members (class_id, member_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (2, 3);

-- Inserting personal training sessions
INSERT INTO personal_training (member_id, trainer_id, training_time)
VALUES
    (1, 1, '2024-04-05 12:00:00'),
    (2, 2, '2024-04-06 14:00:00');

-- Inserting equipment
INSERT INTO equipment (equipment_name, equipment_status)
VALUES
    ('Treadmill', true),
    ('Barbell', true),
    ('Yoga Mat', false);

-- Inserting rooms
INSERT INTO room (room_name, room_time)
VALUES
    ('Studio A', '2024-04-05 10:00:00'),
    ('Studio B', '2024-04-06 15:00:00');
