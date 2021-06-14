class `113 Path Sum II` {


    /**
     * Runtime: 220 ms, faster than 57.14% of Kotlin online submissions for Path Sum II.
    Memory Usage: 41.5 MB, less than 17.46% of Kotlin online submissions for Path Sum II.
    Next challenges:
     */
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val res = ArrayList<List<Int>>()
        recurse(root, 0, targetSum, ArrayList(), res)
        return res
    }



    fun recurse(
        root: TreeNode?,
        sumSoFar: Int,
        targetSum: Int,
        nodesSoFar: ArrayList<Int>,
        result: ArrayList<List<Int>>
    ) {
        if (root == null) return
        if (root.left == null && root.right == null) {
            if (sumSoFar + root.`val` == targetSum) {
                nodesSoFar.add(root.`val`)
                result.add(nodesSoFar)
            }
        }

        val left = ArrayList(nodesSoFar)
        val right = ArrayList(nodesSoFar)
        left.add(root.`val`)
        right.add(root.`val`)
        recurse(root.left, sumSoFar + root.`val`, targetSum, left, result)
        recurse(root.right, sumSoFar + root.`val`, targetSum, right, result)
    }

}