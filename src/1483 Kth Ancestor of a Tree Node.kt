



fun main(args: Array<String>) {
    Leetcode().buddyStrings("aa", "aa")
}

class TreeAncestor(val n: Int,val  parent: IntArray) {

    fun getKthAncestor(node: Int, k: Int): Int {
        TODO()
    }


    class TreeNode(val num: Int) {
        val parent = ArrayList<TreeNode>()
    }

    private fun makeTree() {
        val map = HashMap<Int, TreeNode>()
        for (i in 0 until n) {
            val treeNode = TreeNode(i)
            map[i] = treeNode
        }
        parent.forEachIndexed { index, it ->
            if (it != -1) {
                map[index]!!.parent.add(map[it]!!)
            }
        }
    }

    private fun attachLifts() {

    }
}