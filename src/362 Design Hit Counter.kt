import java.util.*

class `362 Design Hit Counter` {
}


class HitCounter() {


    /**
     * Runtime: 180 ms, faster than 12.00% of Kotlin online submissions for Design Hit Counter.
    Memory Usage: 35.7 MB, less than 44.00% of Kotlin online submissions for Design Hit Counter.

     */
    val queue = LinkedList<Int>()

    /** Initialize your data structure here. */


    /** Record a hit.
    @param timestamp - The current timestamp (in seconds granularity). */
    fun hit(timestamp: Int) {
        queue.add(timestamp)

    }

    /** Return the number of hits in the past 5 minutes.
    @param timestamp - The current timestamp (in seconds granularity). */
    fun getHits(timestamp: Int): Int {
        if (queue.isEmpty()) return 0
        if (timestamp - queue.peek() < 300) {
            return queue.size
        }
        while (queue.isNotEmpty() && timestamp - queue.peek() >= 300) {
            queue.pop()
        }
        return queue.size
    }

}