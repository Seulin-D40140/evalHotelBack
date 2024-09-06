pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "monapp:${env.BUILD_ID}"
    }

    stages {
        stage('Cloner le dépôt') {
            steps {
                 git url: 'https://github.com/Seulin-D40140/evalHotelFront.git', branch: 'main'
            }
        }

        stage('Build Maven') {
            steps {
                echo 'Compilation du projet Java avec Maven...'
                sh 'mvn clean package' // Cette commande exécute Maven pour compiler le projet
            }
        }

        stage('Tests Maven') {
            steps {
                echo 'Exécution des tests...'
                sh 'mvn test' // Cette commande exécute les tests unitaires
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Création de l\'image Docker...'
                script {
                    docker.build(DOCKER_IMAGE)
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                echo 'Push de l\'image Docker sur Docker Hub...'
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                        docker.image(DOCKER_IMAGE).push("latest")
                    }
                }
            }
        }

        stage('Déploiement') {
            steps {
                echo 'Déploiement de l\'application...'
                // Vous pouvez ici lancer un conteneur ou déployer sur un serveur
            }
        }
    }

    post {
        always {
            echo 'Pipeline terminé'
        }
        success {
            echo 'Pipeline terminé avec succès'
        }
        failure {
            echo 'Pipeline échoué'
        }
    }
}
