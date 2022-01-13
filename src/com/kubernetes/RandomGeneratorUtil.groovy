package com.kubernetes

import java.security.SecureRandom

/**
* The class to generate Random strings.
*/
class RandomGeneratorUtil {

    /**
    * Get the Random String from characterSet.
    */
    static String getRandomString(String characterSet, int length) {
        return  (1..length).collect { characterSet[new SecureRandom().nextInt(characterSet.length())] }.join()
    }
    /**
    * Get the Random String from the combination of letters/digits.
    */
    static String getRandomStringAlphanumeric(int length) {
        return getRandomString((('a'..'z') + ('0'..'9')).join(), length)
    }

}