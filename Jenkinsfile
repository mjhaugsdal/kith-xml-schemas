pipeline {

    agent{
        node{
            label 'master'
        }
    }

    tools {
        maven 'Maven 3.6'
        jdk 'JDK 8'
    }

    stages {
        stage('Build parent pom') {
            steps {
                sh 'cd xmlbeans-parent/ && mvn clean install deploy'
           }
        }
         stage('Build xmlbeans') {
            steps {
                sh 'mvn clean deploy -T 1C -f xmlbeans-aggregated/pom.xml'

            }
        }
        stage('Build xmlbeans-bom') {
            steps {

                sh 'cd xmlbeans-bom/ && mvn clean compile deploy'
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
