package romannumber

import spock.lang.*


class RomanNumberParseSpec extends Specification {


    def "parse roman numbers I up to X"() {

        expect:
        RomanNumbers.parse(r) == n

        where:
        n << [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        r << ['I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX', 'X']
    }


    def "parse roman numbers"() {

        expect:
        RomanNumbers.parse(r) == n

        where:
        n << [20, 30, 40, 44, 49, 50, 54, 59, 100, 499, 500, 1000, 3999]
        r << ['XX', 'XXX', 'XL', 'XLIV', 'XLIX', 'L', 'LIV', 'LIX', 'C',
              'CDXCIX', 'D', 'M', 'MMMCMXCIX']
    }


    def "roman number to parse must be valid"() {

        when:
        RomanNumbers.parse(r)

        then:
        thrown(IllegalArgumentException)

        where:
        r << ['', 'XO', 'VIV', 'IXI', 'VIIII', 'XIXI', 'IC', 'VVI', 'LL']
    }
}