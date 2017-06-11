package fizzbuzz;

class FizzBuzz {

    static String say(int number) {

        if (number < 1) {
            throw new IllegalArgumentException();
        }

        if (number % 15 == 0) {
            return "fizzbuzz";
        } else if (number % 3 == 0) {
            return "fizz";
        } else if (number % 5 == 0) {
            return "buzz";
        }

        return String.valueOf(number);
    }
}
