create table members
    (
        member_id SERIAL PRIMARY KEY,
        first_name VARCHAR(50) NOT NULL,
        last_name VARCHAR(50) NOT NULL,
        
    );

-- one to many relationship

CREATE TABLE fitness_goals
    (
        goal_id SERIAL PRIMARY KEY,
        member_id INT REFERENCES members(member_id),
        goal_name VARCHAR(50) NOT NULL,
        goal_description TEXT
    );

CREATE TABLE health_statistics
    (
        health_stat_id SERIAL PRIMARY KEY,
        member_id INT REFERENCES members(member_id),
        weight INT,
        height INT,
        date DATE
    );

CREATE TABLE schedule
(
    schedule_id SERIAL PRIMARY KEY,
    member_id INT REFERENCES members(member_id)
);

CREATE TABLE trainers
    (
        trainer_id SERIAL PRIMARY KEY,
        first_name VARCHAR(50) NOT NULL,
        last_name VARCHAR(50) NOT NULL,
        available_start TIME,
        available_end TIME
    );

CREATE TABLE adminstrators
    (
        admin_id SERIAL PRIMARY KEY,
        first_name VARCHAR(50) NOT NULL,
        last_name VARCHAR(50) NOT NULL,
    );

CREATE TABLE group_classes
(
    class_id SERIAL PRIMARY KEY,
    schedule_id INT REFERENCES schedule(schedule_id),
    trainer_id INT REFERENCES trainers(trainer_id) NOT NULL, 
    class_name VARCHAR(50) NOT NULL,
    class_description TEXT,
    class_start TIME,
    class_end TIME
);

CREATE TABLE personal_training
(
    training_id SERIAL PRIMARY KEY,
    schedule_id INT REFERENCES schedule(schedule_id),
    trainer_id INT REFERENCES trainers(trainer_id) NOT NULL,
    training_start TIME,
    training_end TIME
);

CREATE TABLE equipment
(
    equipment_id SERIAL PRIMARY KEY,
    equipment_name VARCHAR(50) NOT NULL,
    equipment_status BOOLEAN
);

CREATE TABLE room
(
    room_id SERIAL PRIMARY KEY,
    room_name VARCHAR(50) NOT NULL,
    room_capacity INT
    room_availability BOOLEAN
);
