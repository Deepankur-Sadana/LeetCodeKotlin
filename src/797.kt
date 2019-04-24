class `797` {


    class Node {
        val directions: MutableList<Int> = arrayListOf()
        override fun toString(): String {
            return /*index.toString()+*/" " + directions.toString()
        }
    }

    private val superList = mutableListOf<List<Int>>()
    private val graphNodes: MutableList<Node> = arrayListOf()
    private val intermediatePath: HashSet<Int> = hashSetOf()


    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {

        graph.forEachIndexed { _, _ ->
            graphNodes.add(Node())
        }

        graph.forEachIndexed { index, list ->
            list.forEach { data ->
                intermediatePath.add(data)
                graphNodes[index].directions.add(data)
            }
        }
        print(graphNodes)

        graphNodes.forEachIndexed { index, node ->
            val list: MutableList<Int> = arrayListOf()
            list.add(index)
            if(node.directions.isNotEmpty() && !intermediatePath.contains(index))
            recurse(node, list)
        }
//        print(superList)
        return superList
    }


    private fun recurse(node: Node, pathSoFar: List<Int>) {

        if (node.directions.isEmpty()) {
            superList.add(pathSoFar)
            return
        }

        node.directions.forEach {

            val curr = ArrayList<Int>()

            curr.addAll(pathSoFar)
            curr.add(it)
            recurse(graphNodes[it], curr)
        }
    }

}