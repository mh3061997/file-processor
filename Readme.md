#   File Processor
##  Description 
This is a file processor created using `Spring Boot 3.0.2` using `Java JDK 17`  providing the below functionalities

## Run
run `mvn clean install` to build a jar file then run `java -jar .\target\file-processor-0.0.1-SNAPSHOT.jar`


## Random Line
make a get request to `http://localhost:8080/file/random-line` to get a random line out of all the uploaded files
## Backward Random Line
make a get request to `http://localhost:8080/file/backward-random-line` to get a random line in reverse out of all the uploaded files
## Longest 100 Lines
make a get request to `http://localhost:8080/file/longest-100-lines` to get the longest 100 lines out of all the uploaded files
## 20 Longest lines of 1 file
make a get request to `http://localhost:8080/file/20-lines` to get the longest 20 lines out of 1 file
to choose the latest uploaded file provide `useLatestFile=true` 
or provide `useLatestFile=false` to choose a random file
