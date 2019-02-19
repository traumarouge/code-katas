package atbash


val alphabet: Array<Char> = Array(26) { i -> 'a' + i }

fun Array<Char>.code(c: Char): Char {
    return this[size - indexOf(c) - 1]
}

fun String.normalize(): String = toLowerCase().filter {
    alphabet.contains(it) || it.isDigit()
}

fun encode(plainText: String) = StringBuilder().apply {
    plainText.normalize().forEachIndexed { index, c ->
        if (index > 0 && index % 5 == 0) append(' ')

        if (c.isDigit()) append(c)
        else append(alphabet.code(c))
    }
}.toString()

fun decode(cipherText: String) = StringBuilder().apply {
    cipherText.normalize().forEach { c ->
        if (c.isDigit()) append(c)
        else append(alphabet.code(c))
    }
}.toString()
