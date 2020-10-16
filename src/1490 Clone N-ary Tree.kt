class `1490 Clone N-ary Tree` {

    /**
     * Runtime: 396 ms, faster than 50.00% of Kotlin online submissions for Clone N-ary Tree.
    Memory Usage: 36.8 MB, less than 100.00% of Kotlin online submissions for Clone N-ary Tree.
     */
    fun cloneTree(root: Node?): Node? {
        if (root == null) return null
        val clone = Node(root.`val`)
        traverse(root, clone)
        return clone
    }

    private fun traverse(root: Node, clone: Node) {
        clone.children = ArrayList()
        root.children.forEach { (clone.children as ArrayList).add(Node(it!!.`val`)) }
        root.children.forEachIndexed { index, node -> traverse(node!!, (clone.children as ArrayList)[index]!!) }
    }


}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}