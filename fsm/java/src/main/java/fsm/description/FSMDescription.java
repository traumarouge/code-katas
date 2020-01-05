package fsm.description;

import java.util.Map;
import java.util.Set;


public class FSMDescription {

    public Set<String> alphabet;
    public Map<String, State> states;

    public static class State {

        public boolean initial;
        public boolean accepting;
        public Set<Transition> transitions;
    }

    public static class Transition {

        public String target;
        public Set<String> symbols;
    }
}
