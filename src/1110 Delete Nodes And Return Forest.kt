class `1110 Delete Nodes And Return Forest` {


    /**
     * Runtime: 260 ms, faster than 42.86% of Kotlin online submissions for Delete Nodes And Return Forest.
    Memory Usage: 38.6 MB, less than 9.52% of Kotlin online submissions for Delete Nodes And Return Forest.
     */
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        val list = ArrayList<TreeNode?>()
        if (root == null) return list
        list.add(root)
        val set = HashSet<Int>()
        to_delete.forEach {
            set.add(it)
        }
        var i = 0
        while (i < list.size) {
            val curr = list[i]
            if (curr == null) {
                ++i
                continue
            }
            if (set.contains(curr.`val`)) {
                list[i] = null
                if (curr.left != null) list.add(curr.left!!)
                if (curr.right != null) list.add(curr.right!!)
                curr.left = null
                curr.right = null
            } else {
                dfs(curr, list, set)
            }
            ++i
        }
        val filteredList = ArrayList<TreeNode>()
        list.forEach {
            it?.let {
                filteredList.add(it)
            }
        }
        return filteredList
    }


    private fun dfs(root: TreeNode?, list: ArrayList<TreeNode?>, set: HashSet<Int>) {
        if (root == null) return

        root.left?.let { it ->
            if (set.contains(it.`val`)) {
                root.left = null
                list.add(it.left)
                list.add(it.right)
            } else {
                dfs(it, list, set)
            }
        }


        root.right?.let { it ->
            if (set.contains(it.`val`)) {
                root.right = null
                list.add(it.left)
                list.add(it.right)
            } else {
                dfs(it, list, set)

            }
        }
    }


}










