pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'your-image-name'
        DOCKER_REPO = 'your-dockerhub-repo'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build & Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh "docker build -t $DOCKER_IMAGE ."
                    sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
                    sh "docker tag $DOCKER_IMAGE $DOCKER_REPO/$DOCKER_IMAGE"
                    sh "docker push $DOCKER_REPO/$DOCKER_IMAGE"
                }
            }
        }
    }
}
