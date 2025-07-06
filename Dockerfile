# Use official Maven image to build the application
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw mvnw

# Pre-download dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src src

# Package the application
RUN ./mvnw clean package -DskipTests

# ---- Final image ----
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the packaged JAR from the builder stage
COPY --from=build /app/target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
