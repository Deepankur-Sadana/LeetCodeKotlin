class Solution {

    /**
     * Runtime: 260 ms, faster than 95.77% of Kotlin online submissions for Queries on Number of Points Inside a Circle.
    Memory Usage: 46.1 MB, less than 73.24% of Kotlin online submissions for Queries on Number of Points Inside a Circle.
     */

    fun countPoints(points: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val result = IntArray(queries.size)

        queries.forEachIndexed { index, query ->
            points.forEach {point->
                if (isInside(query, point)) {
                    result[index]++
                }
            }
        }
        return result
    }


    fun isInside(
        circle: IntArray, point: IntArray
    ): Boolean {
        return (point[0] - circle[0]) * (point[0] - circle[0]) +
                (point[1] - circle[1]) * (point[1] - circle[1]) <= circle[2] * circle[2]
    }

}