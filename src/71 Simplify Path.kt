import java.util.*

fun main(args: Array<String>) {
    `71 Simplify Path`().simplifyPath("")
}

class `71 Simplify Path` {


    /**
     * Runtime: 543 ms, faster than 5.08% of Kotlin online submissions for Simplify Path.
    Memory Usage: 49.8 MB, less than 5.08% of Kotlin online submissions for Simplify Path.
    Next challenges:
     */
    fun simplifyPath(path: String): String {
        val list = path.split("/").filter { it.isNotEmpty() }
        list.forEach { print("split:- $it ") }
        val stack = Stack<String>()
        list.forEach { item ->
            when (item) {
                "." -> {}
                ".." -> {
                    if (stack.isNotEmpty()) stack.pop()
                }
                else -> { stack.push(item)}
            }
        }
        var builder = ""
        stack.forEach {
            builder += "/$it"
        }
        if(builder.isEmpty()) builder = "/"
        return builder
    }

}