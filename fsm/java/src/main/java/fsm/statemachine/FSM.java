package fsm.statemachine;

public interface FSM {

    enum FSMType {

        DFA,
        NFA
    }

    String EPSILON = "";

    boolean matches(String input);

    class State {

        final boolean initial;
        final boolean accepting;

        State(boolean initial, boolean accepting) {

            this.initial = initial;
            this.accepting = accepting;
        }
    }

    class Transition {

        final String symbol;
        final State source;
        final State target;

        Transition(String symbol, State source, State target) {

            this.symbol = symbol;
            this.source = source;
            this.target = target;
        }
    }
}
