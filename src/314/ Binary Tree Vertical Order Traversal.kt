package `314`

import TreeNode
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class `314 Binary Tree Vertical Order Traversal` {

    /**
     * Runtime: 334 ms, faster than 34.41% of Kotlin online submissions for Binary Tree Vertical Order Traversal.
    Memory Usage: 37.4 MB, less than 24.73% of Kotlin online submissions for Binary Tree Vertical Order Traversal.
     */
    var min = Int.MAX_VALUE
    fun verticalOrder(root: TreeNode?): List<List<Int>> {
        val list = HashMap<Int, ArrayList<Int>>()
        val result = ArrayList<ArrayList<Int>>()
        if(root == null) return emptyList()
        bfs(root, list)

        while (list[min] != null) {
            result.add(list[min++]!!)
        }
        return result
    }


    private fun bfs(root: TreeNode, map: HashMap<Int, ArrayList<Int>>) {
        val list = LinkedList<ListItem>()
        list.add(ListItem(root, 0, 0))

        while (list.isNotEmpty()) {
            val poll = list.poll()
            min = Math.min(min, poll.c)

            if (map[poll.c] == null) {
                map[poll.c] = ArrayList()
            }

            map[poll.c]!!.add(poll.node.`val`)
            if (poll.node.left != null) {
                list.add(ListItem(poll.node.left!!, poll.r + 1, poll.c - 1))
            }

            if (poll.node.right != null) {
                list.add(ListItem(poll.node.right!!, poll.r + 1, poll.c + 1))
            }
        }

    }

    internal data class ListItem(val node: TreeNode, val r: Int, val c: Int)
}