import java.util.ArrayList;
import java.util.List;

public class RecoverTree {
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

    TreeNode pre, l, r;

    void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        if (pre != null && pre.val > node.val) {
            if (l == null)
                l = pre;
            r = node;
        }
        pre = node;

        dfs(node.right);

    }

    void recover(TreeNode node) {
        int tmp = l.val;
        l.val = r.val;
        r.val = tmp;

    }

    public void recoverTree(TreeNode root) {
        dfs(root);

        recover(root);

    }
}