package fsm.description;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import static java.util.Collections.emptySet;


public class DFADescriptionValidationUtil {

    private DFADescriptionValidationUtil() {
    }

    public static void validate(FSMDescription description) {

        assertAlphabetNotEmpty(description);
        assertStatesNotEmpty(description);
        assertInitialState(description);
        assertTransitions(description);
    }


    static void assertAlphabetNotEmpty(FSMDescription description) {

        NFADescriptionValidationUtil.assertAlphabetNotEmpty(description);
    }


    static void assertStatesNotEmpty(FSMDescription description) {

        NFADescriptionValidationUtil.assertStatesNotEmpty(description);
    }


    static void assertInitialState(FSMDescription description) {

        if (description.states.values().stream().filter(s -> s.initial).count() != 1) {
            throw new IllegalArgumentException("Exactly one initial state is required");
        }
    }


    static void assertTransitions(FSMDescription description) {

        Consumer<FSMDescription.State> assertTransitions = state -> {
            Set<String> symbols = new HashSet<>();
            Set<FSMDescription.Transition> transitions = state.transitions == null //
                ? emptySet() : state.transitions;

            for (FSMDescription.Transition transition : transitions) {
                assertDeterministicBehaviour(transition, symbols);
            }

            if (!description.alphabet.equals(symbols)) {
                throw new IllegalArgumentException("State transitions are incomplete");
            }
        };

        NFADescriptionValidationUtil.assertTransitions(description, assertTransitions);
    }


    private static void assertDeterministicBehaviour(FSMDescription.Transition transition, //
        Set<String> symbols) {

        for (String symbol : transition.symbols) {
            if (!symbols.add(symbol)) {
                throw new IllegalArgumentException("Non-deterministic state transitions");
            }
        }
    }
}
