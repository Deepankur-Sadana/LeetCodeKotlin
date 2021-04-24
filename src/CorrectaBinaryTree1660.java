import kotlin.Pair;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;




/**
 * Runtime: 18 ms, faster than 5.00% of Java online submissions for Correct a Binary Tree.
 * Memory Usage: 76.6 MB, less than 5.22% of Java online submissions for Correct a Binary Tree.
 */
public class CorrectaBinaryTree1660 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    LinkedHashMap<Integer, HashSet<TreeNode>> map = new LinkedHashMap<>();

    public TreeNode correctBinaryTree(TreeNode root) {

        dfs(0, root);
        TreeNode dirtyNode = getDirtyNode();
        recurse(root, dirtyNode);
        return root;
    }

    private void dfs(Integer level, TreeNode root) {
        if (root == null) {
            return;
        }
        map.computeIfAbsent(level, k -> new HashSet<>());
        map.get(level).add(root);
        dfs(level + 1, root.left);
        dfs(level + 1, root.right);


    }

    private void recurse(TreeNode root, TreeNode dirty) {
        if (root == null) return;
        if (root.right == dirty) {
            root.right = null;
            return;
        }

        if (root.left == dirty) {
            root.left = null;
            return;
        }
        recurse(root.left, dirty);
        recurse(root.right, dirty);

    }

    private TreeNode getDirtyNode() {
        Set<Map.Entry<Integer, HashSet<TreeNode>>> outerEntries = map.entrySet();
        for (Map.Entry<Integer, HashSet<TreeNode>> entries : outerEntries) {
            for (TreeNode treeNode : entries.getValue()) {
                if (entries.getValue().contains(treeNode.left) || entries.getValue().contains(treeNode.right))
                    return treeNode;
            }
        }
        return null;
    }


}
