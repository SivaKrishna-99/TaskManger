Task Manager Web Application
A web application for managing and organizing tasks, built with Spring Boot and MySQL.

Installation
  Clone the repository: git clone https://github.com/[user]/task-manager-webapp.git
  Navigate to the backend directory: cd task-manager-webapp/backend
  Install the dependencies: mvn install
  Start the application: mvn spring-boot:run
  Navigate to the frontend directory: cd ../frontend
  Open the index.html file in a web browser
Features :
  Register and authenticate users
  Create, update, and delete tasks
  Mark tasks as completed
  View completed tasks
  Filter tasks by priority and due date
Project Structure :
  frontend/: Contains the HTML, CSS, and JavaScript files for the user interface of the web application.
  backend/src/main/java/com/taskmanager: Contains the Java source code for the backend of the application.
  model/: Contains the classes that define the data models for the users, tasks, and completed_tasks tables in the database.
  repository/: Contains the interfaces for accessing and modifying data in the database.
  controller/: Contains the classes that handle the business logic of the application and define the API endpoints for the frontend to access.
  data.sql: Contains the SQL commands for creating and populating the users, tasks, and completed_tasks tables in the database.
  application.properties: Contains the configuration settings for the Spring Boot application and the MySQL database.
