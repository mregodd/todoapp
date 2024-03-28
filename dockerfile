# Base image
FROM openjdk:21-jdk

# Set working directory
WORKDIR /usr/src/app

# Copy JAR file to the working directory
COPY target/*.jar app.jar

# Define the command to run the application
ENTRYPOINT ["java","-jar","app.jar"]

# Expose the port
EXPOSE 8080
