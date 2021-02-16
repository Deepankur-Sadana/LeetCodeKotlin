import java.lang.StringBuilder

class `695 Max Area of Island` {

    /**
     * Runtime: 264 ms, faster than 27.59% of Kotlin online submissions for Max Area of Island.
    Memory Usage: 40.7 MB, less than 67.24% of Kotlin online submissions for Max Area of Island.

     */

    var directions =
        arrayOf(
            intArrayOf(-1, 0),//Left
            intArrayOf(0, 1),//Right
            intArrayOf(1, 0),//Top
            intArrayOf(0, -1)//Bottom
        )

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = 0
        val set = HashSet<String>()
        for (r in grid.indices)
            for (c in grid[0].indices) {
                max = Math.max(max, recurse(r, c,  grid, set))
            }
        return max

    }

    fun recurse(r: Int, c: Int, /*areaSoFar: Int,*/ grid: Array<IntArray>, seen: HashSet<String>): Int {
        if (r < 0 || c < 0 || r >= grid.size || c >= grid[0].size) return 0
        val point = StringBuilder().append(r.toString()).append(",").append(c.toString()).toString()
        if (seen.contains(point)) return 0
        seen.add(point)
        if (grid[r][c] == 0) return 0

        var currentSum = 0
        directions.forEach { direction ->
            currentSum += recurse(r + direction[0], c + direction[1],  grid, seen)
        }
        return currentSum + 1

    }
}