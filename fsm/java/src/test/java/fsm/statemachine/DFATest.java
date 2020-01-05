package fsm.statemachine;

import com.fasterxml.jackson.databind.ObjectMapper;

import fsm.description.FSMDescription;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DFATest {

    @ParameterizedTest
    @MethodSource("fsm.statemachine.FSMTestMethodSourceProvider#accepting")
    void dfaAccepting(String input) throws IOException {

        FSMDescription description = fsmDescription(DFATest.class.getResourceAsStream("/fsm/description/dfa.json"));
        assertTrue(new FSMDescriptionBuilder().withType(FSM.FSMType.DFA).withDescription(description).build()
            .matches(input));
    }


    @ParameterizedTest
    @MethodSource("fsm.statemachine.FSMTestMethodSourceProvider#rejecting")
    void dfaRejecting(String input) throws IOException {

        FSMDescription description = fsmDescription(DFATest.class.getResourceAsStream("/fsm/description/dfa.json"));
        assertFalse(new FSMDescriptionBuilder().withType(FSM.FSMType.DFA).withDescription(description).build()
            .matches(input));
    }


    private static FSMDescription fsmDescription(InputStream is) throws IOException {

        return new ObjectMapper().readValue(is, FSMDescription.class);
    }
}
