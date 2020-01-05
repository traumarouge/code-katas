package example.dea;

class Automaton {

    enum Symbol {

        A,
        B
    }

    enum State {

        BB(false) {

            @Override
            State next(Symbol symbol) {

                switch (symbol) {
                    case A:
                        return BA;

                    case B:
                        return this;
                }

                throw new IllegalStateException();
            }
        },

        BA(false) {

            @Override
            State next(Symbol symbol) {

                switch (symbol) {
                    case A:
                        return AA;

                    case B:
                        return AB;
                }

                throw new IllegalStateException();
            }
        },

        AA(true) {

            @Override
            State next(Symbol symbol) {

                switch (symbol) {
                    case A:
                        return this;

                    case B:
                        return AB;
                }

                throw new IllegalStateException();
            }
        },

        AB(true) {

            @Override
            State next(Symbol symbol) {

                switch (symbol) {
                    case A:
                        return BA;

                    case B:
                        return BB;
                }

                throw new IllegalStateException();
            }
        };

        private boolean accepting;

        State(boolean accepting) {

            this.accepting = accepting;
        }

        static State startState() {

            return BB;
        }


        abstract State next(Symbol symbol);
    }

    private State state;

    Automaton() {

        this.state = State.startState();
    }

    boolean matches(Symbol[] word) {

        for (Symbol symbol : word) {
            state = state.next(symbol);
        }

        return state.accepting;
    }
}
