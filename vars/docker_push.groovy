def call(String Project, String ImageTag, String dockerhubuser){

    withCredentials([
        usernamePassword(
            credentialsId: 'docker',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        echo "docker push loaded"
        sh """
            docker login -u \$DOCKER_USER -p \$DOCKER_PASS
            docker push ${dockerhubuser}/${Project}:${ImageTag}
        """
    }
}
