public class SumNumbers {
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
    private int sum = 0;

    void dfs(TreeNode node, int cnt) {

        cnt = cnt * 10 + node.val;

        if (node.left == null && node.right == null) {
            sum += cnt;
            return;
        }
        if (node.left != null)
            dfs(node.left, cnt);
        if (node.right != null)
            dfs(node.right, cnt);

    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;

    }
}