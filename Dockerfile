FROM openjdk:17
ADD target/graphqlapi-0.0.1-SNAPSHOT.jar graphqlapi.jar
ENTRYPOINT ["java", "-jar", "graphqlapi.jar"]



