public class Main {
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
    TreeNode createMaxTree(TreeNode root, int curMax) {
        if (root == null) {
            return null;
        }
        curMax = Math.max(root.val, curMax);
        TreeNode newroot = new TreeNode(curMax);
        newroot.left = createMaxTree(root.left, curMax);
        newroot.right = createMaxTree(root.right, curMax);
        return newroot;

    }

    TreeNode createMinTree(TreeNode root, int curMin) {
        if (root == null) {
            return null;
        }
        curMin = Math.min(root.val, curMin);
        // System.out.println("curMin=="+curMin);
        TreeNode newroot = new TreeNode(curMin);
        newroot.left = createMinTree(root.left, curMin);
        newroot.right = createMinTree(root.right, curMin);
        return newroot;

    }

    int ans = 0;

    void dfs(TreeNode root, TreeNode Max, TreeNode Min) {
        if (root == null) {
            return;
        }
        // System.out.println("Max=="+Max.val);
        // System.out.println("Min=="+Min.val);
        int tmp = Math.max(Math.abs(root.val - Max.val), Math.abs(root.val - Min.val));
        ans = Math.max(tmp, ans);
        // System.out.println("ans=="+ans);
        dfs(root.left, Max.left, Min.left);
        dfs(root.right, Max.right, Min.right);
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode rootMax = createMaxTree(root, 0);
        TreeNode rootMin = createMinTree(root, 6000);
        dfs(root, rootMax, rootMin);
        return ans;
    }
}