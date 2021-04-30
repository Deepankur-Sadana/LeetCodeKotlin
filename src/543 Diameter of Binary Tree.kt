class `543 Diameter of Binary Tree` {

    /**
     * Runtime: 172 ms, faster than 75.00% of Kotlin online submissions for Diameter of Binary Tree.
    Memory Usage: 35.8 MB, less than 41.13% of Kotlin online submissions for Diameter of Binary Tree.

     */
    var res = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        recurse(root)
        return res
    }

    fun recurse(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1
        val left = recurse(root.left)
        val right = recurse(root.right)
        res = Math.max(res, left + right)
        return Math.max(left, right) + 1
    }

}