import java.util.*

fun main(args: Array<String>) {
    `394 Decode String`().decodeString("3[a]2[bc]")
}

class `394 Decode String` {

    /**
     * Runtime: 184 ms, faster than 25.71% of Kotlin online submissions for Decode String.
    Memory Usage: 35.2 MB, less than 30.00% of Kotlin online submissions for Decode String.

     */
    fun decodeString(s: String): String {
        val stack = Stack<Char>()
        s.toCharArray().forEach {
            when (it) {
                ']' -> {
                    val pattern = popPattern(stack)
                    val factor = popFactor(stack)
                    for (i in 1..factor) {
                        pattern.toCharArray().forEach { p -> stack.push(p) }
                    }
                }
                else -> { stack.push(it)}

            }
        }
        var decode = ""
        while (stack.isNotEmpty()) decode += stack.pop()
        return decode.reversed()
    }

    private fun popFactor(stack: Stack<Char>): Int {
        var res = ""
        while (stack.isNotEmpty() && stack.peek().isDigit()) {
            res += stack.pop()
        }
        return res.reversed().toInt()
    }


    private fun popPattern(stack: Stack<Char>): String {
        var res = ""
        while (stack.peek().isLetter()) {
            res += stack.pop()
        }
        if (stack.peek() == '[') stack.pop()
        return res.reversed()
    }
}