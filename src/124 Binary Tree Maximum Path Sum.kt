@file:Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")

class `124 Binary Tree Maximum Path Sum` {

    private var max = 0
    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) return max
        return max
    }


    // return open branch/ group
    fun recurse(root: TreeNode?): Pair<Int, Int> {
        if (root == null) return Pair(0, 0)
        if (root.left == null && root.right == null) return Pair(root.`val`, root.`val`)

        val left = recurse(root.left)
        val right = recurse(root.right)
        val branch = Math.max(left.first, right.first) + root.`val`
        val group = left.first + right.first + root.`val`

        max = max(max, branch, group, left.first, left.second, right.first, right.second)

        return Pair(branch, group)
    }

    fun max(vararg nums: Int): Int {
        var max = nums[0]
        for (i in 1 until nums.size)
            max = Math.max(max, nums[i])
        return max
    }
}