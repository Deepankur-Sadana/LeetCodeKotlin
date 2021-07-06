class `1637 Widest Vertical Area Between Two Points Containing No Points` {

    /**
     * Runtime: 628 ms, faster than 83.33% of Kotlin online submissions for Widest Vertical Area Between Two Points Containing No Points.
    Memory Usage: 84.7 MB, less than 83.33% of Kotlin online submissions for Widest Vertical Area Between Two Points Containing No Points.
     */
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        val list = ArrayList<Int>()
        points.forEach { list.add(it[0]) }
        list.sort()
        var max = Int.MIN_VALUE
        for (i in 1 until list.size) {
            max = Math.max(max, list[i] - list[i - 1])
        }
        return max
    }
}