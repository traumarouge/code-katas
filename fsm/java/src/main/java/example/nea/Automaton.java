package example.nea;

import java.util.Arrays;


class Automaton {

    enum Symbol {

        A,
        B
    }

    enum State {

        Q1(false) {

            @Override
            State[] next(Symbol symbol) {

                switch (symbol) {
                    case A:
                        return new State[] { this, Q2 };

                    case B:
                        return new State[] { this };
                }

                throw new IllegalStateException();
            }
        },

        Q2(false) {

            @Override
            State[] next(Symbol symbol) {

                switch (symbol) {
                    case A:
                    case B:
                        return new State[] { Q3 };
                }

                throw new IllegalStateException();
            }
        },

        Q3(true) {

            @Override
            State[] next(Symbol symbol) {

                switch (symbol) {
                    case A:
                    case B:
                        return new State[] {};
                }

                throw new IllegalStateException();
            }
        };

        private boolean accepting;

        State(boolean accepting) {

            this.accepting = accepting;
        }

        static State startState() {

            return Q1;
        }


        abstract State[] next(Symbol symbol);
    }

    private State state;

    Automaton() {

        this.state = State.startState();
    }

    boolean matches(Symbol[] word) {

        return matches(word, state);
    }


    boolean matches(Symbol[] word, State state) {

        if (word.length == 0) {
            return state.accepting;
        }

        for (State nextState : state.next(word[0])) {
            Symbol[] remainingWord = word.length == 1 //
                ? new Symbol[0] : Arrays.copyOfRange(word, 1, word.length);

            if (matches(remainingWord, nextState)) {
                return true;
            }
        }

        return false;
    }
}
