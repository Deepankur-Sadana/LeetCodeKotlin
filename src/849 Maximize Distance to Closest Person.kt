class `849 Maximize Distance to Closest Person` {

    /**
     * Runtime: 212 ms, faster than 50.00% of Kotlin online submissions for Maximize Distance to Closest Person.
    Memory Usage: 38.8 MB, less than 16.67% of Kotlin online submissions for Maximize Distance to Closest Person.
     */
    fun maxDistToClosest(seats: IntArray): Int {
        var previous = seats.indexOf(1)
        var maxDistance = previous
        loop@ for (i in previous until seats.size) {
            if (seats[i] == 0) continue@loop
            maxDistance = Math.max(maxDistance, (i - previous) / 2)
            previous = i
        }
        maxDistance = Math.max(maxDistance, seats.size - 1 - previous)
        return maxDistance
    }
}