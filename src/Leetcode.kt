class Leetcode {


    /**
     * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.
     * These are given as characters 'R', '.', 'B', and 'p' respectively.
     * Uppercase characters represent white pieces, and lowercase characters represent black pieces.
    The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south),
    then moves in that direction until it chooses to stop, reaches the edge of the board,
    or captures an opposite colored pawn by moving to the same square it occupies.
    Also, rooks cannot move into the same square as other friendly bishops.
    Return the number of pawns the rook can capture in one move
     */
    fun numRookCaptures(board: Array<CharArray>): Int {
        board.forEach {
            System.out.println(it)
        }
        return 0
    }

    fun sortedSquares(A: IntArray): IntArray {

        for (i in A.indices) {
            A[i] = A[i] * A[i]
        }
        A.sort()
        return A
    }

    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val list = mutableListOf<Int>()
        for (num in left..right) {
            val splitList = split(num)
            splitList?.forEach { if (num % it == 0) list.add(num) }
        }
        return list
    }

    private fun split(number: Int): List<Int>? {
        val list = mutableListOf<Int>()
        var number = number
        while (number > 0) {
            print(number % 10)
            list.add(number % 10)
            number = number / 10
            if (number == 0) return null
        }
        return list
    }


    fun buddyStrings(A: String, B: String): Boolean {

        val Achars = A.toCharArray()
        val Bchars = B.toCharArray()

        println(Achars)
        println(Bchars)

        val arr = IntArray(A.length)

        for (i in arr.indices) {
            arr[i] = (Achars[i] - Bchars[i])
        }

        var sum = 0;

        var variableDigits = 0;
        for (i in arr.indices) {
            if (arr[i] != 0) ++variableDigits
            sum += arr[i]
        }
        print("sum $sum variableDigits $variableDigits")
        return sum == 0 && variableDigits <= 2
    }

}

fun main(args: Array<String>) {
    Leetcode().buddyStrings("aa", "aa")
}