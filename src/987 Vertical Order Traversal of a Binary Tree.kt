import java.util.*
import kotlin.collections.ArrayList


/**
 * Runtime: 176 ms, faster than 90.91% of Kotlin online submissions for Vertical Order Traversal of a Binary Tree.
 */
class `987 Vertical Order Traversal of a Binary Tree` {


    data class Point(val r: Int, val c: Int)


    private val superMap = HashMap<Int, ArrayList<Pair<Point, TreeNode>>>()
    var leftBound = 0
    val list = ArrayList<ArrayList<Pair<Point, TreeNode>>>()

    data class Element(val node: TreeNode, val point: Point)

    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        val queue = LinkedList<Pair<Point, TreeNode>>()
        queue.add(Pair(Point(0, 0), root!!))

        while (queue.isNotEmpty()) {

            val pop = queue.pop()

            val col = pop.first.c
            val row = pop.first.r
            leftBound = Math.min(leftBound, col)
            if (superMap[col] == null) superMap[col] = ArrayList()

            superMap[col]!!.add(pop)

            pop.second.left?.let { left ->
                queue.add(Pair(Point(row + 1, col - 1), left))
            }
            pop.second.right?.let { right ->
                queue.add(Pair(Point(row + 1, col + 1), right))
            }
        }
        sortColumnBasis()
        list.forEach { pairList ->
            pairList.sortWith(compareBy<Pair<Point, TreeNode>> { it.first.r }.thenBy { it.second.`val` })
        }
        val res = ArrayList<ArrayList<Int>>()
        list.forEach { pairList ->
        val sub = ArrayList<Int>()
            pairList.forEach { pair-> sub.add(pair.second.`val`) }
            res.add(sub)

        }
        return res
    }

    private fun sortColumnBasis() {
        var i = leftBound
        while (superMap[i] != null) {
            list.add(superMap[i]!!)
            ++i
        }
    }









}