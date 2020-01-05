package fsm.statemachine;

import com.fasterxml.jackson.databind.ObjectMapper;

import fsm.description.FSMDescription;

import fsm.regex.Regex;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class NFATest {

    @ParameterizedTest
    @MethodSource("fsm.statemachine.FSMTestMethodSourceProvider#accepting")
    void nfaAccepting(String input) throws IOException {

        FSMDescription description = fsmDescription(DFATest.class.getResourceAsStream("/fsm/description/nfa.json"));
        assertTrue(new FSMDescriptionBuilder().withType(FSM.FSMType.NFA).withDescription(description).build()
            .matches(input));
    }


    @ParameterizedTest
    @MethodSource("fsm.statemachine.FSMTestMethodSourceProvider#rejecting")
    void nfaRejecting(String input) throws IOException {

        FSMDescription description = fsmDescription(DFATest.class.getResourceAsStream("/fsm/description/nfa.json"));
        assertFalse(new FSMDescriptionBuilder().withType(FSM.FSMType.NFA).withDescription(description).build()
            .matches(input));
    }


    @ParameterizedTest
    @MethodSource("fsm.statemachine.FSMTestMethodSourceProvider#accepting")
    void epsilonNfaAccepting(String input) throws IOException {

        FSMDescription description = fsmDescription(DFATest.class.getResourceAsStream("/fsm/description/e-nfa.json"));
        assertTrue(new FSMDescriptionBuilder().withType(FSM.FSMType.NFA).withDescription(description).build()
            .matches(input));
    }


    @ParameterizedTest
    @MethodSource("fsm.statemachine.FSMTestMethodSourceProvider#rejecting")
    void epsilonNfaRejecting(String input) throws IOException {

        FSMDescription description = fsmDescription(DFATest.class.getResourceAsStream("/fsm/description/e-nfa.json"));
        assertFalse(new FSMDescriptionBuilder().withType(FSM.FSMType.NFA).withDescription(description).build()
            .matches(input));
    }


    @ParameterizedTest
    @MethodSource("fsm.statemachine.FSMTestMethodSourceProvider#accepting")
    void regexNfaAccepting(String input) throws IOException {

        assertTrue(new FSMRegexBuilder().withRegex(Regex.of("(a+b)*.(a.a+a.b)")).build().matches(input));
    }


    @ParameterizedTest
    @MethodSource("fsm.statemachine.FSMTestMethodSourceProvider#rejecting")
    void regexNfaRejecting(String input) throws IOException {

        assertFalse(new FSMRegexBuilder().withRegex(Regex.of("(a+b)*.(a.a+a.b)")).build().matches(input));
    }


    private static FSMDescription fsmDescription(InputStream is) throws IOException {

        return new ObjectMapper().readValue(is, FSMDescription.class);
    }
}
