# CRUD App
A simple application which stores and retrieves countries from a MongoDB database.

## Execution
Build the application:
```
mvnw clean package
```

Build the Docker images and run the containers (app and mongoDB):
```
docker-compose up --build
```

Save new countries to the database using a POST request. For example, adding England:
```
curl -X POST localhost:8080/countries -H 'Content-Type: application/json' -d '{"name":"England"}'
```

To retrieve countries from the application, use a GET request:
```
curl localhost:8080/countries
```

## Validation
Let's connect to the database to check results stored:

```
> docker exec -it mongondb bash
> mongo
> use test
> db.country.find().pretty()
```

Expected result:

```
{ "_id" : "England", "_class" : "net.xpadro.services.k8s.crud.Country" }
```