pipeline {
	agent any
	tools {
		maven "maven_3_9_5"
	}
	stages {
		stage('Build Maven') {
			steps {
				checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Seulin-D40140/evalHotelFront']]])
				bat 'mvn clean install'
			}
		}
	}
	stage('Build docker image'){
		steps {
			script {
				bat 'docker build -t Seulin-D40140/evalHotelFront .'
			}
		}
	}
}