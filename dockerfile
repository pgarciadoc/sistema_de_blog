FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY backend /app

RUN chmod +x mvnw
RUN ./mvnw clean package

EXPOSE 8080

CMD ["sh", "-c", "java -jar target/*.jar"]
