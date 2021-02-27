



class `110 Balanced Binary Tree` {


    fun isBalanced(root: TreeNode?): Boolean {

        TODO()
    }

    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    fun recurse(root: TreeNode?, level: Int) {
        if (root == null) return
        if (root.left == null && root.right == null) {

        }
        recurse(root.left, level + 1)
        recurse(root.right, level + 1)

    }



}