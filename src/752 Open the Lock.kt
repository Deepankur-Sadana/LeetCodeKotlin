@file:Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet


fun main(args: Array<String>) {
    val c = `752 Open the Lock`().openLock(
        arrayOf("0201","0101","0102","1212","2002"),
        "0202"
    )

}


/**
 * Runtime: 1028 ms, faster than 18.18% of Kotlin online submissions for Open the Lock.
Memory Usage: 48.1 MB, less than 9.09% of Kotlin online submissions for Open the Lock.

 */
class `752 Open the Lock` {
    fun openLock(deadends: Array<String>, target: String): Int {
        val dead = HashSet<String>()
        deadends.forEach { dead.add(it) }
        if(dead.contains("0000")) return -1
        val queue = LinkedList<Pair<Int, String>>()
        val seen = HashSet<String>()
        queue.add(Pair(0, "0000"))

        seen.addAll(dead)
        var min = Int.MAX_VALUE
        while (queue.isNotEmpty()) {
            val poll = queue.poll()
            seen.add(poll.second)
            if (poll.second == target) {
                min = Math.min(poll.first, min)
            }
            val combinations = getAllCombinations(poll.second)

            combinations.forEach {
                if (seen.contains(it).not()) {
                    queue.add(Pair(poll.first + 1, it))
                    seen.add(it)
                }
            }
        }
        return if(min == Int.MAX_VALUE) -1 else min
    }


    private fun getAllCombinations(lock: String): List<String> {
        val list = ArrayList<String>()
        lock.toCharArray().forEachIndexed { index, num ->
            val digit = num.toString().toInt()
            val rotatedUpwards = (digit + 1) % 10
            val rotatedDownwards = if (digit == 0) 9 else digit - 1
            val down = lock.substring(0, index) + rotatedDownwards.toString() + lock.substring(index + 1)
            val up = lock.substring(0, index) + rotatedUpwards.toString() + lock.substring(index + 1)
            list.add(up)
            list.add(down)
        }
        return list
    }
}