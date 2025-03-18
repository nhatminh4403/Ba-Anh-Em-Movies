# Use an official OpenJDK runtime as the base image
FROM openjdk:22-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container (adjust the JAR name as needed)
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application listens on
EXPOSE 8080

# Default to docker profile, can be overridden in docker-compose
ENV SPRING_PROFILES_ACTIVE=docker

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
