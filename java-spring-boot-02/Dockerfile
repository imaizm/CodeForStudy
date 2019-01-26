FROM openjdk:8-jdk-alpine
RUN apk --update add git && rm -rf /var/cache/apk/*
VOLUME /tmp
RUN mkdir /app
WORKDIR /app
RUN git clone https://github.com/imaizm/CodeForStudy.git
WORKDIR CodeForStudy
RUN ./gradlew build
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar build/libs/demo-1.0.jar" ]