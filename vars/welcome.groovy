import static com.kubernetes.Constants.GITHUB_TOOLS_CREDENTIAL_NAME
import static com.kubernetes.Constants.GITHUB_TOOLS_PROD_CONFIG_TOKEN_CREDENTIAL_NAME

void call(body) {
    Map config = [
        sample: ''
    ]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    String strBranchName = ''
    String strRepositoryName =''
    String strServiceName =''
    pipeline { 
        agent any
        stages {
            stage ("Set Local Parameters") {
                steps {
                    script {
                        strBranchName = generateBranch()
                        strServiceName = "${SVC_NAME}"
                        echo "Service Name is ${SVC_NAME}"
                    }
                }
            }
            stage ("Checkout Code"){
                steps {
                    checkoutGitRepo(repositoryName: 'hello-kubernetes-prod-config', credentialName: GITHUB_TOOLS_CREDENTIAL_NAME, buildDirectoryName: 'hello-kubernetes-prod-config')
                }
            }
            stage ("Create Branch") {
                steps {
                    script {
                        createBranch {
                            branchName = strBranchName
                            repositoryName = getRepositoryInfo(serviceName: strServiceName)
                        }
                    }
                    
                }
            }
        }
    }
}
