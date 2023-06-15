FROM openjdk:17
WORKDIR /app
#COPY ./src/main/java/com/isa/pl/redbugs/Application.java app/src/Application.java
COPY ./src/main/java/com/isa/pl/redbugs/Application.java app/com.isa.pl.redbugs.Application.java

#COPY src /app/src
#COPY src/main/java/com /app/com
#COPY src/main/java/com/isa/pl/redbugs/model/Route.java app/com.isa.pl.redbugs.model.Route.java

#COPY pom.xml /com
ENTRYPOINT ["java", "app/com.isa.pl.redbugs.Application.java"]
