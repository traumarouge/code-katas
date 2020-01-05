package fsm.description;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class NFADescriptionValidationUtilTest {

    @Test
    void validationFailsOnEmptyAlphabet() {

        FSMDescription description = new FSMDescription();

        description.alphabet = null;

        IllegalArgumentException e1 = assertThrows(IllegalArgumentException.class, //
                () -> DFADescriptionValidationUtil.validate(description));
        assertEquals("The alphabet must not be empty", e1.getMessage());

        description.alphabet = Collections.emptySet();

        IllegalArgumentException e2 = assertThrows(IllegalArgumentException.class, //
                () -> DFADescriptionValidationUtil.validate(description));
        assertEquals("The alphabet must not be empty", e2.getMessage());
    }


    @Test
    void validationFailsOnEmptyStates() {

        FSMDescription description = new FSMDescription();
        description.alphabet = Set.of("a", "b");

        description.states = null;

        IllegalArgumentException e1 = assertThrows(IllegalArgumentException.class, //
                () -> DFADescriptionValidationUtil.validate(description));
        assertEquals("At least one state is required", e1.getMessage());

        description.states = Collections.emptyMap();

        IllegalArgumentException e2 = assertThrows(IllegalArgumentException.class, //
                () -> DFADescriptionValidationUtil.validate(description));
        assertEquals("At least one state is required", e2.getMessage());
    }


    @Test
    void stateTransitionsWithUnknownTarget() {

        FSMDescription.State state = new FSMDescription.State();
        state.initial = true;
        state.accepting = true;

        FSMDescription description = new FSMDescription();
        description.alphabet = Set.of("a", "b");
        description.states = Map.of("q0", state);

        FSMDescription.Transition t1 = new FSMDescription.Transition();
        t1.symbols = Set.of("a");
        t1.target = "unknown state";

        FSMDescription.Transition t2 = new FSMDescription.Transition();
        t2.symbols = Set.of("b");
        t1.target = "unknown state";

        state.transitions = Set.of(t1, t2);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, //
                () -> DFADescriptionValidationUtil.validate(description));
        assertEquals("Invalid transition target state", e.getMessage());
    }
}
