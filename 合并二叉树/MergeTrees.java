
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
    void merge(TreeNode root1, TreeNode root2) {
        if (root1.left != null && root2.left != null) {
            root1.left.val += root2.left.val;
            merge(root1.left, root2.left);
        } else if (root1.left == null && root2.left != null) {
            root1.left = root2.left;

        } else if (root1.right != null && root2.right != null) {
            root1.right.val += root2.right.val;
            merge(root1.right, root2.right);
        } else if (root1.right == null && root2.right != null) {
            root1.right = root2.right;

        }
        return;

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;

        return root1;
    }
}