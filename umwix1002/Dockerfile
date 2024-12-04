# Base image with JDK
FROM maven:3.8.8-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Install Maven dependencies
RUN mvn dependency:resolve

# Command to perform static analysis and run tests
CMD ["mvn", "clean", "verify"]
