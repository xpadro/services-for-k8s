# Context
Sample of the interaction between two services and a mongoDB database. The images of these services will be used for making samples of k8s.

- Crud-app: A web application which stores and retrieves countries from a MongoDB database.
- Client-app: A web application which makes requests to crud-app


## Setup
Build the application:
```
mvnw clean package
```

Build the Docker images and run the containers (apps and mongoDB):
```
docker-compose up --build
```

## Crud-app
Crud-app is exposed on port 8080. Available requests are:

- Save new countries to the database using a POST request. For example, adding England:
```
curl -X POST localhost:8080/countries -H 'Content-Type: application/json' -d '{"name":"England"}'
```

- Retrieve countries from the application using a GET request:
```
curl localhost:8080/countries
```

## Client-app
Client-app is exposed on port 8081. Available requests are:

- Retrieve countries from the application using a GET request:
```
curl localhost:8081/client/countries
```


## Validation
Let's connect to the database to check results stored:

```
> docker exec -it mongodb bash
> mongo
> use test
> db.country.find().pretty()
```

Expected result:

```
{ "_id" : "England", "_class" : "net.xpadro.services.k8s.crud.Country" }
```