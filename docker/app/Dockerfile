FROM postgres:9.6

ENV PGDATA /var/lib/psql/data
ENV POSTGRES_USER iodudes
ENV POSTGRES_PASSWORD S33fWqwe

RUN echo deb http://http.debian.net/debian jessie-backports main >> /etc/apt/sources.list
RUN apt update
RUN apt install -t jessie-backports -y openjdk-8-jdk
RUN update-alternatives --config java

COPY backend/build/libs/backend.jar /app/backend.jar
COPY docker/app/postgres-entrypoint.sh /usr/local/bin/postgres-entrypoint.sh
COPY docker/app/app-startup.sh /usr/local/bin/app-startup.sh

EXPOSE 8080
ENTRYPOINT ["postgres-entrypoint.sh"]
CMD "app-startup.sh"
