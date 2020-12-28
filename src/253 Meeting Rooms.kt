import kotlin.collections.ArrayList

class `253 Meeting Rooms` {

    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        val list = ArrayList<Event>()
        intervals.forEach { meeting ->
            list.add(
                Event(
                    meeting[0],
                    Type.START
                )
            )
            list.add(
                Event(
                    meeting[1],
                    Type.END
                )
            )
        }
        val sortedList = list.sortedWith(compareBy<Event> { it.time }.thenBy { it.type.name.length })
        var max = 0
        var curr = 0
        sortedList.forEach { event ->
            if (event.type == Type.START) {
                curr++
            } else {
                curr--
            }
            max = Math.max(max, curr)
        }

        return max
    }

    enum class Type { START, END }
    data class Event(val time: Int, val type: Type)
}