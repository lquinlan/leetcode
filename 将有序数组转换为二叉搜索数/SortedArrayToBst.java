public class SortedArrayToBst {
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
    void creat(TreeNode node, int[] nums, int l, int r) {
        if(l>=r){
            return;
        }
        int mid=(l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(root.val<=node.val){
            node.left=root;
            creat(root, nums, l, mid);
            creat(root, nums, mid + 1, r);
        }else{
            node.right=root;
            creat(root, nums, l, mid);
            creat(root, nums, mid + 1, r);

        }
        



    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);

        creat(root, nums, 0, mid);
        creat(root, nums, mid + 1, nums.length);
        return root;

    }
}