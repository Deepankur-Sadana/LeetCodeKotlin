@file:Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")

import java.util.*
import kotlin.collections.ArrayList

class `973 K Closest Points to Origin` {

    /**
     * Runtime: 608 ms, faster than 75.68% of Kotlin online submissions for K Closest Points to Origin.
    Memory Usage: 60.1 MB, less than 73.87% of Kotlin online submissions for K Closest Points to Origin.
     */

    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        val heap = PriorityQueue<Point>(compareBy { it.dist })
        points.forEach {
            heap.add(Point(intArrayOf(it[0], it[1]), distance(it[0], it[1])))
        }

        val list = ArrayList<IntArray>()
        while (list.size < K) {
            list.add(heap.poll().p)
        }
        return list.toTypedArray()
    }


    private fun distance(x: Int, y: Int): Double {
        return Math.sqrt(
            Math.pow(x.toDouble(), 2.0) +
                    Math.pow(y.toDouble(), 2.0) * 1.0
        );
    }

    data class Point(val p: IntArray, val dist: Double)


}