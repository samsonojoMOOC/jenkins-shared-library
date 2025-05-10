#!/user/bin/env groovy

def call(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t samsonojo/demo-app:jma-2.0.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push samsonojo/demo-app:jma-2.0.0'
    }
}
