public class BuildTree {
    public static void main(String[] args) {
        int[] l1 = new int[] { 3, 9, 20, 15, 7 };
        int[] l2 = new int[] { 9, 3, 15, 20, 7 };
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(l1, l2);
        dfs(root);

    }

    static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);

    }
}

class Solution {
    void buildLeftTree(int[] pre, int[] in, int preind, int inl, int inr, TreeNode root) {
        if (inl >= inr) {
            return;
        }
        TreeNode tmp = new TreeNode(pre[preind]);
        root.left = tmp;
        int ind = findRoot(in, pre[preind]);
        if (ind >= inl && ind < inr) {
            buildLeftTree(pre, in, preind + 1, inl, ind, tmp);
            buildRightTree(pre, in, preind + (ind - inl + 1), ind + 1, inr, tmp);
        }
        //

    }
    // 3 9 1 20 15 7
    // 1 9 3 15 20 7

    void buildRightTree(int[] pre, int[] in, int preind, int inl, int inr, TreeNode root) {
        if (inl >= inr) {
            return;
        }
        TreeNode tmp = new TreeNode(pre[preind]);
        root.right = tmp;
        int ind = findRoot(in, pre[preind]);
        if (ind >= inl && ind < inr) {
            buildLeftTree(pre, in, preind + 1, inl, ind, tmp);
            buildRightTree(pre, in, preind + (ind - inl + 1), ind + 1, inr, tmp);
        }
        //

    }

    int findRoot(int[] in, int root) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == root) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int ind = findRoot(inorder, root.val);
        buildLeftTree(preorder, inorder, 1, 0, ind, root);
        buildRightTree(preorder, inorder, ind + 1, ind + 1, inorder.length, root);
        return root;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int val) {
        this.val = val;
    }
}
