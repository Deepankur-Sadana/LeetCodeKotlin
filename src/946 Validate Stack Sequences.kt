import java.util.*

fun main(args: Array<String>) {
    `946 Validate Stack Sequences`().validateStackSequences(
        intArrayOf(1, 0, 2),
        intArrayOf(2, 1, 0)
    )
}

class `946 Validate Stack Sequences` {
    /**
     * Runtime: 340 ms, faster than 11.11% of Kotlin online submissions for Validate Stack Sequences.
    Memory Usage: 38.8 MB, less than 22.22% of Kotlin online submissions for Validate Stack Sequences.
     */

    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        var s = 0
        var i = 0
        var removed = 0
        while (s < pushed.size) {
            stack.push(pushed[s])
            while (stack.isNotEmpty() && popped[i] == stack.peek()) {
                ++i
                ++s
                stack.pop()
                ++removed
            }

        }

        return removed == pushed.size
    }
}