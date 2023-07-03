FROM openjdk:17-oracle
COPY ./build/libs/My_Spring_Project-0.0.1-SNAPSHOT.jar My_Spring_Project.jar
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=prod","My_Spring_Project.jar"]