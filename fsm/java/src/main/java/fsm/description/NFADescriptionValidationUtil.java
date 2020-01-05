package fsm.description;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import static java.util.Collections.emptySet;


public class NFADescriptionValidationUtil {

    private NFADescriptionValidationUtil() {
    }

    public static void validate(FSMDescription description) {

        assertAlphabetNotEmpty(description);
        assertStatesNotEmpty(description);
        assertTransitions(description);
    }


    static void assertAlphabetNotEmpty(FSMDescription description) {

        if (description.alphabet == null || description.alphabet.isEmpty()) {
            throw new IllegalArgumentException("The alphabet must not be empty");
        }
    }


    static void assertStatesNotEmpty(FSMDescription description) {

        if (description.states == null || description.states.isEmpty()) {
            throw new IllegalArgumentException("At least one state is required");
        }
    }


    static void assertTransitions(FSMDescription description) {

        assertTransitions(description, state -> { });
    }


    static void assertTransitions(FSMDescription description, //
        Consumer<FSMDescription.State> stateConsumer) {

        for (Map.Entry<String, FSMDescription.State> e : description.states.entrySet()) {
            FSMDescription.State state = e.getValue();
            stateConsumer.accept(state);

            Set<FSMDescription.Transition> transitions = state.transitions == null //
                ? emptySet() : state.transitions;

            for (FSMDescription.Transition transition : transitions) {
                if (description.states.get(transition.target) == null) {
                    throw new IllegalArgumentException("Invalid transition target state");
                }
            }
        }
    }
}
