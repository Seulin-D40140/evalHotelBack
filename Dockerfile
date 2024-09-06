# Utiliser une image de base OpenJDK
FROM openjdk:8-jdk

# Créer et définir le répertoire de travail
WORKDIR /usr/src/app

# Copier package.json et installer les dépendances
COPY package*.json ./
RUN npm install

# Copier le reste des fichiers de l'application
COPY . .

# Ajouter un argument pour le fichier JAR généré par Maven ou Gradle
ARG JAR_FILE=target/evaluation3-Hotel-0.0.1-SNAPSHOT.jar

# Copier le fichier JAR dans l'image
COPY ${JAR_FILE} app.jar

# Exposer le port 8080
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app.jar"]
