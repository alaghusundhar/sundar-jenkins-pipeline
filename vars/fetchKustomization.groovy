// Author : Alagusundaram Nithyanandam

List call (Map parameters = [:]) {

    List files = []
    List dataCentersList = parameters.dataCenters.split(',')
    List environmentNamesList = parameters.environmentNames.split(',')
    List extensionList = parameters.extensions.split(',')

    banner.echoBanner('overlayFiles')
    for (datacenter in dataCentersList) {
        for (environmentName in environmentNamesList) {
            for (extension in extensionList) {
                files.addAll(findFiles(glob: "**/${parameters.buildDirectoryname}/${dataCenter}/${environmentName}/${extension}"))
            }   
        }
    }
    return files
}