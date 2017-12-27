# Friends Nearby [![Build Status](https://travis-ci.org/iodudes/friends-nearby.svg?branch=master)](https://travis-ci.org/iodudes/friends-nearby)
A service for finding people near you.

## System requirements:
For **backend** module:
 - JDK8
 - Docker 17.03.1 or later 
 
For **mobile-client** module:
 - Android SDK v27

## Build and deploy instructions:
Running isolated build environment:
```
docker build -t iodudes/build-env:1.0 docker/build-env
```
```
docker run -d --name=build-env -v /myvol -p 22:22 iodudes/build-env:1.0
```
then SSH into container and run build commands. You can redirect log and build output to local filesystem,
e.g.: 
```
./graldew build > /myvol/build.log
```

For **backend** module:
1. Build database Docker image:
```
docker build -t iodudes/postgres:1.0 docker/postgres
```
2. Build application Docker image:
```
docker build -t iodudes/backend:1.0 -f docker/app/Dockerfile .
```
or
```
./gradlew :backend:buildDockerImage
```
3. Run database Docker container:
```
docker run -d --name=postgres -p 5432:5432 -p 8080:8080 iodudes/postgres:1.0
```
4. Run application Docker container:
```
docker run -d --name=backend --network container:postgres iodudes/backend:1.0
```
or
```
./gradlew :backend:runDockerContainer
```
NOTE: application container uses other container's network stack so database container must be started before application.

5. Run application on host machine:
```
./gradlew :backend:bootRun
```

For **mobile-client** module:
1. TODO
2. TODO

