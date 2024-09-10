Quiz Application with Microservices
This is a Spring Boot-based quiz application that leverages a microservices architecture for handling quizzes and questions. The application includes independent services for managing quizzes and questions and uses Eureka for service discovery, along with Feign for communication between the services.

Features
Quiz Customization: Users can create custom quizzes by selecting the number of questions and difficulty level (easy, medium, hard).
Question Service: Manages technical questions related to CS fundamentals, stored in PostgreSQL, and categorized by difficulty.
Eureka Server: Manages service discovery for scalable and modular architecture.
Feign Client: Used for efficient communication between the Quiz Service and the Question Service.
Scalability: The microservices architecture allows for the creation of multiple instances to handle high traffic and usage.
Technologies Used
Spring Boot
Microservices Architecture
Eureka Server (for service discovery)
Feign Client (for inter-service communication)
PostgreSQL (for database storage)
Maven (for dependency management)
Installation
Prerequisites
Java 8 or higher
Maven
PostgreSQL
Eureka Server running
Steps to Run
Clone the repository:

bash
Copy code
git clone https://github.com/yashthakur16/Quiz-Application-with-Microservices.git
cd Quiz-Application-with-Microservices
Set up the PostgreSQL Database:

Create a PostgreSQL database for storing quiz and question data.
Update the application.properties or application.yml in both the Quiz and Question services with your PostgreSQL credentials.
Start Eureka Server: Navigate to the eureka-server directory and run the server:

bash
Copy code
mvn spring-boot:run
Start the Microservices: Navigate to the quiz-service and question-service directories separately and run:

bash
Copy code
mvn spring-boot:run
Access the Application:

Eureka Dashboard: http://localhost:8761
Quiz Service: http://localhost:8081
Question Service: http://localhost:8083
API Endpoints
Quiz Service
POST /api/quizzes - Create a quiz by specifying the number of questions and difficulty level
GET /api/quizzes - List all created quizzes
Question Service
GET /api/questions - List all questions
POST /api/questions - Add new questions to the database
GET /api/questions/{difficulty} - Fetch questions based on difficulty (easy, medium, hard)
Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes.

