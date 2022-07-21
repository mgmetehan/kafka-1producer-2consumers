# kafka-1producer-2consumers
# multiple consumers in Kafka
Producer projesini ayağı kaldırıp postmanden attığımız mesajları diğer consumer projeleri bu mesajı dinliyor.




### Tech Stack
- Java 11
- Spring Boot
- Lombok
- Apache Kafka


### Requirements

For building and running the application you need:
- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or newer .
- [Maven](https://maven.apache.org)
- [Lombok](https://projectlombok.org/)
- [Apache Kafka](https://kafka.apache.org)


### Build & Run
```
  docker-compose -f docker-compose.yml up -d
```
```
  mvn clean install && mvn --projects backend spring-boot:run
```

### Port
```
  http://localhost:8082
```