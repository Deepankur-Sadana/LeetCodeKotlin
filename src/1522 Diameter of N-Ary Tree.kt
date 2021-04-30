class `1522 Diameter of N-Ary Tree` {


    /**
     * Runtime: 216 ms, faster than 12.50% of Kotlin online submissions for Diameter of N-Ary Tree.
    Memory Usage: 38 MB, less than 50.00% of Kotlin online submissions for Diameter of N-Ary Tree.
    Next challenges:
     */
    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun diameter(root: Node?): Int {
        recurse(root)
        return res
    }

    var res = 0

    fun recurse(root: Node?): Int {
        if (root == null) return 0
        if (root.children.isEmpty()) return 1

        val childLength = ArrayList<Int>()
        root.children.forEach {
            childLength.add(recurse(it))
        }
        childLength.sort()
        val largest = childLength.last()
        val secondLargest = if (childLength.size > 1) childLength[childLength.size - 2] else 0
        res = Math.max(res, largest + secondLargest)
        return Math.max(largest, secondLargest) + 1
    }
}