package fsm.statemachine;

import fsm.regex.Regex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


public class FSMRegexBuilder {

    private Deque<Set<Transition>> stack = new ArrayDeque<>();

    public FSMRegexBuilder withRegex(Regex regex) {

        for (Regex.Token token : regex) {
            if (token.isOperator()) {
                performOperation(token);
            } else {
                String symbol = String.valueOf(token.getValue());
                pushPrimitiveStateMachineTransitions(symbol);
            }
        }

        return this;
    }


    public FSM build() {

        Set<Transition> builderTransitions = stack.pop();

        if (!stack.isEmpty()) {
            throw new IllegalStateException();
        }

        Map<UUID, FSM.State> states = new HashMap<>();

        for (Transition t : builderTransitions) {
            states.putIfAbsent(t.source.uuid, //
                new FSM.State(t.source.initial, t.source.accepting));
            states.putIfAbsent(t.target.uuid, //
                new FSM.State(t.target.initial, t.target.accepting));
        }

        Set<FSM.Transition> transitions = new HashSet<>();
        Set<FSM.State> initialStates = new HashSet<>();

        for (Transition t : builderTransitions) {
            transitions.add(new FSM.Transition(t.symbol, //
                    states.get(t.source.uuid), //
                    states.get(t.target.uuid)));

            if (t.source.initial) {
                initialStates.add(states.get(t.source.uuid));
            }
        }

        return new NFA(transitions, initialStates);
    }


    private void performOperation(Regex.Token token) {

        switch (token.getValue()) {
            case '*':
                pushClosureOfStateMachineTransitions();
                break;

            case '.':
                pushConcatenationOfStateMachineTransitions();
                break;

            case '+':
                pushUnionOfStateMachineTransitions();
                break;

            default:
                throw new IllegalArgumentException();
        }
    }


    private void pushPrimitiveStateMachineTransitions(String symbol) {

        Set<Transition> transitions = new HashSet<>();

        State source = new State();
        source.initial = true;

        State target = new State();
        target.accepting = true;

        Transition transition = new Transition();
        transition.symbol = symbol;
        transition.source = source;
        transition.target = target;

        transitions.add(transition);

        stack.push(transitions);
    }


    private void pushConcatenationOfStateMachineTransitions() {

        Set<Transition> transitions = new HashSet<>();

        State connectingState = null;

        for (Transition t : stack.pop()) {
            if (t.source.initial) {
                t.source.initial = false;
                connectingState = t.source;
            }

            transitions.add(t);
        }

        for (Transition t : stack.pop()) {
            if (t.target.accepting) {
                t.target = connectingState;
            }

            transitions.add(t);
        }

        stack.push(transitions);
    }


    private void pushUnionOfStateMachineTransitions() {

        Set<Transition> transitions = new HashSet<>();

        State initialStateTargetR = null;
        State acceptingStateSourceR = null;

        for (Transition t : stack.pop()) {
            if (t.source.initial) {
                t.source.initial = false;
                initialStateTargetR = t.source;
            }

            if (t.target.accepting) {
                t.target.accepting = false;
                acceptingStateSourceR = t.target;
            }

            transitions.add(t);
        }

        State initialStateTargetL = null;
        State acceptingStateSourceL = null;

        for (Transition t : stack.pop()) {
            if (t.source.initial) {
                t.source.initial = false;
                initialStateTargetL = t.source;
            }

            if (t.target.accepting) {
                t.target.accepting = false;
                acceptingStateSourceL = t.target;
            }

            transitions.add(t);
        }

        State initialState = new State();
        initialState.initial = true;

        State acceptingState = new State();
        acceptingState.accepting = true;

        transitions.add(epsilon(initialState, initialStateTargetL));
        transitions.add(epsilon(initialState, initialStateTargetR));
        transitions.add(epsilon(acceptingStateSourceL, acceptingState));
        transitions.add(epsilon(acceptingStateSourceR, acceptingState));

        stack.push(transitions);
    }


    private void pushClosureOfStateMachineTransitions() {

        Set<Transition> transitions = new HashSet<>();

        State initialStateTarget = null;
        State acceptingStateSource = null;

        for (Transition t : stack.pop()) {
            if (t.source.initial) {
                t.source.initial = false;
                initialStateTarget = t.source;
            }

            if (t.target.accepting) {
                t.target.accepting = false;
                acceptingStateSource = t.target;
            }

            transitions.add(t);
        }

        State initialState = new State();
        initialState.initial = true;

        State acceptingState = new State();
        acceptingState.accepting = true;

        transitions.add(epsilon(initialState, acceptingState));
        transitions.add(epsilon(initialState, initialStateTarget));
        transitions.add(epsilon(acceptingStateSource, acceptingState));
        transitions.add(epsilon(acceptingStateSource, initialStateTarget));

        stack.push(transitions);
    }


    private Transition epsilon(State source, State target) {

        Transition transition = new Transition();

        transition.symbol = FSM.EPSILON;
        transition.source = source;
        transition.target = target;

        return transition;
    }

    private static class State {

        private UUID uuid;
        private boolean initial;
        private boolean accepting;

        public State() {

            uuid = UUID.randomUUID();
        }
    }

    private static class Transition {

        private String symbol;
        private State source;
        private State target;
    }
}
