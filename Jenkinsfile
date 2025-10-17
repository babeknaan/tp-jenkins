pipeline {
    agent any
    environment {
        URL_GIT= 'https://github.com/babeknaan/tp-jenkins.git'
    }

    parameters {
        string(name:"version",description:"version du projet")
        choice(name:"environement", choices:["test","preprod","prod"],description:"environnement de deploiement")
    }

    stages {
        stage('Cloner repo') {
            steps {
                checkout{[
                    $class: 'GitSCM',
                    branches: [[name: "main"]],
                    userRemoteConfigs: [[
                        url: "${URL_GIT}",
                    ]]
                ]}
                echo "cloner le projet"
                sh "printenv"
            }
        }
        stage('Build Project') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package spring-boot:repackage -Dmaven.test.skip=true'
            }
        }
        stage('Test') {
            steps {
                echo 'Test project'
            }
        }
                stage('Deploy') {
            steps {
                echo "Environnement : ${params.environement}"
                scp "target/*.jar tmp"
                echo 'Deploy project'
            }
        }
    }
}