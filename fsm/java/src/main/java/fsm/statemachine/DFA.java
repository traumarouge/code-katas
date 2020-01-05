package fsm.statemachine;

import java.util.Set;


class DFA implements FSM {

    private final Set<Transition> transitions;
    private final State initialState;

    DFA(Set<Transition> transitions, State initialState) {

        this.transitions = Set.copyOf(transitions);
        this.initialState = initialState;
    }

    @Override
    public boolean matches(String input) {

        State state = initialState;

        for (char c : input.toCharArray()) {
            String symbol = String.valueOf(c);
            Transition transition = nextTransition(state, symbol);
            state = transition.target;
        }

        return state.accepting;
    }


    private Transition nextTransition(State state, String symbol) {

        for (Transition transition : transitions) {
            if (isApplicable(state, transition, symbol)) {
                return transition;
            }
        }

        throw new IllegalStateException();
    }


    private boolean isApplicable(State state, Transition transition, String symbol) {

        return transition.source.equals(state) && transition.symbol.equals(symbol);
    }
}
