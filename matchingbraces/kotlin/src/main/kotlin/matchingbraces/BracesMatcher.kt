package matchingbraces

import java.util.*

class BracesMatcher {

    private val stack: Deque<Char> = ArrayDeque()

    private val opening = setOf('{', '[', '(')
    private val closing = setOf('}', ']', ')')
    private val pairs = setOf("{}", "[]", "()")

    fun matches(input: String): Boolean {
        for (c in input) {
            when (c) {
                in opening -> stack.push(c)
                in closing -> if (!match(c)) return false
            }
        }

        return stack.isEmpty()
    }

    private fun match(c: Char): Boolean {
        val e = stack.poll() ?: return false

        return "$e$c" in pairs
    }
}