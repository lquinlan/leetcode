import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelPost {
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
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    // List<TreeNode> queue = new ArrayList<TreeNode>();
    Deque<TreeNode> queue = new Deque<TreeNode>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return ans;
        }
        int out = 0;
        // int in = 0;
        // List<TreeNode> tmp = new ArrayList<TreeNode>();
        // queue.add(tmp);
        queue.add(root);
        // List<Integer> val = new ArrayList<Integer>();
        // ans.add(val);
        // ans.get(out).add(root.val);
        while (!queue.isEmpty()) {
            // if (queue.get(out).size() == 0) {
            // break;
            // }
            // List<TreeNode> tmp1 = new ArrayList<TreeNode>();
            // queue.add(tmp1);
            List<Integer> val = new ArrayList<Integer>();
            // ans.add(val);
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                root = queue.poll();
                val.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            ans.add(val);
            out++;

        }

        return ans;

    }
}