package fsm.statemachine;

import fsm.description.DFADescriptionValidationUtil;
import fsm.description.FSMDescription;
import fsm.description.NFADescriptionValidationUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class FSMDescriptionBuilder {

    private FSM.FSMType type;
    private Map<String, FSM.State> states = new HashMap<>();

    private Set<FSM.Transition> transitions = new HashSet<>();
    private Set<FSM.State> initialStates = new HashSet<>();

    public FSMDescriptionBuilder withType(FSM.FSMType type) {

        this.type = type;

        return this;
    }


    public FSMDescriptionBuilder withDescription(FSMDescription description) {

        switch (type) {
            case DFA:
                DFADescriptionValidationUtil.validate(description);

            case NFA:
                NFADescriptionValidationUtil.validate(description);
        }

        initStates(description);
        initTransitions(description);

        return this;
    }


    public FSM build() {

        switch (type) {
            case DFA:
                return new DFA(transitions, initialStates.iterator().next());

            case NFA:
                return new NFA(transitions, initialStates);

            default:
                throw new IllegalStateException();
        }
    }


    private void initStates(FSMDescription description) {

        for (Map.Entry<String, FSMDescription.State> e : description.states.entrySet()) {
            FSM.State state = new FSM.State(e.getValue().initial, e.getValue().accepting);
            states.put(e.getKey(), state);

            if (state.initial) {
                initialStates.add(state);
            }
        }
    }


    private void initTransitions(FSMDescription description) {

        for (Map.Entry<String, FSMDescription.State> e : description.states.entrySet()) {
            for (FSMDescription.Transition transition : e.getValue().transitions) {
                addTransitions(states.get(e.getKey()), transition);
            }
        }
    }


    private void addTransitions(FSM.State state, FSMDescription.Transition transition) {

        for (String symbol : transition.symbols) {
            String target = transition.target;

            if (symbol.isEmpty()) {
                transitions.add(new FSM.Transition(FSM.EPSILON, state, states.get(target)));
            } else {
                transitions.add(new FSM.Transition(symbol, state, states.get(target)));
            }
        }
    }
}
