# Utiliser une image de base officielle de Java avec Maven pour Java 17
FROM maven:3.8.4-openjdk-17 AS build

# Copier les fichiers de l'application dans le conteneur
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

# Compiler l'application
RUN mvn -f /usr/src/app/pom.xml clean package

# Utiliser une image de base de Java pour l'exécution, correspondant à Java 17
FROM openjdk:17-jdk-slim

# Copier le JAR compilé depuis l'étape de construction
COPY --from=build /usr/src/app/target/surfwear-service.jar /usr/app/surfwear-service.jar

# Exposer le port sur lequel l'application va tourner
EXPOSE 8080

# Lancer l'application Java
CMD ["java", "-jar", "/usr/app/surfwear-service.jar"]
