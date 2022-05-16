#
# Declaration stage
ARG PSQL_HOST
ARG PSQL_PORT
ARG PSQL_USERNAME
ARG PSQL_PASSWORD
ARG AUTH_HEADER
ARG AUTH_TOKEN
ARG TIMEZONE

#
# Build stage
#
FROM maven:3.8.5-openjdk-17-slim as build
MAINTAINER Harin3Bone
ENV TZ ${TIMEZONE}
ENV PSQL_HOST ${PSQL_HOST}
ENV PSQL_PORT ${PSQL_PORT}
ENV PSQL_USERNAME ${PSQL_USERNAME}
ENV PSQL_PASSWORD ${PSQL_PASSWORD}

RUN date
COPY . /home/app/
WORKDIR /home/app/
RUN ls -altrh
ENTRYPOINT ["mvn", "clean", "install", "-DskipTests"]

#
# Package stage
#
FROM openjdk:17-alpine
MAINTAINER Harin3Bone
ENV PSQL_HOST ${PSQL_HOST}
ENV PSQL_PORT ${PSQL_PORT}
ENV PSQL_USERNAME ${PSQL_USERNAME}
ENV PSQL_PASSWORD ${PSQL_PASSWORD}
ENV AUTH_HEADER ${AUTH_HEADER}
ENV AUTH_TOKEN ${AUTH_TOKEN}
ENV TZ ${TIMEZONE}
RUN date
VOLUME [ "/tmp" ]
COPY --from=build /home/app/target/app.jar /home/service/app.jar
WORKDIR /home/service/
EXPOSE 3000
ENTRYPOINT ["java","-jar","app.jar"]
