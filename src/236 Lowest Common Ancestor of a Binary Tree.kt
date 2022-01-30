import TreeNode

class `236 Lowest Common Ancestor of a Binary Tree` {

    /**
     * Runtime: 401 ms, faster than 20.88% of Kotlin online submissions for Lowest Common Ancestor of a Binary Tree.
    Memory Usage: 45.7 MB, less than 29.13% of Kotlin online submissions for Lowest Common Ancestor of a Binary Tree.
     */
    var ans: TreeNode? = null
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) return null
        recurse(root, p, q)
        return ans
    }


    private fun recurse(root: TreeNode?, p: TreeNode, q: TreeNode): Boolean {
        if (root == null) return false
        val left = if (recurse(root.left, p, q)) 1 else 0
        val right = if (recurse(root.right, p, q)) 1 else 0
        val mid = if (root.`val` == p.`val` || root.`val` == q.`val`) 1 else 0
        if (left + right + mid == 2) {
            ans = root
        }

//        if (root.`val` == p.`val` || root.`val` == q.`val`)
//            return true
        return left + right + mid >=1
    }
}