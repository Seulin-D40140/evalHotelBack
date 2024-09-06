# Utiliser une image de base OpenJDK
FROM openjdk:8-jdk

# Créer et définir le répertoire de travail dans le conteneur
WORKDIR /usr/src/app

# Ajouter un argument pour le fichier JAR généré par Maven ou Gradle
ARG JAR_FILE=target/evaluation3-Hotel-0.0.1-SNAPSHOT.jar

# Copier le fichier JAR dans l'image Docker
COPY ${JAR_FILE} app.jar

# Exposer le port 8080 (ou le port sur lequel l'application Java écoute)
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app.jar"]
