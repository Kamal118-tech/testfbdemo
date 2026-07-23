def call(String action = 'package'){
    switch(action.toLowercase()){
        case 'clean':
        stage('clean the package'){
            steps{
                sh 'mvn clean package'
            }
        }
        break

        case 'test':
        stage('tests the package'){
            steps{
                sh 'mvn test'
            }
        }
        break

        case 'deploy':
        stage('deploy the package'){
            steps{
                sh 'mvn deploy'
            }
        }

        default:
            stage('maven build') {
                sh "mvn ${action}"
            }
            break

      
    }
}
