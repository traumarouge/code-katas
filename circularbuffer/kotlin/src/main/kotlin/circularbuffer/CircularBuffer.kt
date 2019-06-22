package circularbuffer

import java.lang.RuntimeException

class CircularBuffer<T : Any>(size: Int) {

    private val buffer: Array<Any?> = arrayOfNulls(size)
    private var readPointer = 0
    private var writePointer = 0

    fun read(): T {
        val element = buffer[readPointer] ?: throw EmptyBufferReadException()

        buffer[readPointer] = null
        incrementReadPointer()

        @Suppress("UNCHECKED_CAST")
        return element as T
    }

    fun write(element: T) {
        if (buffer[writePointer] != null) incrementReadPointer()

        buffer[writePointer] = element
        incrementWritePointer()
    }

    private fun incrementReadPointer() {
        readPointer = (readPointer + 1) % buffer.size
    }

    private fun incrementWritePointer() {
        writePointer = (writePointer + 1) % buffer.size
    }
}


class EmptyBufferReadException() : RuntimeException()