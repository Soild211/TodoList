# Use official Maven image to build the application
FROM maven:3.9.5-eclipse-temurin-17 AS build

WORKDIR /app

# Copy Maven wrapper and give execute permission
COPY mvnw mvnw
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy the rest of the code
COPY src src

# Package app
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
