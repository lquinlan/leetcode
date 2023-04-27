import java.util.ArrayList;
import java.util.List;

public class ValidSearchBinaryTree {
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

    public boolean isValidBST(TreeNode root) {

        minddfs(root);
        boolean isValid = true;
        for (int i = 0; i < answer.size() - 1; i++) {
            if (answer.get(i) >= answer.get(i + 1)) {
                isValid = false;
                break;
            }
        }
        return isValid;

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

