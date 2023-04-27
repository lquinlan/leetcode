import java.util.ArrayList;
import java.util.List;

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
    List<List<Integer>> answer = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();

    void dfs(TreeNode node, int cursum, int target) {
        // System.out.println(node.val);
        if (cursum == target && node.left == null && node.right == null) {
            // System.out.println('f');
            answer.add(new ArrayList<Integer>(tmp));
            return;
        }
        // if (Math.abs(cursum) > Math.abs(target)) {
        // return false;
        // }
        // boolean f = false;
        if (node.left != null) {
            tmp.add(node.left.val);
            dfs(node.left, cursum + node.left.val, target);
            tmp.remove(tmp.size() - 1);
        }
        if (node.right != null) {
            tmp.add(node.right.val);
            dfs(node.right, cursum + node.right.val, target);
            tmp.remove(tmp.size() - 1);
        }
        return;

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null)
            return answer;
        tmp.add(root.val);
        dfs(root, root.val, targetSum);
        return answer;

    }
}