pipeline {
    agent { label 'macos' }  // Ensures it runs on a Mac machine

    environment {
        DOCKER_IMAGE = 'your-image-name'
        DOCKER_REPO = 'your-dockerhub-repo'
        DOCKER_USER = credentials('docker-hub-username')  // Store in Jenkins Credentials
        DOCKER_PASS = credentials('docker-hub-password')  // Store in Jenkins Credentials
    }

    stages {
        stage('Build') {
            steps {
                script {
                    sh 'echo "Building project..."'
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh 'echo "Running tests..."'
                    sh 'mvn test'
                }
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    sh 'echo "Building Docker image..."'
                    sh "docker build -t $DOCKER_IMAGE ."

                    sh 'echo "Logging into Docker Hub..."'
                    sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"

                    sh 'echo "Pushing image to Docker Hub..."'
                    sh "docker tag $DOCKER_IMAGE $DOCKER_REPO/$DOCKER_IMAGE"
                    sh "docker push $DOCKER_REPO/$DOCKER_IMAGE"
                }
            }
        }
    }
}
