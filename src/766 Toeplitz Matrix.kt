class `766 Toeplitz Matrix` {


    /**
     * Runtime: 268 ms, faster than 49.09% of Kotlin online submissions for Toeplitz Matrix.
    Memory Usage: 41.9 MB, less than 47.27% of Kotlin online submissions for Toeplitz Matrix.

     */
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return true
        if (matrix.size == 1 || matrix[0].size == 1) return true

        var r = 1
        var c = 1
        while (r <= matrix.size - 1) {
            c = 1
            while (c <= matrix[0].size - 1) {
                if (matrix[r][c] != matrix[r - 1][c - 1]) return false
                ++c
            }
            ++r
        }

        return true
    }
}