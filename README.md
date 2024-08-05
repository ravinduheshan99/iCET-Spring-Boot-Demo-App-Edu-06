# iCET - Demo Spring Boot Application - (06)

This project is a Java Spring Boot application designed for academic purposes to provide a simple product management system with features for CRUD operations, custom repository queries, JUnit testing, Spring profiling, and more. It demonstrates advanced concepts such as the difference between Spring Data JPA repositories and native repositories, the use of `@RequiredArgsConstructor`, and Spring's environment profiling.

## Introduction

This project serves as a foundational example of how to build a Spring Boot application that interacts with a MySQL database using Spring Data JPA and custom native queries. The application is designed with modularity and testability in mind, leveraging modern Java features like `var` and Lombok for boilerplate reduction.

## Key Concepts

### Spring JPA Repository vs. Native Repository

In this project, two types of repositories are utilized:

- **Spring Data JPA Repository (ProductJpaRepository)**: 
  - Provides out-of-the-box CRUD operations by extending ***CrudRepository***.
  - Uses JPA and Hibernate under the hood for database interactions, making it ideal for simple operations.
  
- **Native Repository (ProductNativeRepository)**:
  - Implements custom SQL queries that might be more complex or performance-sensitive.
  - Uses ***JdbcTemplate*** to execute raw SQL queries directly against the database.
  - Useful when you need more control over the SQL being executed or when working with legacy databases where JPA might not perform optimally.

**Example in the Project**:
- ***ProductJpaRepository*** handles standard CRUD operations.
- ***ProductRepositoryImpl*** implements ***ProductNativeRepository*** and provides a custom SQL query to count products.

### JUnit Testing

The project includes JUnit tests to verify the functionality of the service and repository layers.

- **Repository Tests**: Ensure that custom SQL queries return the expected results.
- **Service Tests**: Test service layer logic, including integration with repositories.

**How to Run Tests**:
\`\`\`bash
mvn test
\`\`\`

### Spring Profiling

Spring profiles allow you to configure different environments (development, testing, production) with separate settings.

- **Profiles in Use**: \`dev\`, \`qa\`, \`prod\`.
- **Configuration Files**:
  - \`application-dev.yml\`: For development.
  - \`application-qa.yml\`: For QA environment.
  - \`application-prod.yml\`: For production.

**Active Profile**: The active profile is set in \`application.yml\` using:
\`\`\`yaml
spring:
  profiles:
    active: dev
\`\`\`
This allows you to easily switch between configurations by changing the active profile.

### Use of \`@RequiredArgsConstructor\`

The \`@RequiredArgsConstructor\` annotation from Lombok generates a constructor with required arguments (i.e., final fields). It helps reduce boilerplate code, especially when working with dependency injection in Spring.

**Example in the Project**:
- \`ProductController\` and \`ProductServiceImpl\` classes use \`@RequiredArgsConstructor\` to automatically generate constructors for injecting dependencies.

This makes the code cleaner and more maintainable:
\`\`\`java
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productServiceImpl;
}
\`\`\`

## Endpoints

### Product Endpoints

- \`GET /product/product-count\`: Retrieve the total count of products.
- \`POST /product\`: Persist a new product.

## Database Configuration

The application uses MySQL, with different configurations for development, QA, and production environments. The database connection details are specified in the respective \`application-*.yml\` files.

**Example Configuration**:
\`\`\`yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/crm_dev
    username: root
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
\`\`\`

## Running the Application

1. Clone the repository:
   \`\`\`bash
   git clone https://github.com/yourusername/product-management-app.git
   cd product-management-app
   \`\`\`

2. Set up the database by creating a new schema in MySQL (e.g., \`crm_dev\`).

3. Update the database configuration in \`application-dev.yml\` (or another profile).

4. Run the application:
   \`\`\`bash
   mvn spring-boot:run
   \`\`\`

The application will start on the default port (8080 or as configured) and be accessible at \`http://localhost:8080\`.

## Technologies Used

- **Java 17**: Leveraging modern features like \`var\`.
- **Spring Boot 3.3.0**: For building the application.
- **Spring Data JPA**: For data persistence.
- **Lombok**: To reduce boilerplate code.
- **JUnit**: For testing.
- **MySQL**: Database management.
