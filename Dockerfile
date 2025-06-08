# Use an official JDK runtime as the base image
FROM amazoncorretto:17-alpine

# Set the working directory inside the Docker container
WORKDIR /app

# Copy the Maven build file to the container
COPY pom.xml .

# Cache the dependencies
RUN --mount=type=cache,target=/root/.m2 \
    apk add --no-cache maven && \
    mvn dependency:resolve

# Copy the application code into the container
COPY src ./src

# Package the application into a JAR file
RUN mvn clean install -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Add the JAR produced in the Maven build step
ARG JAR_FILE=target/app.jar
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]