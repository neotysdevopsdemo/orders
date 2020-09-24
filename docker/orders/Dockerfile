FROM openjdk:11.0.8-jre-slim
WORKDIR /usr/src/app
COPY *.jar ./app.jar

ENTRYPOINT ["java","-jar","./app.jar", "--port=80"]
