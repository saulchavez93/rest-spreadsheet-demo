# HOW TO RUN

mvn clean install

mvn spring-boot:run



... And then run in another terminal

curl -F file=@path/to/testfile http://localhost:8080/spreadsheet

(change path/to/testfile with a path to the file you want to upload)


## More info

https://stackabuse.com/uploading-files-with-spring-boot/
