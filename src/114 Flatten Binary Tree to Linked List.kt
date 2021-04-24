class `114 Flatten Binary Tree to Linked List` {


    /**
     * Runtime: 156 ms, faster than 91.94% of Kotlin online submissions for Flatten Binary Tree to Linked List.
    Memory Usage: 35 MB, less than 91.94% of Kotlin online submissions for Flatten Binary Tree to Linked List.
     */

    fun flatten(root: TreeNode?) {
        if (root == null) return
        val rightBisected: TreeNode? = root.right
        val leftFlattenedEdge : TreeNode
        root.left?.let { left ->
            flatten(left)
            leftFlattenedEdge = getEdge(left)
            root.right = left
            root.left = null
            leftFlattenedEdge.right = rightBisected
        }

        rightBisected?.let { right ->
            flatten(right)
        }
    }

    private fun getEdge(root: TreeNode) :TreeNode{
        var curr = root
        while (curr.right != null) {
            curr = curr.right!!
        }
        return curr
    }


}