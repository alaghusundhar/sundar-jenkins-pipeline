boolean call(String branchName) {
    return sh (script: "git rev-parse --verify origin/${branchName}", label: "Check if branch {$branchName} exists", returnStatus: true) == 0
}