class Charsets {
    companion object {
        val set1 = ('A'..'Z').joinToString("") + ('a'..'z').joinToString("")
        val set2= set1 + ('0'..'9').joinToString("")
        val set3 = set2 + ("!@#$%^&*()_+-=[]{}|;:,.<>?'" + '"').toList().joinToString("")
    }

}

