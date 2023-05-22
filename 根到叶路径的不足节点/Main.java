public class Main {
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
    public TreeNode sufficientSubset(TreeNode root, int limit) {

        if (!dfs(root, limit, 0)) {
            return null;
        }
        return root;

    }

    boolean dfs(TreeNode root, int limit, int cut) {
        if(root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            cut += root.val;
            if (cut >= limit) {
                return true;
            } else {
               
                return false;
            }
        }
        boolean left = dfs(root.left, limit, cut + root.val);
    
        boolean right = dfs(root.right, limit, cut + root.val);
        
        if(!left){
            root.left = null;
        }
        if(!right){
            root.right = null;
        }
        
        return left || right;

    }
}
