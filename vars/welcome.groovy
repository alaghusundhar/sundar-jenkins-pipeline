import static com.kubernetes.Constants.GITHUB_TOOLS_CREDENTIAL_NAME
import static com.kubernetes.Constants.GITHUB_TOOLS_PROD_CONFIG_TOKEN_CREDENTIAL_NAME

void call(body) {
    Map config = [
        sample: ''
    ]
    String strBranchName = ''
    String strRepositoryName =''
    String strServiceName =''
    pipeline { 
        agent any
        stages {
            stage ("Set Local Parameters") {
                steps {
                    strBranchName = generateBranch()
                    strServiceName = "${SVC_NAME}"
                }
            }
            stage ("Checkout Code"){
                steps {
                    checkoutGitRepo(repositoryName: 'hello-kubernetes-prod-config', credentialName: GITHUB_TOOLS_CREDENTIAL_NAME, buildDirectoryName: 'hello-kubernetes-prod-config')
                }
            }
            stage ("Create Branch") {
                steps {
                    createBranch {
                        branchName = strBranchName
                        repositoryName = getRepositoryInfo(strServiceName: strServiceName)
                    }
                }
            }
        }
    }
}
