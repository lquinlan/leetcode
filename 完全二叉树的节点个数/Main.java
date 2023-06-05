public class Main {
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
    int getdep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getdep(node.left);

    }
    boolean check(TreeNode node,int mid,int h) {
        if(h<0) {
            return node == null?false:true;
        }
        int t=(mid)&(1<<h);
        if(t==0){
            return check(node.left,mid,h-1);
        }else{
            return check(node.right,mid,h-1);
        }

    }

    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int h = getdep(root);
        int l = (int) Math.pow(2, h - 1);
        int r = (int) Math.pow(2, h) - 1;


        while (l <= r) {
            int mid=(l+r)>>1;
            if(check(root, mid,h-2)) {
                // System.out.println(mid);
                l=mid+1;

            }else{
                r=mid-1;
            }

        }
        return r;

    }
}