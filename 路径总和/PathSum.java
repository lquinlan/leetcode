public class PathSum {
    public static void main(String[] args) {

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

class Solution {
    int cnt = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return cnt;
        getsum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return cnt;

    }

    void getsum(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        target -= root.val;
        if (target == 0) {
            cnt++;
        }
        getsum(root.left, target);
        getsum(root.right, target);

    }
}