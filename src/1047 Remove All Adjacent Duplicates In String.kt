import java.util.*

class `1047 Remove All Adjacent Duplicates In String` {


    /**
     * Runtime: 3906 ms, faster than 5.13% of Kotlin online submissions for Remove All Adjacent Duplicates In String.
    Memory Usage: 714.5 MB, less than 5.13% of Kotlin online submissions for Remove All Adjacent Duplicates In String.
     */
    fun removeDuplicates(s: String): String {
        var res = ""
        val stack = Stack<Char>()
        s.forEach { char ->
            if (stack.isEmpty()) {
                stack.push(char)
            } else {
                if (stack.peek() == char) stack.pop()
                else stack.push(char)
            }
        }
        while (stack.isNotEmpty()) res += stack.pop()
        return res.reversed()
    }
}