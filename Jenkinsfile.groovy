@Library('mysharedlibrary') _
pipeline{
    agent any
    tools{
        maven 'maven3.9.16',
        jdk 'java21'
    }

    stages
    {
        stage('clean'){
            steps{
                mavenBuild('clean'')

            }
         
        }

        stage('testing'){
            steps{
                mavenBuild('test')
            }

        }

        stage('deploying'){
            steps{
                mavenBuild('deploy')
            }
        }
    }
}
