FROM openjdk:8-jre-alpine-latest
VOLUME /tmp
VOLUME /home/javarun/logs
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://sample/sample-db","-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar"]
LABEL "com.walcron.sample"="Sample"
LABEL version="1.0"
LABEL description="MSample"
