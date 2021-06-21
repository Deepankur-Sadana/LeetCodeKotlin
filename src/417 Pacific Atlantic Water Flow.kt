import java.util.*
import kotlin.collections.ArrayList

class `417 Pacific Atlantic Water Flow` {

    /**
     * Runtime: 328 ms, faster than 80.00% of Kotlin online submissions for Pacific Atlantic Water Flow.
    Memory Usage: 42 MB, less than 75.00% of Kotlin online submissions for Pacific Atlantic Water Flow.

     */


    private val direction = arrayOf(
        arrayOf(0, -1),//l
        arrayOf(-1, 0),//t
        arrayOf(0, 1),//r
        arrayOf(1, 0)//b
    )


    /**
     *
    00 01 02
    10 11 12
    20 21 22
    30 31 32
     */


    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        if (heights.isEmpty() || heights[0].isEmpty()) return emptyList()

        val res = ArrayList<List<Int>>()

        val numRows = heights.size
        val numCols = heights[0].size

        val pacificQueue = LinkedList<IntArray>()
        val atlanticQueue = LinkedList<IntArray>()

        for (r in 0 until numRows) {
            pacificQueue.add(intArrayOf(r, 0))
            atlanticQueue.add(intArrayOf(r, numCols - 1))
        }


        for (c in 0 until numCols) {
            pacificQueue.add(intArrayOf(0, c))
            atlanticQueue.add(intArrayOf(numRows - 1, c))
        }
        val pacificLand = bfs(pacificQueue, heights)
        val atlanticLand = bfs(atlanticQueue, heights)

        for (r in pacificLand.indices) {
            for (c in pacificLand[0].indices) {
                if (pacificLand[r][c] && atlanticLand[r][c]) res.add(listOf(r, c))
            }
        }
        return res
    }


    private fun bfs(queue: LinkedList<IntArray>, heights: Array<IntArray>): Array<BooleanArray> {
        val numRows = heights.size
        val numCols = heights[0].size
        val seen = Array(numRows) { BooleanArray(numCols) }

        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            seen[curr[0]][curr[1]] = true

            val currHeight = heights[curr[0]][curr[1]]
            direction.forEach loop@{
                val pRow = curr[0] + it[0]
                val pCol = curr[1] + it[1]
                if (pRow < 0 || pRow >= numRows || pCol < 0 || pCol >= numCols) return@loop
                if (seen[pRow][pCol]) return@loop
                val prospectiveHeight = heights[pRow][pCol]
                if (prospectiveHeight >= currHeight) {
                    queue.add(intArrayOf(pRow, pCol))
                }
            }
        }
        return seen
    }


}