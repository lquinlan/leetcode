public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }
}

class Solution {
    int max = -1;

    int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int ans = 2;
        int tmp1=dfs(node.left) ;
        int tmp2=dfs(node.right);
        ans += (tmp1+tmp2);
        // System.out.println("ans=="+ans);
        max = Math.max(max, ans);
        return Math.max(tmp1,tmp2)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;

    }
}}