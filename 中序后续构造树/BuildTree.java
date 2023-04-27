public class BuildTree {
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
    int findRoot(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;

    }

    int i = 0;
    int j = 0;

    void buildLeftTree(int[] post, int[] in, int preind, int inl, int inr, TreeNode root) {
        if (inl >= inr) {
            // --j;
            return;
        }
        if (preind < 0 || preind >= post.length) {
            // --j;
            return;
        }
        TreeNode tmp = new TreeNode(post[preind]);
        root.left = tmp;
        int ind = findRoot(in, post[preind]);
        if (ind >= inl && ind < inr) {
            buildLeftTree(post, in, preind - (inr - ind), inl, ind, tmp);
            buildRightTree(post, in, preind - 1, ind + 1, inr, tmp);
        }
        //

    }

    void buildRightTree(int[] post, int[] in, int preind, int inl, int inr, TreeNode root) {
        if (inl >= inr) {
            --i;
            return;
        }
        if (preind < 0 || preind >= post.length) {
            // --j;
            return;
        }
        // System.out.println("preind=="+preind);
        TreeNode tmp = new TreeNode(post[preind]);
        root.right = tmp;
        int ind = findRoot(in, post[preind]);
        // System.out.println("ind=="+ind);
        if (ind >= inl && ind < inr) {
            buildLeftTree(post, in, preind - (inr - ind), inl, ind, tmp);
            buildRightTree(post, in, preind - 1, ind + 1, inr, tmp);
        }
        //

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - (++i)]);
        int ind = findRoot(inorder, root.val);
        buildLeftTree(postorder, inorder, ind - 1, 0, ind, root);
        buildRightTree(postorder, inorder, postorder.length - 2, ind + 1, inorder.length, root);
        return root;

    }
}
// 1
// 4
// 2
// 3