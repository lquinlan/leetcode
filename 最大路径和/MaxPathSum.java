public class MaxPathSum {
    public static void main(String[] args) {

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class TreeNode {
    int val;
    int max;
    int finmax;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        val = 0;
        max = 0;
        finmax = 0;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.max = val;
        finmax = val;
    }

    TreeNode(int val) {
        this.val = val;
        max = val;
        finmax = val;
    }
}

class Solution {
    // int ans=Integer.MIN_VALUE;

    int dfs1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans1 = dfs1(root.left);
        int ans2 = dfs1(root.right);
        root.finmax = Math.max(ans1 + ans2 + root.val,
                Math.max(ans2 + root.val, Math.max(ans1 + root.val, root.finmax)));
        root.max = Math.max(ans1 + root.val, Math.max(ans2 + root.val, root.max));
        return root.max;

    }

    int dfs2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int ans1 = dfs2(root.left);
        int ans2 = dfs2(root.right);
        return Math.max(Math.max(ans2, ans1), root.finmax);

    }

    public int maxPathSum(TreeNode root) {
        dfs1(root);

        return dfs2(root);
    }
}