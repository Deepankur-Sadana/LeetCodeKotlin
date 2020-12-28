import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {

    val first: Array<IntArray> = arrayOf(
        intArrayOf(2,1,5),
        intArrayOf(3,3,7)
    )
    `1094 Car Pooling`().carPooling(first, 4)
}

class `1094 Car Pooling` {

    /**
     * Runtime: 172 ms, faster than 100.00% of Kotlin online submissions for Car Pooling.
    Memory Usage: 36.7 MB, less than 81.25% of Kotlin online submissions for Car Pooling.
     */
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        var load = 0
        val list = ArrayList<Stop>()
        trips.forEach { trip ->
            list.add(Stop(trip[0], trip[1], Action.PICK))
            list.add(Stop(trip[0], trip[2], Action.DROP))
        }
        trips.sort()

        list.forEach { stop ->
            if (stop.action == Action.DROP) {
                load -= stop.people
            } else {
                load += stop.people
            }
            if (load > capacity) return false
        }
        return true
    }

    //trip[i] = [num_passengers, start_location, end_location]
    enum class Action { PICK, DROP }
    data class Stop(val people: Int, val dist: Int, val action: Action) : Comparable<Stop> {
        override fun compareTo(other: Stop) = when {
            dist != other.dist -> dist - other.dist
            else -> action.compareTo(other.action)
        }
    }
}