import java.util.ArrayList;
import java.util.List;

public class MidPost {
    public static void main(String[] args) {

    }
}

class Solution {
    List<Integer> answer = new ArrayList<Integer>();

    void minddfs(TreeNode root) {
        if (root == null) {
            return;
        }

        minddfs(root.left);
        answer.add(root.val);
        minddfs(root.right);

    }

    public List<Integer> inorderTraversal(TreeNode root) {

        minddfs(root);

        return answer;

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