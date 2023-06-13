import java.util.ArrayList;
import java.util.List;


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
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        addPath(root, sb);
        return res;
    }

    void addPath(TreeNode root, StringBuilder path) {
        if (root.left == null && root.right == null) {
            res.add(path.append(root.val).toString());
            path.delete(path.length() - String.valueOf(root.val).length(), path.length());
            return;
        }
        int len = path.length();
        path.append(root.val).append("->");
        if (root.left != null) {
            addPath(root.left, path);
        }
        if (root.right != null) {
            addPath(root.right, path);
        }
        path.delete(len, path.length());
    }
}