class `257 Binary Tree Paths` {


    /**
     * Runtime: 216 ms, faster than 28.41% of Kotlin online submissions for Binary Tree Paths.
    Memory Usage: 36 MB, less than 29.55% of Kotlin online submissions for Binary Tree Paths.
    Next challenges:
     */
    fun binaryTreePaths(root: TreeNode?): List<String> {
        if (root == null) return emptyList()
        val list = ArrayList<String>()
        recurse(root, "", list)
        return list
    }


    fun recurse(root: TreeNode?, pathSoFar: String, list: ArrayList<String>) {
        if (root == null) {
            return
        }
        var pathSoFar = pathSoFar
        pathSoFar += if (pathSoFar.isBlank()) "${root.`val`}"
        else "->${root.`val`}"
        if (root.left == null && root.right == null){
            list.add(pathSoFar)
            return
        }
        recurse(root.left, pathSoFar, list)
        recurse(root.right, pathSoFar, list)
    }

}