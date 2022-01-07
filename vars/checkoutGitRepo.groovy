import com.kubernetes.Constants

void call(Map config = [:]){
    String branchName = config.branchName ?: 'main'
    dir(config.buildDirectoryName) {
        String gitUrl = Constants.GITHUB_TOOLS_URL + '/' + config.repositoryName
        git credentialId: config.credentialName, url: gitUrl, branch: config.buildDirectoryName
        sh script: 'git config user.email :jenkinsCICD@sap.com'
        sh script: "git config user.name ${config.credentialName}"
    }
}
