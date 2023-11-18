import java.lang.Thread.sleep
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread


fun main() {

    val charset = Charsets.set1.toCharArray()
    val stop = AtomicBoolean(false)
    val tries = AtomicLong(0)
    val lengths = 4..9



    print("Password: ")
    val password = readln()

    val startTime = System.currentTimeMillis()
    val threads = lengths.map { length ->
        thread {
            bruteForce(password, charset, length, stop, tries)
        }
    }


    while (!stop.get()) {
        sleep(1)
    }
    val endTime = System.currentTimeMillis()

    println("Password cracked in ${milliSecondsFormatter(endTime - startTime)} and after $tries tries")

}

fun milliSecondsFormatter(number: Long): String {
    val milliseconds = number % 1000
    val seconds = (number / 1000) % 60
    val minutes = (number / (1000 * 60)) % 60
    val hours = (number / (1000 * 60 * 60)) % 24

    return String.format("%02dh %02dm %02ds %dms", hours, minutes, seconds, milliseconds)
}

fun bruteForce(password: String, charset: CharArray, length: Int, stopFlag: AtomicBoolean, passwordTries: AtomicLong) {
    val maxIndex = charset.size - 1
    val checkEnd = buildString { repeat(length) { append(charset[maxIndex]) } }

    var tries = 0L
    while (!stopFlag.get()) {
        passwordTries.incrementAndGet()
        val attempt = generateAttempt(charset, length, tries++)
        if (attempt == password) {
            stopFlag.set(true)
        }

        if (attempt == checkEnd) {
            break
        }
    }
}

fun generateAttempt(charset: CharArray, length: Int, index: Long): String {
    val attempt = StringBuilder(length)
    var remainingIndex = index
    for (i in 0..<length) {
        val charIndex = (remainingIndex % charset.size).toInt()
        attempt.append(charset[charIndex])
        remainingIndex /= charset.size
    }
    return attempt.toString()
}
