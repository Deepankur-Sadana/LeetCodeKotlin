class `120 Triangle` {

    /**
    [
    [0],
    [0,1],
    [0,1,2],
    [0,1,2,3]
    [0,1,2,3,4]
    ]
     **/
    fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.isEmpty()) return 0
        val res = ArrayList<ArrayList<Int>>()
        for (i in 0 until triangle.size) {
            val list = ArrayList<Int>()
            for (j in 0..i) {
                list.add(0)
            }
            res.add(list)

        }
        // print(res)

        res[0][0] = triangle[0][0]

        for (row in 1 until triangle.size) {
            val list = triangle[row]
            for (col in 0 until list.size) {
                setMin(triangle, res, row, col)
            }
        }
        var min = Integer.MAX_VALUE
        res[res.size - 1].forEach {
            if (it < min) {
                min = it
            }
        }
        // print(res)
        return min
    }


    private fun setMin(
        triangle: List<List<Int>>,
        res: ArrayList<ArrayList<Int>>,
        row: Int,
        col: Int
    ) {
        when (col) {
            0 -> res[row][col] = triangle[row][col] + res[row - 1][col]
            triangle[row].size - 1 -> res[row][col] = triangle[row][col] + res[row - 1][col - 1]
            else -> res[row][col] = triangle[row][col] + Math.min(res[row - 1][col], res[row - 1][col - 1])
        }
    }
}