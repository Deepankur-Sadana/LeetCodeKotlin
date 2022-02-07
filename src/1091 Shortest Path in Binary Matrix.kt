import java.util.*
import kotlin.collections.HashSet

@Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")
class `1091 Shortest Path in Binary Matrix` {


    /**
     * Runtime: 608 ms, faster than 63.16% of Kotlin online submissions for Shortest Path in Binary Matrix.
    Memory Usage: 61.3 MB, less than 61.40% of Kotlin online submissions for Shortest Path in Binary Matrix.
     */
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {

        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        if(grid[0][0] == 1) return -1
        val minDistance = Array(grid.size) { IntArray(grid[0].size) { Int.MAX_VALUE} }
        minDistance[0][0] = 0
        val seen = HashSet<String>()
        val queue = LinkedList<IntArray>()
        queue.add(intArrayOf(0,0))
        while (queue.isNotEmpty()){
            val poll = queue.poll()

            directions.forEach {
                val tentativeDirection = intArrayOf(it[0] + poll[0], it[1] + poll[1])
                val r = tentativeDirection[0]
                val c = tentativeDirection[1]
                val hashCode = "$r,$c"
                if (seen.contains(hashCode))
                    return@forEach
                seen.add(hashCode)

                if (r < 0 || c < 0 || r >= grid.size || c >= grid[0].size) return@forEach

                if (grid[r][c] == 1)
                    return@forEach
                minDistance[r][c] = Math.min(minDistance[r][c], 1 + minDistance[poll[0]][poll[1]])
                queue.add(tentativeDirection)
            }
        }
        if(minDistance[grid.size - 1][grid[0].size - 1] == Int.MAX_VALUE) return -1
        return minDistance[grid.size - 1][grid[0].size - 1] + 1
    }

    private val directions = arrayOf(
        arrayOf(0, 1),
        arrayOf(1, 0),
        arrayOf(0, -1),
        arrayOf(-1, 0),

        arrayOf(-1, -1),
        arrayOf(-1, 1),
        arrayOf(1, -1),
        arrayOf(1, 1)
    )
}