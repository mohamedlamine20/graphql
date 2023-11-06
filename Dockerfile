#FROM maven:3.8.6-openjdk-18-slim AS build
#WORKDIR /home/app
#COPY . /home/app
#RUN mvn -f /home/app/pom.xml clean package
#
#FROM openjdk:18.0-slim
#EXPOSE 8080
#COPY --from=build /home/app/target/*.jar app.jar
#ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]

FROM maven:3.8.6 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests


FROM openjdk:17-jdk-alpine
COPY  --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]