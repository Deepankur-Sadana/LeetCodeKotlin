class `863 All Nodes Distance K in Binary Tree` {

    /**
     * Runtime: 152 ms, faster than 100.00% of Kotlin online submissions for All Nodes Distance K in Binary Tree.
    Memory Usage: 35.2 MB, less than 80.00% of Kotlin online submissions for All Nodes Distance K in Binary Tree.

     */
    class ParentRefTreeNode(var `val`: Int) {
        var left: ParentRefTreeNode? = null
        var right: ParentRefTreeNode? = null
        var parent: ParentRefTreeNode? = null
    }

    private fun compose(root: TreeNode?, parentRef: ParentRefTreeNode?, caller: ParentRefTreeNode?) {
        if (root == null) return
        if (root == target) {
            parentRefTarget = parentRef!!
        }
        parentRef!!.parent = caller

        root.left?.let { parentRef.left = ParentRefTreeNode(it.`val`) }
        root.right?.let { parentRef.right = ParentRefTreeNode(it.`val`) }
        compose(root.left, parentRef.left, parentRef)
        compose(root.right, parentRef.right, parentRef)
    }

    lateinit var target: TreeNode
    lateinit var parentRefTarget: ParentRefTreeNode
    var targetDepth = 99

    fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
        this.targetDepth = K
        this.target = target!!
        if (root == null) return emptyList()
        val parentRoot = ParentRefTreeNode(root.`val`)
        compose(root, parentRoot, null)
        // printTree(parentRoot)
//        println("target ${parentRefTarget.`val`}")

        propagate(parentRefTarget, null, 0)
        return list
    }

    val list = ArrayList<Int>()

    private fun propagate(
        root: ParentRefTreeNode?,
        caller: ParentRefTreeNode?,
        depth: Int
    ) {
        if (root == null) return
        if (depth == targetDepth) {
            list.add(root.`val`)
        }
//        println(" ${root.`val`} depth :- $depth")

        if (root.left != caller) {
            propagate(root.left, root, depth + 1)
        }

        if (caller != root.right) {
            propagate(root.right, root, depth + 1)
        }

        if (caller != root.parent) {
            propagate(root.parent, root, depth + 1)
        }
    }

    fun printTree(parentRef: ParentRefTreeNode?){
        if (parentRef == null) return
        println("For ${parentRef.`val`} left:- ${parentRef.left?.`val`} right:-${parentRef.right?.`val`} parent:- ${parentRef.parent?.`val`}")
        printTree(parentRef.left)
        printTree(parentRef.right)
    }

}

