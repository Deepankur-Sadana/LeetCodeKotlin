import java.util.*;

public class Clone_Graph_133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (map.containsKey(node))
            return map.get(node);

        Node newOne = new Node();
        newOne.val = node.val;
        map.put(node, newOne);

        if (node.neighbors != null) {
            newOne.neighbors = new ArrayList<>();
            for (Node n : node.neighbors) {
                newOne.neighbors.add(cloneGraph(n));
            }
        }

        return newOne;

    }


}
