import static com.kubernetes.Constants.GITHUB_TOOLS_CREDENTIAL_NAME
import static com.kubernetes.Constants.GITHUB_TOOLS_PROD_CONFIG_TOKEN_CREDENTIAL_NAME

void call(body) {
    Map config = [
        branchName: '',
        repositoryName: ''
    ]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    processInner(config.branchName, config.repositoryName)
}

void processInner(String branchName, String repositoryName) {
    dir(repositoryName) {
        validateReleaseBranch(branchName)
        createReleaseBranch(branchName)
    }
}

void validateReleaseBranch(String branchName) {
    boolean branchExists = validateBranch(branchName)
}

void createReleaseBranch(String branchName) {
    echo "Branch ${branchName} does not exists already hence creating new branch"
    sh script: 'git checkout', label: 'Git Checkout'
    sh script: "git checkout -b ${branchName}", label: 'Create Branch'
    sh script: "git rebase origin/main"
}