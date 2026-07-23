def call(String action = 'package') {
    switch(action.toLowerCase()) {
        case 'clean':
            stage('clean the package') {
                sh 'mvn clean'
            }
            break
        case 'test':
            stage('test the package') {
                sh 'mvn test'
            }
            break
        case 'deploy':
            stage('deploy the package') {
                sh 'mvn deploy'
                echo 'deploy completed successfully'
            }
            break
        default:
            stage('maven build') {
                sh "mvn ${action}"
            }
            break
    }
}
