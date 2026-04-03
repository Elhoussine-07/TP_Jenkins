pipeline {
    // Agent Docker avec Maven
    agent any

    // Variables d'environnement
    environment {
        MAVEN_HOME = tool 'Maven-3.8.4'
        JAVA_HOME = tool 'JDK-11'
    }

    // Étapes du pipeline
    stages {
        stage('Checkout') {
            steps {
                echo 'Clonage du dépôt GitHub...'
                checkout scm
                echo 'Code source récupéré avec succès'
            }
        }

        stage('Clean') {
            steps {
                echo 'Nettoyage du projet...'
                sh 'mvn clean'
                echo 'Nettoyage terminé'
            }
        }

        stage('Compile') {
            steps {
                echo 'Compilation du code source...'
                sh 'mvn compile'
                echo 'Compilation réussie'
            }
        }

        stage('Test') {
            steps {
                echo 'Exécution des tests unitaires...'
                sh 'mvn test'
                echo 'Tests exécutés avec succès'
            }
            post {
                always {
                    // Publier les résultats des tests JUnit
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging du projet...'
                sh 'mvn package -DskipTests'
                echo 'Package créé avec succès'
            }
            post {
                success {
                    // Archiver le JAR généré
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Analyse SonarQube...'
                // Décommenter si SonarQube est configuré
                // withSonarQubeEnv('SonarQube') {
                //     sh 'mvn sonar:sonar'
                // }
                echo 'Analyse terminée'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Construction de l\'image Docker...'
                sh '''
                    docker build -t mon-projet-java:latest .
                '''
                echo 'Image Docker construite avec succès'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Déploiement...'
                sh '''
                    # Arrêter et supprimer l'ancien conteneur s'il existe
                    docker stop mon-projet-java || true
                    docker rm mon-projet-java || true

                    # Lancer le nouveau conteneur
                    docker run -d --name mon-projet-java -p 8080:8080 mon-projet-java:latest
                '''
                echo 'Application déployée avec succès'
            }
        }
    }

    // Post-actions
    post {
        always {
            echo 'Pipeline terminé'
            // Nettoyer les ressources Docker
            sh 'docker system prune -f || true'
        }
        success {
            echo '✅ Pipeline réussi !'
            // Envoyer une notification (Slack, Email, etc.)
        }
        failure {
            echo '❌ Pipeline échoué !'
            // Envoyer une alerte
        }
    }
}