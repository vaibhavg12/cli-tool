FROM java:8-jdk-alpine
RUN mkdir /usr/app
COPY ./target/cli-tool-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app
WORKDIR /usr/app
CMD java -jar cli-tool-1.0-SNAPSHOT-jar-with-dependencies.jar