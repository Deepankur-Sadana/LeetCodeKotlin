class `222 Count Complete Tree Nodes` {


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun countNodes(root: TreeNode?): Int {
        traverse(root)
        return count
    }

    private var count = 0
    private fun traverse(root: TreeNode?) {
        if (root == null) return
        ++count
        traverse(root.left)
        traverse(root.right)
    }
}