class `62 Unique Paths` {

    /**
     * Runtime: 136 ms, faster than 37.07% of Kotlin online submissions for Unique Paths.
    Memory Usage: 32.6 MB, less than 74.14% of Kotlin online submissions for Unique Paths.

     */
    fun uniquePaths(cols: Int, rows: Int): Int {

        val arr = Array(rows) { IntArray(cols) { 0 } }

        for (i in arr.indices) {
            arr[0][i] = 1
        }
        for (i in arr[0].indices) {
            arr[i][0] = 1
        }

        for (r in 1 until arr.size) {
            for (c in 1 until arr.size){
                arr[r][c] = arr[r - 1][c] + arr[r][c - 1]
            }
        }

        return arr[arr.size-1][arr[0].size-1]
    }
}