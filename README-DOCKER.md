# DOCKER

## Criar container docker do Postgres

```shell script
docker run --name student-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=student postgres
 postgres
```
