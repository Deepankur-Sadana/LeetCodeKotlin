class `272 Closest Binary Search Tree Value II` {


    /**
     * Runtime: 208 ms, faster than 33.33% of Kotlin online submissions for Closest Binary Search Tree Value II.
    Memory Usage: 38.4 MB, less than 33.33% of Kotlin online submissions for Closest Binary Search Tree Value II.
     */
    val list = ArrayList<Point>()

    class Point(val node: TreeNode, val diff: Double)

    val res = ArrayList<Int>()
    fun closestKValues(root: TreeNode?, target: Double, k: Int): List<Int> {
        reurse(root, target)
        var l = list.sortedBy { it.diff }
        var i = 0
        while (res.size < k) {
            res.add(l[i++].node.`val`)
        }
        return res
    }


    private fun reurse(root: TreeNode?, target: Double) {
        if (root == null) return
        reurse(root.left, target)
        list.add(Point(root, Math.abs(root.`val` - target)))
        reurse(root.right, target)

    }
}