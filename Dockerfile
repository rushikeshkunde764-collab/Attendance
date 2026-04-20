# Use lightweight Java image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar file
COPY target/attendaceTracker-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Spring Boot default)
EXPOSE 8080

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]