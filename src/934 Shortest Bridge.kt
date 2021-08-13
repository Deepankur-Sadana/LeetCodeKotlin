import java.util.*

class `934 Shortest Bridge` {


    /**
     * Runtime: 870 ms, faster than 16.67% of Kotlin online submissions for Shortest Bridge.
    Memory Usage: 83.6 MB, less than 16.67% of Kotlin online submissions for Shortest Bridge.
     */


    fun shortestBridge(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val coloredIsland = LinkedList<Pair<Int, Int>>()
        loop@ for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == 1) {
                    paintTo2(r, c, coloredIsland, grid)
                    break@loop
                }
            }
        }
        var min = Int.MAX_VALUE
        while (coloredIsland.isNotEmpty()) {
            val pop = coloredIsland.pop()
            directions.forEach {
                val tRow = pop.first + it[0]
                val tCol = pop.second + it[1]

                if (tRow < 0 || tCol < 0 || tRow >= grid.size || tCol >= grid[0].size) {
                    //ignore OOB
                } else {
                    when (grid[tRow][tCol]) {
                        1 -> {
                            min = Math.min(min, grid[pop.first][pop.second])
                            if (min == 3) return 1
                        }

                        0 -> {
                            grid[tRow][tCol] = grid[pop.first][pop.second] + 1
                            coloredIsland.add(Pair(tRow, tCol))
                        }
                    }
                }

            }
        }

        return min - 2
    }

    private fun paintTo2(
        r: Int,
        c: Int,
        coloredIsland: LinkedList<Pair<Int, Int>>,
        grid: Array<IntArray>
    ): LinkedList<Pair<Int, Int>> {
        val queue = LinkedList<Pair<Int, Int>>()
        grid[r][c] = 2
        queue.add(Pair(r, c))

        while (queue.isNotEmpty()) {
            val pop = queue.pop()
            coloredIsland.add(pop)
            directions.forEach {
                val tRow = pop.first + it[0]
                val tCol = pop.second + it[1]
                if (tRow < 0 || tCol < 0 || tRow >= grid.size || tCol >= grid[0].size || grid[tRow][tCol] != 1) {
                    //ignore this, invalid or seen or water
                } else {
                    grid[tRow][tCol] = 2
                    queue.add(Pair(tRow, tCol))
                }
            }
        }
        return coloredIsland
    }

    var directions = arrayOf(
        intArrayOf(-1, 0),//top
        intArrayOf(0, 1),//right
        intArrayOf(1, 0),//bottom
        intArrayOf(0, -1)//left
    )
}
