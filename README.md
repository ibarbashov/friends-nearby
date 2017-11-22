# Friends Nearby [![Build Status](https://travis-ci.org/iodudes/friends-nearby.svg?branch=master)](https://travis-ci.org/iodudes/friends-nearby)
A service for finding people near you.

## System requirements:
For **backend** module:
 - JDK8
 - Docker 17.03.1 and newer
 
For **mobile-client** module:
 - TODO
 - TODO

## Build and deploy instructions:
For **backend** module:
1. Build PostgreSQL Docker image:
```
docker build -t iodudes/iodudes-postgres:1.0 backend/postgres-docker/
```
2. Run Docker container:
```
docker run -d --name=iodudes-postgres -p 5432:5432 iodudes/iodudes-postgres:1.0
```
3. Wait until PostgreSQL finishes initialization. You can check status manually:
```
docker logs -f iodudes-postgres
```
4. Run application:
```
./gradlew :backend:bootRun
```

For **mobile-client** module:
1. TODO
2. TODO

