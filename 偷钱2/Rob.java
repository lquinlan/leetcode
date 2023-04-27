import java.util.HashMap;
import java.util.Map;

public class Rob {
    public static void main(String[] args) {

    }
}

// dp对于树中的节点有选中与选不中两种情况
/*
 * 如果该节点选中则，则左右子节点不可以选
 * 如果该节点不选中，则左右子节点可选也可以不选
 */
class Solution {
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0))
                + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }
}
