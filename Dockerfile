# Use a base image with JDK 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper & config
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

# Download dependencies (layered build optimization)
RUN ./mvnw dependency:go-offline

# Copy the rest of the project
COPY src ./src

# Package the app
RUN ./mvnw package -DskipTests

# Run the app
CMD ["java", "-jar", "target/*.jar"]
