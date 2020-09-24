import java.util.*
import kotlin.collections.ArrayList

@Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")
class `826 Most Profit Assigning Work` {

    /**
     * Runtime: 388 ms, faster than 50.00% of Kotlin online submissions for Most Profit Assigning Work.
    Memory Usage: 42 MB, less than 50.00% of Kotlin online submissions for Most Profit Assigning Work.

     */
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val list = ArrayList<Pair<Int, Int>>(difficulty.size)
        difficulty.forEachIndexed { index, _ -> list.add(Pair(difficulty[index], profit[index])) }

        val sortedWith = list.sortedWith(compareBy { it.first })
        list.clear()
        var best = if (list.isEmpty()) Int.MIN_VALUE else list[0].second

        sortedWith.forEach {
            val p = it
            if (p.second > best)
                list.add(p)
            best = Math.max(best, p.second)
        }

        list.forEach {
            println("${it.first} ${it.second}")
        }

        worker.sortDescending()
        var sum = 0
        var d = list.size - 1
        for (w in worker.indices) {
            while (d >= 0 && worker[w] < list[d].first) {
                d--
            }
            if (d >= 0) {
                sum += list[d].second
            }
        }
        return sum
    }
}