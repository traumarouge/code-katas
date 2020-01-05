package fsm.statemachine;

import java.util.HashSet;
import java.util.Set;


public class NFA implements FSM {

    private final Set<Transition> transitions;
    private final Set<State> initialStates;

    NFA(Set<Transition> transitions, Set<State> initialStates) {

        this.transitions = Set.copyOf(transitions);
        this.initialStates = Set.copyOf(initialStates);
    }

    @Override
    public boolean matches(String input) {

        for (State state : initialStates) {
            if (matches(input, state)) {
                return true;
            }
        }

        return false;
    }


    private boolean matches(String input, State state) {

        if (input.isEmpty()) {
            if (state.accepting) {
                return true;
            }

            return tryEpsilonTransitions(state, input);
        }

        if (tryTransitions(state, input)) {
            return true;
        } else {
            return tryEpsilonTransitions(state, input);
        }
    }


    private boolean tryTransitions(State state, String input) {

        String symbol = String.valueOf(input.charAt(0));

        for (Transition t : nextTransitions(state, symbol)) {
            if (matches(input.substring(1), t.target)) {
                return true;
            }
        }

        return false;
    }


    private boolean tryEpsilonTransitions(State state, String input) {

        for (Transition t : nextEpsilonTransitions(state)) {
            if (matches(input, t.target)) {
                return true;
            }
        }

        return false;
    }


    private Set<Transition> nextTransitions(State state, String symbol) {

        Set<Transition> transitions = new HashSet<>();

        for (Transition t : this.transitions) {
            if (t.source.equals(state) && t.symbol.equals(symbol)) {
                transitions.add(t);
            }
        }

        return transitions;
    }


    private Set<Transition> nextEpsilonTransitions(State state) {

        return nextTransitions(state, FSM.EPSILON);
    }
}
