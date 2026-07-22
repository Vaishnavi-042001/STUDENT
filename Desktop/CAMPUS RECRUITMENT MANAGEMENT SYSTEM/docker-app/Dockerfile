FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy Maven build file and source
COPY pom.xml .
COPY src ./src

# Build the application (skip tests for speed)
RUN apt-get update && apt-get install -y maven && \
    mvn clean package -DskipTests && \
    mv target/*.jar app.jar && \
    apt-get remove -y maven && apt-get autoremove -y

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]