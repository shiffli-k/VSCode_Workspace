FROM eclipse-temurin:latest

WORKDIR /app

COPY /target/*.jar myapp.jar

EXPOSE 9090

ENTRYPOINT [ "java", "-jar", "myapp.jar" ]