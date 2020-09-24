class `881 Boats to Save People` {

    /**
     * Runtime: 344 ms, faster than 100.00% of Kotlin online submissions for Boats to Save People.
    Memory Usage: 44.2 MB, less than 100.00% of Kotlin online submissions for Boats to Save People.
     */

    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var l = 0
        var h = people.size - 1
        var boats = 0
        while (h >= l) {
            if (l == h) {
                boats++
                break
            }
            if (people[h] + people[l] <= limit) {
                boats++
                h--
                l++
            } else {
                boats++
                h--
            }
        }
        return boats
    }
}