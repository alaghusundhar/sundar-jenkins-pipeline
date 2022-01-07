import static com.kubernetes.Constants.GITHUB_TOOLS_CREDENTIAL_NAME
import static com.kubernetes.Constants.GITHUB_TOOLS_PROD_CONFIG_TOKEN_CREDENTIAL_NAME

void call(body){
    Map config = [
        pipelines: ''
    ]
    pipeline {
        stage ('Checkout Code') {
            parallel {
                stage('Checkout Production Configuration Repository') {
                    steps {
                        script {
                            checkoutGitRepo(repositoryName: 'hello-kubernetes-prod-config', credentialName: GITHUB_TOOLS_CREDENTIAL_NAME, buildDirectoryName: 'hello-kubernetes-prod-config')
                        }
                    }
                }
                stage ('Checkout Development Configuration Repository') {
                    steps {
                        script {
                            checkoutGitRepo(repositoryName: 'hello-kubernetes-dev-config', credentialName: GITHUB_TOOLS_CREDENTIAL_NAME, buildDirectoryName: 'hello-kubernetes-dev-config')
                        }
                    }
                }
            }    
        }
    }
}