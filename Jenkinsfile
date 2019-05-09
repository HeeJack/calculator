pipeline {
    agent any
    post{
        always{
            mail to: 'ljw6828@gmail.com',
            subject: "Mail Test, ${currentBuild.fullDisplayName}",
            body: "please check: ${env.BUILD_URL}"
            /*sh "docker stop calculator"*/
	    sh "docker-compose down"
        }
    }
    stages{
        stage ('checkout'){
            steps{
                git url: 'https://github.com/heejack/calculator.git'
            }
        }
        stage(Compile) {
            steps{
                sh './gradlew compileJava'
            }
        }
        stage('Unit test'){
            steps{
                sh "./gradlew test"
            }
        }
        stage('Code Coverage'){
            steps{
                sh './gradlew jacocoTestReport'
                publishHTML (target: [
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                ])
                sh './gradlew jacocoTestCoverageVerification'
            }
        }
        stage('Static code analysis'){
            steps{
                sh './gradlew checkstyleMain'
                publishHTML (target: [
                    reportDir: 'build/reports/checkstyle/',
                    reportFiles: 'main.html',
                    reportName: 'Checkstyle Report'
                    ])
            }
        }
        stage("Package"){
            steps{
                sh "./gradlew build"
            }
        }
        stage("Docker build"){
            steps{
                sh "docker build -t localhost:5000/student/calculator ."
            }
        }
        stage("Docker push"){
            steps{
                sh "docker push localhost:5000/student/calculator"
            }
        }
        stage("Deploy to staging"){
            steps{
                /*sh "docker run -d --rm -p 8090:8090 --name calculator localhost:5000/student/calculator"*/
		sh "docker-compose up -d"
            }
        }
        stage("Acceptance test"){
            steps{
                sleep 20
                sh "./acceptance_test.sh"
            }
        }
    }
}
