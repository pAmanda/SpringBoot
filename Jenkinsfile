pipeline {
    agent any
    stages {
        stage('Build') {
            when{
                expression { GIT_BRANCH != '**/master/*' }
            }
            steps {
                echo 'testing novamendsadte' 
                build job: 'basic-build'
            }
        }
    }
}