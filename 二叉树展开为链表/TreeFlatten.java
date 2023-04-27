import java.util.ArrayList;
import java.util.List;

public class TreeFlatten {
    public static void main(String[] args) {

    }
}

class Solution {
    List<TreeNode> tree = new ArrayList<TreeNode>();

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp1 = root.left;
        TreeNode tmp2 = root.right;
        root.left = null;
        root.right = null;
        tree.add(root);
        dfs(tmp1);
        dfs(tmp2);

    }

    public void flatten(TreeNode root) {
        dfs(root);
        TreeNode cur = root;

        for (int i = 1; i < tree.size(); i++) {
            cur.right = tree.get(i);
            cur = tree.get(i);
        }

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int val) {
        this.val = val;
    }
}