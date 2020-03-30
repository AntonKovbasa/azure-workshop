FROM openjdk:8-jre-slim

EXPOSE 8080

RUN mkdir /app

COPY ./build/libs/*.jar /app/workshop-app-0.0.1.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap","-jar","/app/workshop-app-0.0.1.jar"]
