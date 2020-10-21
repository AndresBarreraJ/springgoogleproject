FROM openjdk:8
ADD target/docker-spring-project.jar docker-spring-project.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-spring-project.jar"]