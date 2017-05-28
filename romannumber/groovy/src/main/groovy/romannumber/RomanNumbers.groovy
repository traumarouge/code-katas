package romannumber


class RomanNumbers {


    static String format(int number) {
        if (!(number in 1..3999)) {
            throw new IllegalArgumentException()
        }

        def romanNumbers = []
        number.toString().reverse().eachWithIndex { digit, index ->
            romanNumbers << romanNumber(digit.toInteger(), index)
        }

        romanNumbers.reverse().join('')
    }


    private static String romanNumber(int decimalDigit, int index) {
        int digit = decimalDigit
        boolean less5 = true

        if (digit in 5..9) {
            digit -= 5
            less5 = false
        }

        RomanSymbol romanSymbol = RomanSymbol.values()[index * 2]
        StringBuilder sb = new StringBuilder()
        sb << (less5 ? '-' : romanSymbol >> 1)
        digit.times { sb << romanSymbol }

        if (sb.size() > 4) {
            def collapse = { sb.delete(0, 4) << it }
            collapse(romanSymbol >> (less5 ? 1 : 2))
        }

        sb.replaceAll('-', '')
    }


    static int parse(String romanNumber) {
        def romanSymbols = []
        romanNumber.each { romanSymbols << (it as RomanSymbol) }

        int number = decimalNumber(romanSymbols)
        if (format(number) != romanNumber) {
            throw new IllegalArgumentException()
        }

        number
    }


    private static int decimalNumber(List romanSymbols) {
        def numbers = []
        def sum = 0

        def lastRomanSymbol = null
        romanSymbols.reverseEach {
            if (lastRomanSymbol && it < lastRomanSymbol) {
                sum -= it.number()
                numbers << sum
                sum = 0
            } else {
                sum += it.number()
            }

            lastRomanSymbol = it
        }

        (numbers << sum).inject(0) { a, b -> a + b }
    }
}