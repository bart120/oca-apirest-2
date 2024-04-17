#build
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app/src

COPY src .
WORKDIR /app
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package


FROM openjdk:17
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar /usr/local/lib/api-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","/usr/local/lib/api-0.0.1-SNAPSHOT.jar" ]
