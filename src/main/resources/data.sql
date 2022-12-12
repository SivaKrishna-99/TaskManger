-- insert some initial users into the users table
INSERT INTO users (username, password, email, name) VALUES
                                                        ("johndoe", "password123", "johndoe@example.com", "John Doe"),
                                                        ("janedoe", "password456", "janedoe@example.com", "Jane Doe"),
                                                        ("bobsmith", "password789", "bobsmith@example.com", "Bob Smith");

-- insert some initial tasks into the tasks table
INSERT INTO tasks (userId, name, dueDate, priority) VALUES
                                                        (1, "Complete project proposal", "2022-12-01", "High"),
                                                        (1, "Meet with team members", "2022-12-03", "Medium"),
                                                        (2, "Submit expense report", "2022-12-05", "Low"),
                                                        (2, "Attend company training", "2022-12-07", "High"),
                                                        (3, "Update task manager web application", "2022-12-08", "Low");


-- insert some initial completed tasks into the completed_tasks table
INSERT INTO completed_tasks (taskId, completionDate, completedBy) VALUES
                                                                      (1, "2022-12-01", 1),
                                                                      (3, "2022-12-06", 2);
