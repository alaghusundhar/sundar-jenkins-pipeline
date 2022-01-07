import static com.kubernetes.Constants.GITHUB_TOOLS_CREDENTIAL_NAME
import static com.kubernetes.Constants.GITHUB_TOOLS_PROD_CONFIG_TOKEN_CREDENTIAL_NAME

void call(body){
    Map config = [
        pipelines: ''
    ]
    pipeline {
        stages {
            stage {
                steps {
                    script {
                        checkoutGitRepo(repositoryName: 'hello-kubernetes-prod-config', credentialName: GITHUB_TOOLS_CREDENTIAL_NAME, buildDirectoryName: 'hello-kubernetes-prod-config')
                    }
                }
            }
        }
    }
}