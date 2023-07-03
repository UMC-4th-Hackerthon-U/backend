FROM openjdk:17-oracle
COPY ./build/libs/Kicking-0.0.1-SNAPSHOT.jar Kicking.jar
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=prod","Kicking.jar"]

