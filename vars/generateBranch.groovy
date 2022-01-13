import static com.kubernetes.RandomGeneratorUtil.getRandomStringAlphanumeric

String call() {
    return 'release-' + getRandomStringAlphanumeric(10)
}