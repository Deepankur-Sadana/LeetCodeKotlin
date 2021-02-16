class `1602 Find Nearest Right Node in Binary Tree` {


    /**
     * Runtime: 408 ms, faster than 66.67% of Kotlin online submissions for Find Nearest Right Node in Binary Tree.
    Memory Usage: 55.2 MB, less than 63.33% of Kotlin online submissions for Find Nearest Right Node in Binary Tree.
    Next challenges:
     */
    fun findNearestRightNode(root: TreeNode?, u: TreeNode?): TreeNode? {
        if (u == null) return null
        return traverse(root, 0, u)
    }

    var level: Int? = null
    fun traverse(root: TreeNode?, currentLevel: Int, u: TreeNode): TreeNode? {
        if (root == null) return null
        if (level != null && level == currentLevel) return root
        if (u.`val` == root.`val`) level = currentLevel
        val l = traverse(root.left, currentLevel + 1, u)
        if (l != null) return l
        val r = traverse(root.right, currentLevel + 1, u)
        if (r != null) return r
        return null
    }
}