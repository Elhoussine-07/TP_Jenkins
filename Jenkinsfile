pipeline {
    agent { label 'maven-agent' }

    environment {
        App_NAME = 'jenkins-pipeline'
        DEPLOY_DIR = '/opt/apps/mon-application'
    }

    stages {
        stage('checkout') {
            steps {
                checkout scm
            }
        }
        stage('build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Tests unitaires') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}