import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class `692 Top K Frequent Words` {

    /**
     * Runtime: 272 ms, faster than 7.35% of Kotlin online submissions for Top K Frequent Words.
    Memory Usage: 38.2 MB, less than 5.88% of Kotlin online submissions for Top K Frequent Words.
     */
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val list = ArrayList<Word>()
        list.sortBy { it.freq }
        val map = HashMap<String, Int>()
        words.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        map.forEach { mapEntry ->
            val word = Word(mapEntry.key, mapEntry.value)
            list.add(word)
            println(word)
        }
        val l = list.sortedWith(compareBy<Word> { -it.freq }.thenBy { it.s })

        val res = ArrayList<String>()
        var count = 0
        while (count < k) {
            res.add(l.get(count++).s)
        }

        return res
    }


}

data class Word(val s: String, val freq: Int)


/**
 * Runtime: 212 ms, faster than 89.71% of Kotlin online submissions for Top K Frequent Words.
Memory Usage: 36.3 MB, less than 52.94% of Kotlin online submissions for Top K Frequent Words.

 */
class SolvingUsingHeap {

    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val map = HashMap<String, Int>()
        words.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        val heap = PriorityQueue<Word>(compareBy<Word> { it.freq }.reversed().thenBy { it.s })
        map.forEach {
            val word = Word(it.key, it.value)
            heap.add(word)
        }
        val res = ArrayList<String>()
        var count = 0
        while (count < k) {
            res.add(heap.poll().s)
            ++count
        }

        return res
    }
}
















