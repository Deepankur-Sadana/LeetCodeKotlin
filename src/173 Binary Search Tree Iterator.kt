
import java.util.Stack


class `173 Binary Search Tree Iterator` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    class BSTIterator(root: TreeNode?) {

        private val stack = Stack<TreeNode>()


        init {
            if (root != null) {
                var n = root
                while (n != null) {
                    stack.push(n)
                    n = n.left
                }
            }
        }


        /** @return the next smallest number */
        fun next(): Int {

            if (stack.isEmpty()) return -1
            val ret: Int

            val pop = stack.pop()
            ret = pop.`val`

            var n = pop.right
            while (n != null) {
                stack.push(n)
                n = n.left

            }
            return ret
        }

        /** @return whether we have a next smallest number */
        fun hasNext(): Boolean {
            return !stack.isEmpty()
        }

    }
}