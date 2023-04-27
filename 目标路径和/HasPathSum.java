import java.util.LinkedList;
import java.util.Queue;

public class HasPathSum {
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

// class Solution {
// public boolean hasPathSum(TreeNode root, int targetSum) {
// if (root == null)
// return false;
// Queue<Integer> pathSumQueue = new LinkedList<Integer>();
// Queue<TreeNode> path = new LinkedList<TreeNode>();
// path.add(root);
// pathSumQueue.add(root.val);
// while (!path.isEmpty()) {
// int n = path.size();
// for (int i = 0; i < n; ++i) {
// TreeNode tmp = path.poll();
// int tmpsum = pathSumQueue.poll();
// if (tmpsum == targetSum && tmp.left == null && tmp.right == null) {
// return true;
// }
// if (tmp.left != null) {
// path.add(tmp.left);
// pathSumQueue.add(tmpsum + tmp.left.val);
// }
// if (tmp.right != null) {
// path.add(tmp.right);
// pathSumQueue.add(tmpsum + tmp.right.val);
// }
// }
// }
// return false;

// }
// }

class Solution {
    boolean dfs(TreeNode node, int cursum, int target) {
        // System.out.println(node.val);
        if (cursum == target && node.left == null && node.right == null) {
            // System.out.println('f');

            return true;
        }
        // if (Math.abs(cursum) > Math.abs(target)) {
        // return false;
        // }
        boolean f = false;
        if (node.left != null) {
            f = dfs(node.left, cursum + node.left.val, target);
        }
        if (node.right != null && f == false) {
            f = dfs(node.right, cursum + node.right.val, target);
        }
        return f;

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null)
            return false;

        return dfs(root, root.val, targetSum);

    }
}