class `951 Flip Equivalent Binary Trees` {

    /**
     * Runtime: 152 ms, faster than 71.43% of Kotlin online submissions for Flip Equivalent Binary Trees.
    Memory Usage: 33.8 MB, less than 52.38% of Kotlin online submissions for Flip Equivalent Binary Trees.

     */
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 == root2) return true
        if (root1 == null || root2 == null || root1.`val` != root2.`val`) return false
        return (
                (flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right))
                ||
                (flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left)))

    }
}