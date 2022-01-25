// Author : Alagusundaram Nithyanandam

List call (Map parameters = [:]) {

    List files = []
    echo "dataCentersList: ${parameters.dataCenters}"
    echo "environmentNamesList: ${parameters.environmentNames}"
    echo "extensionList: ${parameters.extensions}"
    List dataCentersList = parameters.dataCenters.split(',')
    List environmentNamesList = parameters.environmentNames.split(',')
    List extensionList = parameters.extensions.split(',')

    for (datacenter in dataCentersList) {
        for (environmentName in environmentNamesList) {
            for (extension in extensionList) {
                files.addAll(findFiles(glob: "**/${parameters.buildDirectoryname}/${dataCenter}/${environmentName}/${extension}"))
            }   
        }
    }
    return files
}