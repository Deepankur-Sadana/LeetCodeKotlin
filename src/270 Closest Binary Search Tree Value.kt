class `270 Closest Binary Search Tree Value` {


    /**
     *
     */
    var diff = Double.MAX_VALUE
    var min = 0
    fun closestValue(root: TreeNode?, target: Double) :Int{
        if (root == null) return min
        if (diff > Math.abs(root.`val` - target)) {
            Math.abs(root.`val` - target)
            min = root.`val`
        }
        diff = Math.min(diff, Math.abs(root.`val` - target))
        if (root.`val` > target) {
           return closestValue(root.left, target)
        } else {
           return closestValue(root.right, target)
        }
    }
}