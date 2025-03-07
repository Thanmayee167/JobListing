# Job Listing API

A Spring Boot application that provides a RESTful API for managing job postings. The application uses MongoDB Atlas for data storage and includes full-text search capabilities.

## Features

- Create new job postings
- Retrieve all job postings
- Search job postings by text (searches across profile, description, and technologies)
- Swagger UI documentation
- MongoDB Atlas integration
- Full-text search capabilities

## Technology Stack

- Java 17
- Spring Boot 3.x
- MongoDB Atlas
- Spring Data MongoDB
- Swagger UI (OpenAPI 3)

## Project Structure

```
src/main/java/com/thanmayee/joblisting/
├── JoblistingApplication.java        # Main application class
├── controller/
│   └── JobPostController.java        # REST endpoints
├── model/
│   └── Post.java                    # Job post entity
└── repository/
    ├── PostRepository.java          # Basic CRUD operations
    ├── SearchRepository.java        # Search interface
    └── SearchRepositoryImpl.java    # MongoDB text search implementation
```

## API Endpoints

- `GET /` - Redirects to Swagger UI documentation
- `GET /posts` - Retrieves all job posts
- `GET /posts/{text}` - Searches for job posts containing the specified text
- `POST /post` - Creates a new job post

## MongoDB Document Structure

```json
{
  "id": "string",
  "profile": "string",
  "description": "string",
  "experience": "number",
  "technologies": ["string"]
}
```

## Configuration

The application uses MongoDB Atlas as its database. Configuration is stored in `application.properties`:

```properties
spring.application.name=joblisting
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster>.mongodb.net/<database>
spring.data.mongodb.auto-index-creation=true
```

## Search Implementation

The search functionality is implemented using MongoDB Atlas Search, which provides:
- Full-text search across multiple fields (profile, description, technologies)
- Results sorted by experience (descending order)
- Limited to 2 results per search

## Getting Started

1. Clone the repository
2. Configure MongoDB Atlas connection in `application.properties`
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Access Swagger UI at: http://localhost:8080/swagger-ui.html

## API Usage Examples

### Create a Job Post

```bash
curl -X POST http://localhost:8080/post \
  -H "Content-Type: application/json" \
  -d '{
    "profile": "Senior Java Developer",
    "description": "Looking for experienced Java developer",
    "experience": 5,
    "technologies": ["Java", "Spring", "MongoDB"]
  }'
```

### Search Jobs

```bash
curl http://localhost:8080/posts/java
```

## Security Note

Please ensure to:
1. Keep your MongoDB Atlas credentials secure
2. Never commit sensitive credentials to version control
3. Use environment variables or secure configuration management in production
