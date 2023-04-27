import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {
    public static void main(String[] args) {

    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    List<Integer> tmp = new ArrayList<Integer>();
    TreeNode ans = null;

    void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        tmp.add(root.val);
        dfs(root.right);

    }

    void find(TreeNode root, int x) {
        if (root == null || ans != null)
            return;
        if (root.val == x) {
            ans = root;
            return;
        }
        find(root.left, x);
        find(root.right, x);

    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root);
        int ind = tmp.indexOf(p.val);
        System.out.println(tmp.toString());
        System.out.println(ind);
        if (ind == tmp.size() - 1) {
            return null;
        } else {
            find(root, tmp.get(ind + 1));
            return ans;
        }

    }
}