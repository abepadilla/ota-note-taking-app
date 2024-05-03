## OTA Note Taking Guide

The following guide illustrates how to use the Note-taking API

### Create a local directory for persistent H2 database
In your Desktop, you can create a folder of your choice and
place it in the application.properties file. The data will persist even if the application restarts. 
Below is an example:
```
spring.datasource.url=jdbc:h2:file:~/Desktop/ota-note/ota-note-db
```

### Build the application
Before running the whole app, it is safe to clean and build it by executing the command:
```
mvn clean install
```

### Running the application
In this scenario, Maven is used to run Spring Boot.
On your terminal, execute the following command in the root directory of your application:
```
mvn spring-boot:run
```

### Test the APIs with Postman
Below is the list of APIs. Place the URL and the corresponding payload in the tool then click 'Send' button to start the request.

1. SAVING A NOTE
```
# Saving a Note
HTTP POST 
URL: http://localhost:8080/notes
Sample Payload:
{
    "title": "Sample title",
    "body", "Sample body"
}

```
2. GET ALL NOTES
```
HTTP GET 
URL: http://localhost:8080/notes
```

3. GET NOTE BY ID
```
HTTP GET 
URL: http://localhost:8080/notes/{id}
```

4. UPDATE NOTE BY ID
```
HTTP PUT 
URL: http://localhost:8080/notes/{id} with payload
{
    "id": 1,
    "title": "Sample Title",
    "body": "Sample Body"
}
```

5. DELETE NOTE BY ID
```
HTTP DELETE 
URL: http://localhost:8080/notes/{id}
```
