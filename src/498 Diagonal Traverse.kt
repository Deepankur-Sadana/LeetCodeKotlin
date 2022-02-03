import java.util.*

class `498 Diagonal Traverse` {

    /**
     *
     *  0,0     0,1     0,2     0,3     0,4
     *  1,0     1,1     1,2     1,3     1,4
     *  2,0     2,1     2,2     2,3     2,4
     */

    var curr = 0

    /**
     * Runtime: 276 ms, faster than 84.62% of Kotlin online submissions for Diagonal Traverse.
    Memory Usage: 37.6 MB, less than 100.00% of Kotlin online submissions for Diagonal Traverse.
    Next challenges:
     */
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        curr = 0
        val result = IntArray(mat.size * mat[0].size)
        var isLTR =  true

        for (i in mat[0].indices) {
            var r = 0
            var c = i
            val queue = ArrayDeque<Int>()

            while (isInInBounds(r, c, mat)) {
                queue.add(mat[r][c])
                r++
                c--
            }
            copyElementsToArray(isLTR, result, queue)
            isLTR = !isLTR
        }

        for (i in 1 until mat.size) {
            var r = i
            var c = mat[0].size - 1
            val queue = ArrayDeque<Int>()

            while (isInInBounds(r, c, mat)) {
                queue.add(mat[r][c])
                r++
                c--
            }
            copyElementsToArray(isLTR, result, queue)
            isLTR = !isLTR
        }
        return result
    }

    private fun copyElementsToArray(isLTR: Boolean, result: IntArray, queue: ArrayDeque<Int>) {
        while (queue.isNotEmpty()){
            result[curr++] = if (!isLTR) queue.pollFirst() else queue.pollLast()
        }
    }

    private fun isInInBounds(r: Int, c: Int, mat: Array<IntArray>): Boolean {
        if (r < 0 || c < 0 || r >= mat.size || c >= mat[0].size)
            return false
        return true
    }

}