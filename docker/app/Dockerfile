FROM postgres:9.6

ENV PGDATA /var/lib/psql/data
ENV POSTGRES_USER iodudes
ENV POSTGRES_PASSWORD S33fWqwe

COPY ./<path to JAR> /app
WORKDIR /app
EXPOSE 8080

RUN apk add openjdk8
RUN java -jar friends-nearby.jar
