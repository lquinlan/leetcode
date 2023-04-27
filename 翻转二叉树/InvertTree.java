public class InvertTree {
    public static void main(String[] args) {

    }
}

class Solution {
    void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
    }

    public TreeNode invertTree(TreeNode root) {
        invert(root);

        return root;

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