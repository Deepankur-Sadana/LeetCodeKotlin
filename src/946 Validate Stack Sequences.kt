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
        while (s < pushed.size) {
            if (pushed[s] == popped[i]) {
                ++i
                ++s
                while (stack.isNotEmpty() && stack.peek() == popped[i]) {
                    stack.pop()
                    i++
                }
            } else {
                stack.push(pushed[s])
                ++s
            }
        }

        while (stack.isNotEmpty()) {
            if (stack.pop() != popped[i]) return false
            i++
        }
        return true
    }
}