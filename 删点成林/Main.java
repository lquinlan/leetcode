import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

//
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
    List<TreeNode> list = new ArrayList<>();

    TreeNode dfs(TreeNode root, boolean flag, boolean[] del) {
        if (root == null) {
            return null;
        }
        if (flag && del[root.val] == false) {
            list.add(root);
        }
        boolean isdel = del[root.val];

        root.left = dfs(root.left, isdel, del);
        root.right = dfs(root.right, isdel, del);

        return isdel ? null : root;

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        boolean[] del = new boolean[1001];
        for (var i : to_delete) {
            del[i] = true;
        }
        dfs(root, true, del);

        return list;

    }
}