# Build stage
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve
COPY src src
RUN ./mvnw clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/alabot2-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar", "/config/config.json"]
