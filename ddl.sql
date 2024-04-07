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
        last_name VARCHAR(50) NOT NULL,
        avaliable BOOLEAN NOT NULL
    );

CREATE TABLE trainer_classes (
        trainer_id INTEGER REFERENCES trainers(trainer_id),
        class_id INTEGER REFERENCES group_classes(class_id),
        PRIMARY KEY (trainer_id, class_id)
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
        member_id INTEGER REFERENCES members(member_id),
        PRIMARY KEY (class_id, member_id)
    );

CREATE TABLE personal_training
    (
        training_id SERIAL PRIMARY KEY,
        member_id INTEGER REFERENCES members(member_id) NOT NULL,
        trainer_id INTEGER REFERENCES trainers(trainer_id) DEFAULT NULL,
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
        member_id INTEGER REFERENCES members(member_id),
        room_name VARCHAR(50) NOT NULL,
        room_time TIMESTAMP NOT NULL
    );
