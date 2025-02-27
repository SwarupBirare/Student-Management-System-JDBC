# Student-Management-System-JDBC

## Description
The Student-Management-System-JDBC is a web-based Java application that efficiently manages student records using JDBC and Servlets. This project allows users to perform CRUD operations (Create, Read, Update, Delete) on student data stored in a relational database. It demonstrates core Java EE concepts, including JDBC for database connectivity, Servlets for backend logic, and JSP for the user interface.
## Features
- **Add Student Records:** Insert new student data into the database
- **Remove Student Records:** Delete an existing student record using the student's ID.
- **Update Student Records:** Modify existing student details.
- **View Student Records:** Retrieve and display all stored student information.
- **Search Student Records:** Find student details using their ID.
- **User-Friendly Interface:** Designed with JSP and Servlet integration for dynamic interaction.

## Technologies Used
- **Programming Language:** Java
- **Frameworks & Tools:**
  - JDBC (Java Database Connectivity)
  - Servlets & JSP
  - HTML, CSS(for UI styling)
- **Database:** MySQL
- **Server:** Apache Tomcat
- **IDE:** Eclipse

## Usage
Running the Application:

**1.Database Setup:**
- Create a MySQL database named student_db.
- Execute the provided SQL script to create the students table.
- Configure database connection parameters in DBUtility.java.
- Deploy on Tomcat:
- Import the project into Eclipse.
- Configure Tomcat Server.
- Run the project on the server.
- Access via Web Browser:
    Navigate to http://localhost:9999/StudentManagementDOB

**2.Deploy on Tomcat:**
- Import the project into Eclipse.
- Configure Tomcat Server.
- Run the project on the server.

**3.Access via Web Browser:**
- Navigate to http://localhost:9999/StudentManagementDOB

## Project Structure
- `com.controller` - Handles user requests via Servlets.
- `com.dao` - Manages database operations.
- `com.model` - Defines the Student entity.
- `com.utility` - Contains database connection utilities.

## Screenshots
![image](https://github.com/user-attachments/assets/6ff1ff39-fc0b-49d0-88a0-b09783f4a711)
![image](https://github.com/user-attachments/assets/410dbaf6-3bc0-4728-9aa3-d2860f2fae6a)
![image](https://github.com/user-attachments/assets/248b22ed-d010-48ac-9827-b99ee96934f9)

## Contributing
Contributions are welcome! If you find any bugs or have suggestions for improvement, feel free to submit an issue or a pull request.

## License

## Author
Developed by Swarup Birare. If you have any questions, feel free to reach out!
