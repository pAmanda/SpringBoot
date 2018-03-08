pipeline {
    agent any
    stages {
        stage('Build') {
            when{
                expression { GIT_BRANCH != '**/master/*' }
            }
            steps {
                echo 'testing' 
                build job: 'basic-build'
            }
        }
    }
}