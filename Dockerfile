FROM java:8u111-jdk-alpine

WORKDIR /app

COPY target/my-spring-boot-0.1.0.jar .

EXPOSE 8080

CMD ["java","-jar","my-spring-boot-0.1.0.jar"]