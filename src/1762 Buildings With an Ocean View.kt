import java.util.*

class `1762 Buildings With an Ocean View` {

    /**
     * Runtime: 592 ms, faster than 71.05% of Kotlin online submissions for Buildings With an Ocean View.
    Memory Usage: 58.5 MB, less than 84.21% of Kotlin online submissions for Buildings With an Ocean View.
     */
    fun findBuildings(heights: IntArray): IntArray {
        var tallestBuildingSoFar = 0
        val stack = Stack<Int>()
        for (i in heights.size - 1 downTo 0) {
            if (heights[i] > tallestBuildingSoFar)
                stack.push(i)
            tallestBuildingSoFar = Math.max(tallestBuildingSoFar, heights[i])
        }

        val res = IntArray(stack.size)
        var i = 0
        while (stack.isNotEmpty()){
            res[i++] = stack.pop()
        }
        return res
    }
}