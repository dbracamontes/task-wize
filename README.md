# task-wize

Web service uses an in memory database h2. The project has a set up for creating tables and populate the database. So there is not required set up for it
Database just has the below table and data
----------------------------
states
----------------------------
id          | name
----------------------------
1           | Aguascalientes
----------------------------
2           | Jalisco
----------------------------


EndPoints 

Greeting - Just Return Hello World Message
http://localhost:8080/greeting

States - Get all states in db
http://localhost:8080/states

Find state by id
http://localhost:8080/state/1

Find state by query param name
http://localhost:8080/state?name=Jalisco


Project uses docker for running the app and testing. There is a two docker files:
DockerFile - creates the image that will start the service
test.DockerFile - run the test cases

Starting Up the service - In the root path of the app run the below commands
docker build -f DockerFile -t task .
docker container run -p 8080:8080 task

Running unit test -
docker build -f test.DockerFile -t task-test .
docker container run  task-test



