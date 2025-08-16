# Use Java 17 JDK
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy all project files
COPY . .

# Make mvnw executable
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package

# Expose the port
EXPOSE 10000

# Start the Spring Boot app
CMD ["java", "-jar", "target/StudentManagementSystem-0.0.1-SNAPSHOT.jar"]
