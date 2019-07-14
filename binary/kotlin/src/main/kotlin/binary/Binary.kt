package binary

const val BYTE_SIZE = 8


fun Char.isBinary() = when (this) {
    '0', '1' -> true
    else -> false
}


fun flipBit(bit: Char): Char = when (bit) {
    '0' -> '1'
    '1' -> '0'
    else -> throw IllegalArgumentException()
}


fun String.isBinary() = !isEmpty() && all { it.isBinary() }


fun toBinary(number: Long): String {
    if (number < 0) throw IllegalArgumentException()

    if (number == 0L) return "0"

    val sb = StringBuilder()
    var n = number

    while (n > 0) {
        sb.insert(0, n.rem(2)).also { n /= 2 }
    }

    return sb.toString()
}


fun expandToBytes(binary: String): String = StringBuilder().apply {
    if (!binary.isBinary()) throw IllegalArgumentException()

    binary.reversed().forEach { append(it) }

    repeat((BYTE_SIZE - length.rem(BYTE_SIZE)).rem(BYTE_SIZE)) {
        append('0')
    }
}.reversed().toString()


fun onesComplement(binary: String): String = StringBuilder().apply {
    if (binary.length.rem(BYTE_SIZE) != 0
            || !binary.isBinary()) throw IllegalArgumentException()

    binary.reversed().map { append(flipBit(it)) }
}.reversed().toString()


fun twosComplement(binary: String): String = StringBuilder().apply {
    onesComplement(binary).reversed().fold(true) { carryBit, bit ->
        if (carryBit) {
            if (bit == '1') {
                true.also { append(flipBit(bit)) }
            } else {
                false.also { append(flipBit(bit)) }
            }
        } else false.also { append(bit) }
    }
}.reversed().toString()