pipeline {
    agent any
    environment {
        URL= 'https://github.com/babeknaan/tp-jenkins.git'
    }
    stages {
        stage('Cloner repo') {
            steps {
                checkout{[
                    $class: 'GitSCM',
                    branches: [[name: "main"]],
                    userRemoteConfigs: [[
                        url: "${URL}",
                    ]]
                ]}
                echo "cloner le projet"
            }
        }
        stage('Build') {
            steps {
                echo 'Build project'
            }
        }
        stage('Test') {
            steps {
                echo 'Test project'
            }
        }
                stage('Deploy') {
            steps {
                echo 'Connect to server'
                echo 'Download configuration'
                echo 'Deploy project'
            }
        }
    }
}