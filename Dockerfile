FROM openjdk:16-alpine3.13

WORKDIR /app

COPY . .

RUN ./mvnw dependency:go-offline
EXPOSE 8000
CMD ["mvnw", "springboot:run"]