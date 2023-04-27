
import java.util.ArrayList;
import java.util.List;

public class BuildTree {
    public static void main(String[] args) {

    }
}

// Definition for a binary tree node.
class TreeNode {
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

class Solution {
    List<TreeNode> dfs(int s, int e) {
        List<TreeNode> root = new ArrayList<TreeNode>();
        if (s > e) {
            root.add(null);
            return root;
        }
        for (int i = s; i <= e; ++i) {
            List<TreeNode> lroot = dfs(s, i - 1);
            List<TreeNode> rroot = dfs(i + 1, e);
            for (var l : lroot) {
                for (var r : rroot) {
                    TreeNode newroot = new TreeNode(i, l, r);
                    root.add(newroot);

                }
            }
        }
        return root;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return null;
        }

        return dfs(1, n);

    }
}
