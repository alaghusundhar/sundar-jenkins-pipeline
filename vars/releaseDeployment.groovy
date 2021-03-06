import groovy.transform.Field

@Field String stepName = getClass().name

void call (body) {
    Map config = [
        branchName: '',
        dataCenters: '',
        repositoryName: '',
        environmentNames: '',
        releaseTagName: '']
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    writeInner(config)
}

void writeInner(Map config) {
    List filesList = fetchKustomization(dataCenters: config.dataCenters,buildDirectoryName: config.repositoryName, environmentNames: config.environmentNames, extensions: 'kustomization.yaml,kustomization.yml')
    print ("Loop Executed Successfully")
}