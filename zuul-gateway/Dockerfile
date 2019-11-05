FROM openjdk:11
EXPOSE 8092
COPY ./target/zuul-gateway-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]