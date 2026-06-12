def call(){
    sh '''
    trivy fs \
    --scanners vuln \
    --timeout 15m \
    .
    '''
}
