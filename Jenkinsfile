pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('SonarQube analysis') {

            withSonarQubeEnv('sonar local server') {
              // requires SonarQube Scanner for Maven 3.2+
              sh 'mvn sonar:sonar'
            }
          }
    }
}