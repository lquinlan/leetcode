public class IsSameTree {
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
    boolean dfs(TreeNode r1, TreeNode r2) {
        if (r1 == r2 && r1 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val != r2.val) {
            return false;
        } else {
            return dfs(r1.left, r2.left) && dfs(r1.right, r2.right);
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);

    }
}
