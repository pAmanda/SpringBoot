pipeline {
    agent any
    stages{
        stage('Build'){
            when{
                branch 'feature/*'
            }
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
        stage('Deploy to staging'){
            when{
                branch '*/master'
            }
            steps {
                build job: 'deploy-to-stage'
            }
        }
        stage('Deploy to Production'){
            when{
                branch '*/master'
            }
            steps {
                timeout(time:5, unit:'DAYS'){
                    input message: 'Aprove PRODUCTION Deployment?'
                }
                build job: 'deploy-to-prod'
            }
            post {
                success {
                    echo 'Code deployed to Production'
                }
                failure {
                    echo 'Deployment failed.'
                }
            }
        }
    }
}