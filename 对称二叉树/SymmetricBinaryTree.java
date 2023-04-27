import java.util.ArrayList;
import java.util.List;

public class SymmetricBinaryTree {
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
    List<Integer> lans = new ArrayList<Integer>();
    List<Integer> rans = new ArrayList<Integer>();

    void ldfs(TreeNode root) {
        if (root == null) {
            lans.add(-200);
            return;
        }
        lans.add(root.val);
        ldfs(root.left);
        ldfs(root.right);
    }

    void rdfs(TreeNode root) {
        if (root == null) {
            rans.add(-200);
            return;
        }
        rans.add(root.val);
        rdfs(root.right);
        rdfs(root.left);
    }

    public boolean isSymmetric(TreeNode root) {

        ldfs(root);
        rdfs(root);
        boolean result = true;
        for (int i = 0; i < lans.size(); ++i) {
            if (!lans.get(i).equals(rans.get(i))) {
                result = false;
                break;
            }

        }
        return result;
    }
}