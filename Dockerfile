FROM openjdk:11
EXPOSE 8080
WORKDIR /app
COPY target/desafio-mercado-livre-1.0-SNAPSHOT.jar /app/desafio-mercado-livre.jar
ENTRYPOINT ["java", "-jar", "desafio-mercado-livre.jar"]