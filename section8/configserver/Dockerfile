# ---------- Build stage ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom first for dependency caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build jar
RUN mvn clean package -DskipTests

# ---------- Runtime stage ----------
FROM eclipse-temurin:21-jre

# Install curl for Docker healthcheck
RUN apt-get update \
    && apt-get install -y curl \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copy built jar
COPY --from=build /app/target/configserver-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8071

ENTRYPOINT ["java", "-jar", "app.jar"]