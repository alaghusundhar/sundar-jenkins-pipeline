String call (Map config = [:]) {
    if (config.serviceName.endsWith('-prod-config')) {
        return config.serviceName
    }
    return config.serviceName + '-prod-config'
}