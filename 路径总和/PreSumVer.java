import java.util.HashMap;

public class PreSumVer {
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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> paths = new HashMap<Long, Integer>();
        paths.put(0L, 1);
        return dfs(root, 0L, paths, targetSum);

    }

    int dfs(TreeNode root, long current, HashMap<Long, Integer> paths, int targetSum) {
        if (root == null) {
            return 0;
        }
        current += root.val;
        int res = paths.getOrDefault(current - targetSum, 0);
        paths.put(current, paths.getOrDefault(current, 0) + 1);
        res += dfs(root.left, current, paths, targetSum);
        res += dfs(root.right, current, paths, targetSum);
        paths.put(current, paths.getOrDefault(current, 0) - 1);
        return res;

    }
}
