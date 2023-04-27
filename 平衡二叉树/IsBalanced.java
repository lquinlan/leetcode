public class IsBalanced {
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
    boolean isBalanced = true;

    int getleftdepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = getleftdepth(node.left) + 1;
        int r = getleftdepth(node.right) + 1;
        if (Math.abs(l - r) > 1) {
            isBalanced = false;
        }
        return Math.max(l, r);

    }

    int getrightdepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = getleftdepth(node.left) + 1;
        int r = getleftdepth(node.right) + 1;
        if (Math.abs(l - r) > 1) {
            isBalanced = false;
        }
        return Math.max(l, r);

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return isBalanced;
        }
        int l = getleftdepth(root.left) + 1;
        int r = getleftdepth(root.right) + 1;
        if (Math.abs(l - r) > 1) {
            isBalanced = false;
        }
        return isBalanced;

    }
}
