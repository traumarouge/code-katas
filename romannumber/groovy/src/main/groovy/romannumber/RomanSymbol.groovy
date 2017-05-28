package romannumber


enum RomanSymbol {

    I, V, X, L, C, D, M


    int number() {
        switch (this) {
            case I: return 1
            case V: return 5
            case X: return 10
            case L: return 50
            case C: return 100
            case D: return 500
            case M: return 1000
        }

        throw new IllegalStateException()
    }


    RomanSymbol rightShift(int n) {
        RomanSymbol romanSymbol = this
        n.times { romanSymbol++ }
        romanSymbol
    }
}