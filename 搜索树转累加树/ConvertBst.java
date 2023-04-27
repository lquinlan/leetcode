public class ConvertBst {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left, right;

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
    int dfs(TreeNode node, int cur) {
        if (node == null)
            return 0;

        int tmp = dfs(node.right, cur);
        node.val += (tmp + cur);
        tmp = dfs(node.left, node.val);
        return tmp;

    }

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;

    }
}