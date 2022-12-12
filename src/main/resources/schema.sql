-- create the database for the web application
# CREATE DATABASE taskmanager;

-- use the taskmanager database
# USE taskmanager;
DROP table users;
drop table tasks;
drop table completed_tasks;

-- create the table for storing user accounts
CREATE TABLE users (
                       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       name VARCHAR(255) NOT NULL
);

-- create the table for storing tasks
CREATE TABLE tasks (
                       id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       userId INT,
                       name VARCHAR(255) NOT NULL,
                       dueDate DATE NOT NULL,
                       priority VARCHAR(255) NOT NULL,
                       completed BOOLEAN NOT NULL DEFAULT FALSE,
                       notes TEXT,
                       attachments VARCHAR(255),
                       FOREIGN KEY (userId) REFERENCES users(id)
);

-- create the table for storing completed tasks
CREATE TABLE completed_tasks (
                                 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                 taskId INT ,
                                 completionDate DATE NOT NULL,
                                 completedBy INT NOT NULL,
                                 FOREIGN KEY (taskId) REFERENCES tasks(id),
                                 FOREIGN KEY (completedBy) REFERENCES users(id)
);
