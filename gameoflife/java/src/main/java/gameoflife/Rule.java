package gameoflife;

import java.util.function.IntPredicate;


@FunctionalInterface
interface Rule extends IntPredicate {

    Rule CONWAY_SURVIVAL_RULE = n -> n == 2 || n == 3;
    Rule CONWAY_REVITALIZATION_RULE = n -> n == 3;
}
