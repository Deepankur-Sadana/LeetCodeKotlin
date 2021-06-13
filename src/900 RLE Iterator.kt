import java.util.*

class `900 RLE Iterator` {}


/**
 * Runtime: 200 ms, faster than 42.86% of Kotlin online submissions for RLE Iterator.
 */
class RLEIterator(encoding: IntArray) {

    class Node(var freq: Int, val `val`: Int)


    private val queue = LinkedList<Node>()

    init {
        loop@ for (i in encoding.indices step 2) {
            if (encoding[i] == 0) continue@loop
            if (queue.isNotEmpty() && queue.peek().`val` == encoding[i + 1]) {
                queue.peek().freq += encoding[i]
            } else {
                queue.add(Node(encoding[i], encoding[i + 1]))
            }
        }
    }


    fun next(n: Int): Int {
        if (queue.isEmpty()) return -1
        var totalElementsPopped = 0
        var lastPopped :Node? = null
        while (totalElementsPopped < n && !queue.isEmpty()) {
            lastPopped = queue.pop()
            totalElementsPopped += lastPopped.freq
        }
        if (totalElementsPopped < n) return -1
        if (totalElementsPopped == n) return lastPopped!!.`val`

        //totalElementsPopped > n
        lastPopped!!.freq = totalElementsPopped - n
        queue.addFirst(lastPopped)
        return lastPopped.`val`
    }

}