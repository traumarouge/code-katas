package example.dea;

import static example.dea.Automaton.*;
import static example.dea.Automaton.Symbol.A;
import static example.dea.Automaton.Symbol.B;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class AutomatonTest {

    @Test
    void matches() {

        Assertions.assertFalse(new Automaton().matches(new Symbol[] { A }));
        assertFalse(new Automaton().matches(new Symbol[] { B }));

        assertTrue(new Automaton().matches(new Symbol[] { A, B }));
        assertTrue(new Automaton().matches(new Symbol[] { A, A }));
        assertFalse(new Automaton().matches(new Symbol[] { B, B }));
        assertFalse(new Automaton().matches(new Symbol[] { B, A }));

        assertTrue(new Automaton().matches(new Symbol[] { B, A, A }));
        assertTrue(new Automaton().matches(new Symbol[] { A, A, B }));
        assertFalse(new Automaton().matches(new Symbol[] { A, B, A }));

        assertTrue(new Automaton().matches(new Symbol[] { A, B, A, B }));
        assertFalse(new Automaton().matches(new Symbol[] { B, B, A, A, B, A }));
        assertTrue(new Automaton().matches(new Symbol[] { B, B, A, A, B, A, A }));
    }
}
