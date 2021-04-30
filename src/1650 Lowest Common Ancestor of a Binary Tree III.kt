class `1650 Lowest Common Ancestor of a Binary Tree III` {
    /**
     * Runtime: 192 ms, faster than 94.23% of Kotlin online submissions for Lowest Common Ancestor of a Binary Tree III.
    Memory Usage: 36.4 MB, less than 78.85% of Kotlin online submissions for Lowest Common Ancestor of a Binary Tree III.

     */
    class Node(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
        var parent: Node? = null
    }

    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        var a = p
        var b = q

        val seen = HashSet<Node>()
        while (true) {
            if (a != null) {
                val added = seen.add(a)
                if (!added) return a
            }
            if (b != null) {
                val added = seen.add(b)
                if (!added) return b
            }

            if (a != null) a = a.parent
            if (b != null) b = b.parent
        }

    }


}