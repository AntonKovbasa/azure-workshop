#Build java app

FROM gradle:5.6.3-jdk8 AS build

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

#COPY src file to workdir
COPY ./src /home/gradle/src

RUN gradle build --no-daemon

FROM openjdk:8-jre-slim

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/workshop-app-0.0.1.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap","-jar","/app/workshop-app-0.0.1.jar"]
