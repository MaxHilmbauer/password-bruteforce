import java.security.MessageDigest

class Hasher {

    fun MD5(hashable: String): String {
        return hashString(hashable, "MD5")
    }

    fun SHA256(hashable: String): String {
        return hashString(hashable, "SHA-256")
    }

    private fun hashString(hashable: String, algorithm: String): String {
        return MessageDigest
            .getInstance(algorithm)
            .digest(hashable.toByteArray())
            .fold("") { str, it -> str + "%02x".format(it) }
    }


}