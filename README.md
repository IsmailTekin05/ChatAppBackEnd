# ChatApp BackEnd

This is the backend service for a real-time messaging application built with Java Spring Boot. It provides a robust, scalable, and secure API for handling user authentication, message transmission, and persistence using PostgreSQL and Apache Kafka.

## Features
- **User Management:** Registration, authentication, and profile management.
- **Real-Time Messaging:** Supports both RESTful and WebSocket communication.
- **Message Queueing:** Utilizes Apache Kafka for efficient message delivery.
- **Database Storage:** Uses PostgreSQL for data persistence.
- **Security:** Implements Spring Security for authentication and access control.
- **Scalability:** Supports Docker for containerization and deployment.
- **Testing:** Ensures reliability with JUnit-based test coverage.

## Technologies Used
- **Java 23**
- **Spring Boot** (Spring Web, Spring Security, Spring Data JPA, Spring WebSocket)
- **Apache Kafka**
- **PostgreSQL**
- **Docker**
- **JUnit**

## Getting Started

### Prerequisites
Ensure you have the following installed:
- Java 17+
- PostgreSQL
- Apache Kafka
- Docker (optional for containerization)

### Installation & Running
1. Clone the repository:
   ```sh
   git clone https://github.com/IsmailTekin05/ChatAppBackEnd.git
   cd ChatAppBackEnd
   ```
2. Configure the `application.properties` file with your PostgreSQL and Kafka settings.
3. Build and run the application:
   ```sh
   ./mvnw spring-boot:run
   ```
4. The API will be available at `http://localhost:8080`.

## API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST   | `/register` | Register a new user |
| POST   | `/login` | Authenticate a user |
| GET    | `/messages/{userId}` | Fetch messages for a user |
| POST   | `/messages/send` | Send a new message |

## Contributing
Contributions are welcome! Feel free to fork the repository and submit pull requests.

## License
This project is licensed under GPL-3.0 license.

