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

CREATE TABLE bills
    (
        admin_id INTEGER REFERENCES administrators(admin_id),
        member_id INTEGER REFERENCES members(member_id),
        bill_amount INTEGER NOT NULL,
        bill_time TIMESTAMP NOT NULL,
        PRIMARY KEY (admin_id, member_id)
    );
 
CREATE TABLE group_classes
    (
        class_id SERIAL PRIMARY KEY,
        admin_id INTEGER REFERENCES administrators(admin_id),
        class_name VARCHAR(50) NOT NULL,
        class_time TIMESTAMP NOT NULL
    );

CREATE TABLE registers
    (
        class_id INTEGER REFERENCES group_classes(class_id),
        member_id INTEGER REFERENCES members(member_id),
        PRIMARY KEY (class_id, member_id)
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
        equipment_id SERIAL,
        equipment_name VARCHAR(50) NOT NULL,
        equipment_broken BOOLEAN
    );

CREATE TABLE maintains
    (
        maintenance_id SERIAL,
        equipment_id INTEGER REFERENCES equipment(equipment_id),
        admin_id INTEGER REFERENCES administrators(admin_id),
        maintenance_time TIMESTAMP DEFAULT NULL
    );

CREATE TABLE room
    (
        room_id SERIAL PRIMARY KEY,
        room_name VARCHAR(50) NOT NULL,
        room_capacity INTEGER NOT NULL
    );

CREATE TABLE books
    (
        booking_id SERIAL PRIMARY KEY,
        room_id INTEGER REFERENCES room(room_id),
        admin_id INTEGER REFERENCES administrators(admin_id),
        booking_time TIMESTAMP NOT NULL,
        booking_event VARCHAR(50) NOT NULL
    );

