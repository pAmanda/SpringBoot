pipeline {
    agent any
    stages {
        stage('Build') {
            when{
                expression { GIT_BRANCH != '**/master/*' }
            }
            steps {
                echo 'testing novamente' 
                build job: 'basic-build'
            }
        }
    }
}