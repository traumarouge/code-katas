package fsm.statemachine;

import java.util.stream.Stream;


public class FSMTestMethodSourceProvider {

    static Stream<String> accepting() {

        return Stream.of( //
                "aa", "ab", "aaa", "baa", "aab", "aaaab", "ababbbab", //
                "bbabbab", "bbaabaa", "abbbababbaa", "babbbababbab");
    }


    static Stream<String> rejecting() {

        return Stream.of( //
                "", "a", "b", "ba", "bb", "abb", "aba", "bba", "bba", //
                "bba", "abba", "ababa", "ababb", "baaba", "baaabba");
    }
}
