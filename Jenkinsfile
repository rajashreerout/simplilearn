pipeline {
  environment {
    registry = "rajashreerout/simplilearn"
    registryCredential = 'dockerhub'
  }
  agent any
  stages {
    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }

    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry( '', 'dockerhub' ) {
            dockerImage.push()
          }
        }
      }
    }

    stage('Remove Image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
 
  }
}

node {
    stage('Execute Image'){
        def customImage = docker.build("rajashreerout/simplilearn:${env.BUILD_NUMBER}")
        customImage.inside {
            sh 'echo Hello'
        }
    }
}
