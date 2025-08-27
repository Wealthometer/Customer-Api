FROM jelastic/maven:3.9.5-openjdk-21  AS build
WORKDIR /
COPY src src
COPY pom.xml pom.xml
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:21-jdk
#LABEL "com.boa.customerapidocker"="customer-api"
LABEL version=1.0-SNAPSHOT
COPY --from=build target/customerapi-0.0.1-SNAPSHOT.jar customerapi-0.0.1-SNAPSHOT.jar
EXPOSE 7074
#ENTRYPOINT ["java","-jar","customerapi-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT java -Dspring.profiles.active=prod -jar customerapi-0.0.1-SNAPSHOT.jar