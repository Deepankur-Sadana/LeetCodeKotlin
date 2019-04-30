class `36 Valid Sudoku` {

    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val validColumn = isValidColumn(board)
        val validRow = isValidRow(board)
        val validateGrid = validateGrid(board)

        print("validColumn $validColumn validRow $validRow validateGrid $validateGrid")
        return validColumn &&
                validRow &&
                validateGrid
    }


    private fun isValidColumn(board: Array<CharArray>): Boolean {

        for (col in 0 until board[0].size) {
            val set = HashSet<Char>()
            for (row in 0 until board.size) {
                val c = board[row][col]
                if (c != '.') {
                    if (!set.add(c))
                        return false
                }
            }
        }
        return true
    }

    private fun isValidRow(board: Array<CharArray>): Boolean {
        for (row in 0 until board.size) {
            val set = HashSet<Char>()
            val chars = board[row]
            chars.forEach {
                if (it != '.') {
                    if (!set.add(it)) return false
                }
            }
        }
        return true
    }

    private fun validateGrid(board: Array<CharArray>): Boolean {

        var row = 0
        var col = 0
        while (row < board.size) {
            col = 0
            while (col < board[0].size) {
                if (!isValidGrid(Point(row, col), board)) return false
                col += 3
            }
            row += 3
        }

        return true
    }

    data class Point(val row: Int, val col: Int)

    private fun isValidGrid(point: Point, board: Array<CharArray>): Boolean {

        print(point)
        val set = HashSet<Char>()

        for (row in point.row..point.row + 2) {
            for (col in point.col..point.col + 2) {
                val c = board[row][col]
                if (c != '.') {
                    if (!set.add(c))
                        return false
                }
            }
        }

        print(set)
        return true
    }
}