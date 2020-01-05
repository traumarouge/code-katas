package fsm.regex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;


public class Regex implements Iterable<Regex.Token> {

    private final String regexRPN;

    private Regex(String regexRPN) {

        this.regexRPN = regexRPN;
    }

    public static Regex of(String input) {

        StringBuilder output = new StringBuilder();
        Deque<Character> operators = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            if (isOperator(c)) {
                output.append(popHigherOp(operators, c));
                operators.push(c);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                output.append(popUntilOpeningBrace(operators));
            } else {
                output.append(c);
            }
        }

        output.append(popAllOps(operators));

        return new Regex(output.toString());
    }


    private static boolean isOperator(char c) {

        return c == '*' || c == '.' || c == '+';
    }


    private static char[] popHigherOp(Deque<Character> stack, char op) {

        if (!stack.isEmpty() && op == '.' && stack.peek() == '*') {
            return new char[] { stack.pop() };
        }

        if (!stack.isEmpty() && op == '+' //
                && (stack.peek() == '*' || stack.peek() == '.')) {
            return new char[] { stack.pop() };
        }

        return new char[0];
    }


    private static char[] popUntilOpeningBrace(Deque<Character> stack) {

        StringBuilder sb = new StringBuilder();

        // noinspection ConstantConditions
        while (stack.peek() != '(') {
            sb.append(stack.pop());
        }

        stack.pop();

        return sb.toString().toCharArray();
    }


    private static char[] popAllOps(Deque<Character> stack) {

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString().toCharArray();
    }


    @Override
    public Iterator<Token> iterator() {

        return new TokenIterator();
    }

    private class TokenIterator implements Iterator<Token> {

        private int pos = 0;

        @Override
        public boolean hasNext() {

            return pos < regexRPN.length();
        }


        @Override
        public Token next() {

            return new Token(regexRPN.charAt(pos++));
        }
    }

    public static class Token {

        private final char value;

        private Token(char value) {

            this.value = value;
        }

        public boolean isOperator() {

            return Regex.isOperator(value);
        }


        public char getValue() {

            return value;
        }
    }
}
