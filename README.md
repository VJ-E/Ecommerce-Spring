# E-commerce Application

A modern e-commerce platform built with Spring Boot, Spring Security, and MySQL. This application provides a foundation for building a full-featured online shopping experience with user authentication and role-based access control.

## Features

- **User Management**
  - User registration and authentication
  - Role-based authorization (USER, ADMIN)
  - User profile management
  - Secure password handling

- **Technical Stack**
  - **Backend**: Spring Boot 3.2.0
  - **Database**: MySQL 8.0
  - **Security**: Spring Security
  - **Templating**: Thymeleaf
  - **Build Tool**: Maven
  - **Java Version**: 17

## Prerequisites

- Java 17 or higher
- MySQL 8.0 or higher
- Maven 3.6.3 or higher
- Git (for version control)

## Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Ecommerce-SpringBoot
   ```

2. **Configure Database**
   - Create a MySQL database named `ecommerce`
   - Update the database credentials in `src/main/resources/application.properties`

3. **Build the Application**
   ```bash
   mvn clean install
   ```

4. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the Application**
   - Open your browser and go to: `http://localhost:8080`

## Project Structure

```
src/
├── main/
│   ├── java/com/ecommerce/
│   │   ├── EcommerceApplication.java      # Main application class
│   │   └── entity/                       # JPA entities
│   │       └── User.java                 # User entity with authentication details
│   └── resources/
│       └── application.properties        # Application configuration
```

## Database Configuration

The application is configured to use MySQL with the following default settings:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## Security

- Spring Security is implemented for authentication and authorization
- Password encoding using BCrypt
- CSRF protection enabled
- Role-based access control
- Secure session management

## API Documentation

API documentation will be available at `http://localhost:8080/swagger-ui.html` after implementing Swagger/OpenAPI.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.