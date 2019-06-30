package linkedlist

import java.lang.IllegalStateException

class Node<T : Any>(val value: T,
                    var next: Node<T>? = null,
                    var prev: Node<T>? = null)


class Deque<T : Any> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null

    fun push(element: T) {
        val node = Node(element, prev = last)

        node.prev.let {
            if (it == null) first = node else it.next = node
        }.also {
            last = node
        }
    }

    fun pop(): T {
        val node = last ?: throw IllegalStateException()

        node.prev.let {
            if (it == null) first = null else it.next = null
        }.also {
            last = node.prev
        }

        return node.value
    }

    fun unShift(element: T) {
        val node = Node(element, next = first)

        node.next.let {
            if (it == null) last = node else it.prev = node
        }.also {
            first = node
        }
    }

    fun shift(): T {
        val node = first ?: throw IllegalStateException()

        node.next.let {
            if (it == null) last = null else it.prev = null
        }.also {
            first = node.next
        }

        return node.value
    }
}