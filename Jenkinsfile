pipeline {
    agent any
    environment {
        URL_GIT= 'https://github.com/babeknaan/tp-jenkins.git'
        CREDENTIAL_ID="leo_openbar"
    }

    parameters {
        string(name:"version",description:"version du projet")
        choice(name:"environement", choices:["test","preprod","prod"],description:"environnement de deploiement")
    }

    stages {
        stage('Cloner repo') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: "main"]],
                    userRemoteConfigs: [[
                        url: "${URL_GIT}",
                        credentialsId: "${CREDENTIAL_ID}"
                    ]]
                ])
                echo "cloner le projet"
                sh "printenv"
            }
        }
        stage('Build Project') {
            steps {
                sh "chmod +x mvnw"
                sh "./mvnw clean package spring-boot:repackage -Dmaven.test.skip=true"
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
                sshPublisher(
                    publishers: [
                        sshPublisherDesc(
                            configName: 'training-server',  // correspond au Nom de la configuration
                            transfers: [
                                sshTransfer(
                                    sourceFiles: 'target/*.jar',
                                    remoteDirectory: '/tmp',
                                    execCommand: 'ls -al'
                                )
                            ]
                        )
                    ]
                )
                //scp "target/*.jar tmp"
                //ssh -i id_ed25519 
                echo 'Deploy project'
            }
        }
    }
}