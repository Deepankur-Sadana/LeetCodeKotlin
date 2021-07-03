class `1261 Find Elements in a Contaminated Binary Tree` {


    /**
     * Runtime: 256 ms, faster than 100.00% of Kotlin online submissions for Find Elements in a Contaminated Binary Tree.
    Memory Usage: 50.8 MB, less than 80.00% of Kotlin online submissions for Find Elements in a Contaminated Binary Tree.
     */
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    class FindElements(root: TreeNode?) {
        var  set : HashSet<Int> = HashSet()

        init {
            recurse(root, 0)
        }

        fun recurse(root: TreeNode?, trueValue: Int) {
            if (root == null) return
            set.add(trueValue)
            recurse(root.left, trueValue * 2 + 1)
            recurse(root.right, trueValue * 2 + 2)

        }

        fun find(target: Int): Boolean {
            return set.contains(target)
        }

    }
}