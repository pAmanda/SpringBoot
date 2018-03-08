pipeline {
    agent any
    stages {
        stage('Build') {
            when{
                expression { GIT_BRANCH != '**/master/*' }
            }
            steps {
                echo 'printenv' 
                build job: 'basic-build'
            }
        }
    }
}