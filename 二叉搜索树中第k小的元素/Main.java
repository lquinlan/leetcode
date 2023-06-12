public class Main{
    public static void main(String[] args) {
        
    }
}
// /
//   Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
//  /
class Solution {
    int cnt;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;

    }
    void dfs (TreeNode root, int k){
        if(root==null){

            return ;
        }
        dfs(root.left,k);
        ++cnt;
        if(cnt==k){
            ans = root.val;
            return ;
        }
        dfs(root.right,k);

    }

}