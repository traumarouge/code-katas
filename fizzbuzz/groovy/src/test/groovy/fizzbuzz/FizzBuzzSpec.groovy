package fizzbuzz

import spock.lang.*


class FizzBuzzSpec extends Specification {


    def "say numbers 1 up to 10"() {

        expect:
        FizzBuzz.say(n) == r

        where:
        n << [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        r << ['1', '2', 'fizz', '4', 'buzz', 'fizz', '7', '8', 'fizz', 'buzz']
    }


    def "fizz numbers from 1 up to 50"() {

        expect:
        FizzBuzz.say(n) == 'fizz'

        where:
        n << [3, 6, 9, 12, 18, 21, 24, 27, 33, 36, 39, 42, 48]
    }


    def "buzz numbers from 1 up to 50"() {

        expect:
        FizzBuzz.say(n) == 'buzz'

        where:
        n << [5, 10, 20, 25, 35, 40, 50]
    }


    def "fizzbuzz numbers from 1 up to 100"() {

        expect:
        FizzBuzz.say(n) == 'fizzbuzz'

        where:
        n << [15, 30, 45, 60, 75, 90]

    }


    def "given number must not be less than 1"() {

        when:
        FizzBuzz.say(0)

        then:
        thrown(IllegalArgumentException)
    }
}
