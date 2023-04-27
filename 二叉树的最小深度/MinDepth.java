public class MinDepth {
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
    int getdepth(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }
        int r = 0, l = 0;
        if (node.right == null) {
            r = 10000000;
            l = getdepth(node.left) + 1;
        } else if (node.left == null) {
            l = 10000000;
            r = getdepth(node.right) + 1;
        } else {
            l = getdepth(node.left) + 1;
            r = getdepth(node.right) + 1;
        }

        return Math.min(l, r);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getdepth(root) + 1;

    }
}
// 广度遍历更方便