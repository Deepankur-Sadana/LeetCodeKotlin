package `98`

class ` Validate Binary Search Tree` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isValidBST(root: TreeNode?): Boolean {
        return recurse(root, null, null)

    }

    fun recurse(root: TreeNode?, min: Int?, max: Int?): Boolean {
        if (root == null) return true

        min?.let {
            if (root.`val` <= min) return false
        }

        max?.let {
            if (root.`val` >= max) return false
        }
        return recurse(root.left, min , root.`val`) &&
                recurse(root.right, root.`val`, max )

    }
}