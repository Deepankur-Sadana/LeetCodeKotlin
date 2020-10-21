import java.util.*

class `729 My Calendar I` {

    /**
     * Runtime: 400 ms, faster than 55.00% of Kotlin online submissions for My Calendar I.
    Memory Usage: 51.3 MB, less than 5.00% of Kotlin online submissions for My Calendar I.
     */
    class MyCalendar() {
        var map: TreeMap<Int, Int> = TreeMap()
        fun book(start: Int, end: Int): Boolean {
            if (map.containsKey(start)) return false
            val floor = map.floorEntry(start)
            val ceil = map.ceilingEntry(start)

            if(floor != null && floor.value > start) return false
            if(ceil != null && ceil.key < end) return false
            map[start]= end
            return true
        }
    }
}