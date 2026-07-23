pipeline{
    agent any
    tools{
        maven 'maven3.9.16'
        jdk 'java21'
    }
    parameters{
        booleanParam(name:'skip_process', defaultValue: false, description: 'skips specific process')
    

    }
    stages{
        stage('pull code from git hub'){
            steps{
                git branch:'main', url:'https://github.com/Kamal118-tech/testfbdemo.git'
            }
        }
        stage('clean package'){
            steps{
                sh 'mvn clean'
            }
        }

        stage('compile package'){
            steps{
                sh 'mvn compile'
            }
        }
        
        stage('test package'){
            when{
                expression{!params.skip_process}
            }
            steps{
                sh 'mvn test'
            }
        }  
        stage('create package'){
            steps{
                sh 'mvn package'
            }
        }
        
        stage('verify package'){
            steps{
                sh 'mvn verify'
            }
        }
        stage('install package'){
            steps{
                sh 'mvn install'
            }
        }
        
        stage('deploy package'){
            steps{
                sh 'mvn deploy'
            }
        }
        
    }
    
}
