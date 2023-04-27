public class InUnivalTree {
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
    boolean dfs(TreeNode root, int pre) {
        if (root == null)
            return true;
        if (pre == root.val) {
            return dfs(root.left, root.val) && dfs(root.right, root.val);
        } else {
            return false;
        }

    }

    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);

    }
}