package romannumber

import spock.lang.*


class RomanNumberFormatSpec extends Specification {


    def "format numbers 1 up to 10"() {

        expect:
        RomanNumbers.format(n) == r

        where:
        n << [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        r << ['I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX', 'X']
    }


    def "format numbers"() {

        expect:
        RomanNumbers.format(n) == r

        where:
        n << [20, 30, 40, 44, 49, 50, 54, 59, 100, 499, 500, 1000, 3999]
        r << ['XX', 'XXX', 'XL', 'XLIV', 'XLIX', 'L', 'LIV', 'LIX', 'C',
              'CDXCIX', 'D', 'M', 'MMMCMXCIX']
    }


    def "number to format must be in range [1..3999]"() {

        when:
        RomanNumbers.format(0)

        then:
        thrown(IllegalArgumentException)

        when:
        RomanNumbers.format(4000)

        then:
        thrown(IllegalArgumentException)
    }
}