package romannumber

import spock.lang.Specification


class RomanSymbolSpec extends Specification {


    def "decimal value of roman symbol"() {

        expect:
        RomanSymbol.I.number() == 1
        RomanSymbol.V.number() == 5
        RomanSymbol.X.number() == 10
        RomanSymbol.L.number() == 50
        RomanSymbol.C.number() == 100
        RomanSymbol.D.number() == 500
        RomanSymbol.M.number() == 1000
    }


    def "shift n symbols to the right"() {

        expect:
        RomanSymbol.I >> 0 == RomanSymbol.I
        RomanSymbol.I >> 1 == RomanSymbol.V
        RomanSymbol.I >> 2 == RomanSymbol.X
        RomanSymbol.I >> 4 == RomanSymbol.C
        RomanSymbol.M >> 1 == RomanSymbol.I
        RomanSymbol.M >> 7 == RomanSymbol.M
    }
}