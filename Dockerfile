FROM openjdk:17.0.1
COPY "./target/david-0.0.1-SNAPSHOT.jar" "david.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","david.jar"]