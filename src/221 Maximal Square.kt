class `221 Maximal Square` {


    fun maximalSquare(matrix: Array<CharArray>): Int {
        Utils.printArray(matrix)
        val result = Array(matrix.size) { IntArray(matrix[0].size) }

        if (result.isEmpty() || result[0].size == 0) return 0

        println("..............")

        var max = result[0][0]

        for (i in 0 until matrix[0].size) {
            result[0][i] = getIntFromChar(matrix[0][i])
            if (max > result[0][i])
                max = result[0][i]
        }
        for (i in 0 until matrix.size) {
            result[i][0] = getIntFromChar(matrix[i][0])
            if (max > result[i][0])
                max = result[i][0]
        }

        Utils.printArray(result)


        for (row in 1 until matrix.size) {
            for (col in 1 until matrix[0].size) {
                val value = getIntFromChar(matrix[row][col])
                print(" $value")
                if (value == 0)
                    result[row][col] = 0
                else result[row][col] = getMin(result, row, col) + 1
                if (result[row][col] > max)
                    max = result[row][col]
            }
        }
        Utils.printArray(result)


        return max * max
    }


    private fun getMin(matrix: Array<IntArray>, i: Int, j: Int): Int {
        val v1 = matrix[i - 1][j]
        val v2 = matrix[i - 1][j - 1]
        val v3 = matrix[i][j - 1]
        return Math.min(v1, Math.min(v2, v3))
    }

    private fun getIntFromChar(char: Char): Int {
        return if (char == '0') 0
        else 1
    }
}

/**
 *
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

 */

fun main(args: Array<String>) {
    val r1 = charArrayOf('1', '0', '1', '0', '0')
    val r2 = charArrayOf('1', '0', '1', '1', '1')
    val r3 = charArrayOf('1', '1', '1', '1', '1')
    val r4 = charArrayOf('1', '0', '0', '1', '0')
    `221 Maximal Square`().maximalSquare(arrayOf(r1, r2, r3, r4))

}