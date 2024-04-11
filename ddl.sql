CREATE TABLE members
    (
        member_id SERIAL PRIMARY KEY,
        member_email VARCHAR(50) NOT NULL UNIQUE,
        member_password VARCHAR(50) NOT NULL,
        first_name VARCHAR(50) NOT NULL,
        last_name VARCHAR(50) NOT NULL,
        outstanding_balance INTEGER NOT NULL DEFAULT 0
    );

CREATE TABLE fitness_goals
    (
        member_id INTEGER REFERENCES members(member_id),
        goal_name VARCHAR(50) NOT NULL,
        goal_description TEXT
    );

CREATE TABLE fitness_achievements
    (
        member_id INTEGER REFERENCES members(member_id),
        achievement_name VARCHAR(50) NOT NULL,
        achievement_description TEXT
    );

CREATE TABLE exercise_routines
    (
        member_id INTEGER REFERENCES members(member_id),
        routine_name VARCHAR(50) NOT NULL,
        routine_description TEXT
    );

CREATE TABLE health_statistics
    (
        member_id INTEGER REFERENCES members(member_id),
        weight INTEGER,
        height INTEGER
    );

CREATE TABLE trainers
    (
        trainer_id SERIAL PRIMARY KEY,
        trainer_email VARCHAR(50) NOT NULL UNIQUE,
        trainer_password VARCHAR(50) NOT NULL,
        first_name VARCHAR(50) NOT NULL,
        last_name VARCHAR(50) NOT NULL
    );

CREATE TABLE administrators
    (
        admin_id SERIAL PRIMARY KEY,
        admin_email VARCHAR(50) NOT NULL UNIQUE,
        admin_password VARCHAR(50) NOT NULL,
        first_name VARCHAR(50) NOT NULL,
        last_name VARCHAR(50) NOT NULL
    );

CREATE TABLE group_classes
    (
        class_id SERIAL PRIMARY KEY,
        class_name VARCHAR(50) NOT NULL,
        class_time TIMESTAMP NOT NULL
    );

CREATE TABLE class_members
    (
        class_id INTEGER REFERENCES group_classes(class_id),
        member_id INTEGER,
        trainer_id INTEGER,
        PRIMARY KEY (class_id, member_id, trainer_id),
        FOREIGN KEY (member_id) REFERENCES members(member_id),
        FOREIGN KEY (trainer_id) REFERENCES trainers(trainer_id)
    );


CREATE TABLE personal_training
    (
        training_id SERIAL PRIMARY KEY,
        member_id INTEGER REFERENCES members(member_id) DEFAULT NULL,
        trainer_id INTEGER REFERENCES trainers(trainer_id) NOT NULL,
        training_time TIMESTAMP NOT NULL
    );

CREATE TABLE equipment
    (
        equipment_id SERIAL PRIMARY KEY,
        equipment_name VARCHAR(50) NOT NULL,
        equipment_broken BOOLEAN,
        maintenance_time TIMESTAMP DEFAULT NULL
    );

CREATE TABLE room
    (
        room_id SERIAL PRIMARY KEY,
        room_name VARCHAR(50) NOT NULL
    );

CREATE TABLE room_bookings
    (
        room_id INTEGER REFERENCES room(room_id),
        member_id INTEGER REFERENCES members(member_id),
        booking_time TIMESTAMP NOT NULL,
        PRIMARY KEY (room_id, member_id)
    );