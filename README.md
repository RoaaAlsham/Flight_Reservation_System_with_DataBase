✈️ Flight Reservation System with Database

Overview

This Java Swing-based desktop application manages flight reservations, offering functionalities for both administrators and passengers.
It uses a MySQL database to manage and store data related to flights, reservations, and user information.

Features

User Authentication: Secure login system distinguishing between admin and passenger roles.

Flight Management: Admins can add, update, and delete flight details.

Reservation Handling: Passengers can book, view, and cancel reservations.

Seat Allocation: Real-time seat availability checks and assignments.

Data Import/Export: Admins can import and export reservation and passenger data via CSV files.

Reporting: Generate reports on reservations and passenger details.

💡 Usage

Admin Access:

Login using admin credentials.

Access functionalities like flight management, data import/export, and report generation.
reddit.com

Passenger Access:

Register or login as a passenger.

Search for available flights, make reservations, and view booking history.

🛠 Technologies Used

Programming Language: Java

GUI Framework: Swing

Database: MySQL

Database Connectivity: JDBC in AdminReportPanel and JPA in the rest of pages.

Build Tool: Apache NetBeans

🚀 Installation

Clone the Repository:

git clone https://github.com/RoaaAlsham/Flight_Reservation_System_with_DataBase.git
Set Up the Database:

Ensure MySQL is installed and running on your system.

Create a new database named FLIGHT_RESERVATION_DB.

Import the provided SQL script (flight_reservation_db.sql) to set up the necessary tables and initial data.

Configure Database Connection:

Open the project in NetBeans.

Navigate to the database connection settings in the code.

Update the JDBC URL, username, and password as per your MySQL configuration.

Build and Run the Application:

Clean and build the project in NetBeans.

Run the application to launch the GUI.

---
