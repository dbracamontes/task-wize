FROM openjdk:11 as test
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw install -DskipTests
CMD ["./mvnw", "test"] 

#docker build -f test.DockerFile -t task-test .
#docker container run  task-test