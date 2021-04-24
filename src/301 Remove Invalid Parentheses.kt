import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap

fun main(args: Array<String>) {

    `301 Remove Invalid Parentheses`().removeInvalidParentheses("(a)())()")
}

/**
 * Runtime: 1092 ms, faster than 5.55% of Kotlin online submissions for Remove Invalid Parentheses.
Memory Usage: 54.3 MB, less than 5.55% of Kotlin online submissions for Remove Invalid Parentheses.

 */
class `301 Remove Invalid Parentheses` {


    val map = LinkedHashMap<Int, HashSet<String>>()
    fun removeInvalidParentheses(s: String): List<String> {
        recurse(0, s)
        var largest = 0
        map.entries.forEach {
           largest= Math.max(largest,it.key)
        }

        val list = ArrayList<String>()
        map[largest]!!.forEach { list.add(it) }
        return list
    }

    private fun recurse(subjectIndex: Int, s: String) {
        if (isValid(s)) {
            if (map[s.length] == null)
                map[s.length] = HashSet()
            map[s.length]!!.add(s)
        }
        if (subjectIndex == s.length) {
            return
        }
        if (limit(s.substring(0, subjectIndex))) return
        val dropping = s.substring(0, subjectIndex) + s.substring(subjectIndex + 1)
        recurse(subjectIndex + 1, s)

        if (s[subjectIndex] == '(' || s[subjectIndex] == ')') {
            recurse(subjectIndex, dropping)
        }
    }


    private fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.toCharArray().forEach { curr ->
            when (curr) {
                '(' -> {
                    stack.push(curr)
                }
                ')' -> {
                    if (stack.isEmpty()) return false
                    else stack.pop()
                }
            }
        }
        return stack.isEmpty()
    }


    private fun limit(s: String): Boolean {
        var open = 0
        var close = 0
        s.toCharArray().forEach { curr ->
            if (close > open) return true
            when (curr) {
                '(' -> {
                    open++
                }
                ')' -> {
                    close++
                }
            }
        }
        return false
    }


}