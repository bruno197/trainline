FROM openjdk:8-jdk-alpine

ADD target/train-line-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-Dtrip=A-C,A-D,A-D-C,A-E-B-C-D"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]
ENV TZ 'America/Sao_Paulo'
