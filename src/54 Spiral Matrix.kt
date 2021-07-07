class `54 Spiral Matrix` {


    /**
     * Runtime: 136 ms, faster than 91.96% of Kotlin online submissions for Spiral Matrix.
    Memory Usage: 33.7 MB, less than 85.71% of Kotlin online submissions for Spiral Matrix.
    Next challenges:
     */
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val list = ArrayList<Int>()
        val rows = matrix.size
        val cols = matrix[0].size
        var bounds = Bounds(0, cols - 1, 0, rows - 1)

        while (list.size < rows * cols) {

            val left = bounds.left
            val right = bounds.right
            val top = bounds.top
            val bottom = bounds.bottom

            //top
            for (i in bounds.left..bounds.right) {
                list.add(matrix[top][i])
            }

            //right
            for (i in top + 1..bottom) {
                list.add(matrix[i][right])
            }

            //bottom
            if (top != bottom)
                for (i in right - 1 downTo left) {//reverse
                    list.add(matrix[bottom][i])
                }

            //left
            if (left != right)
                for (i in bottom - 1 downTo top + 1) {
                    list.add(matrix[i][left])
                }
            bounds = Bounds(bounds.left + 1, bounds.right - 1, bounds.top + 1, bounds.bottom - 1)

        }
        return list
    }


    /**Inclusive**/
    data class Bounds(
        val left: Int,
        val right: Int,
        val top: Int,
        val bottom: Int
    )


}