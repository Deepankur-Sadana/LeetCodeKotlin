class `1791 Find Center of Star Graph` {
    class Node(val `val`: Int, val connections: HashSet<Int> = HashSet())

    /**
     * Runtime: 560 ms, faster than 70.97% of Kotlin online submissions for Find Center of Star Graph.
     * Memory Usage: 80.7 MB, less than 64.52% of Kotlin online submissions for Find Center of Star Graph.
     */
    fun findCenter(edges: Array<IntArray>): Int {
        val map = HashMap<Int, Node>()
        edges.forEach { edge ->
            val a = edge[0]
            if (map.contains(a).not())
                map[a] = Node(a)
            val b = edge[1]
            if (map.contains(b).not())
                map[b] = Node(b)

            map[a]!!.connections.add(b)
            map[b]!!.connections.add(a)
            map.forEach { node ->
                if (node.value.connections.size > 1) {
                    return node.key
                }
            }
        }
        return -1
    }
}