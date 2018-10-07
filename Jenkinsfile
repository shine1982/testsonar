pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonar local server') {
                  // requires SonarQube Scanner for Maven 3.2+
                  sh 'mvn sonar:sonar'
                }
            }
          }
    }
}