# Use JDK 21 to match your local compilation version
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the jar file built with JDK 21
COPY target/attendaceTracker-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render usually uses this for documentation, but uses PORT env var internally)
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]