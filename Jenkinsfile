pipeline {
    agent any
    stages {
        stage('Build') {
            when{
                expression { GIT_BRANCH != '**/master/*' }
            }
            steps {
                echo 'testindsddsg' 
                build job: 'basic-build'
            }
        }
    }
}