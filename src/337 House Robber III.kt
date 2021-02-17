@Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")
class `337 House Robber III` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun rob(root: TreeNode?): Int {
        if (root == null) return 0
        val list = ArrayList<Int>()
        recurse(root, 0, list)
        list.forEach {
            println(" $it")
        }
        if (list.size == 1) return list[0]
        val dp = IntArray(list.size)
        dp[0] = list[0]
        dp[1] = Math.max(list[0], list[1])
        for (i in 2 until list.size) {
            dp[i] = Math.max(dp[i - 2] + list[i], dp[i - 1])
        }
        var max = 0
        dp.forEach { max = Math.max(max, it) }
        return max
    }

    private fun recurse(root: TreeNode?, level: Int, list: ArrayList<Int>) {
        if (root == null) return
        if (list.size < level + 1) list.add(0)
        list[level] += root.`val`
        recurse(root.left, level + 1, list)
        recurse(root.right, level + 1, list)
    }
}