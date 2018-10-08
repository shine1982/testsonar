pipeline {
    agent any

    stages {

        stage('SCM') {
                steps {
                    git url: 'https://github.com/shine1982/testsonar.git'
                }
         }
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
        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    // Requires SonarQube Scanner for Jenkins 2.7+
                    waitForQualityGate abortPipeline: true

                }
            }
        }
    }
}