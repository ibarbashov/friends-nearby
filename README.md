# Friends Nearby
## Running application:
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

