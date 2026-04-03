pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo '📦 Clonage du dépôt GitHub...'
                checkout scm
                echo '✅ Code source récupéré avec succès'
            }
        }

        stage('Clean') {
            steps {
                echo '🧹 Nettoyage du projet...'
                sh 'mvn clean'
                echo '✅ Nettoyage terminé'
            }
        }

        stage('Compile') {
            steps {
                echo '🔨 Compilation du code source...'
                sh 'mvn compile'
                echo '✅ Compilation réussie'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Exécution des tests unitaires...'
                sh 'mvn test'
                echo '✅ Tests exécutés avec succès'
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
                echo '📦 Packaging du projet...'
                sh 'mvn package -DskipTests'
                echo '✅ Package créé avec succès'
            }
            post {
                success {
                    // Archiver le JAR généré
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }

    post {
        always {
            echo '🏁 Pipeline terminé'
        }
        success {
            echo '✅ Pipeline réussi !'
            echo '📁 Le JAR est disponible dans les artefacts'
        }
        failure {
            echo '❌ Pipeline échoué !'
            echo '🔍 Vérifiez les logs ci-dessus'
        }
    }
}