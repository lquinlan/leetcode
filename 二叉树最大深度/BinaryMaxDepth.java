public class BinaryMaxDepth {
    public static void main(String[] args) {

    }
}

class Solution {
    int dfs(TreeNode root, int ind) {
        if (root == null) {
            return ind;
        } else {
            ind++;
        }

        return Math.max(dfs(root.left, ind), dfs(root.right, ind));
    }

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);

    }
}

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