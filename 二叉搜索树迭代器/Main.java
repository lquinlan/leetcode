// import java.util.LinkedList;
import java.util.Stack;

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

// /
class BSTIterator {
    TreeNode root = null;
    // boolean iter = false;
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        this.root = root;
   
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode tmp = stack.pop();
        int ans = tmp.val;
        tmp = tmp.right;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.left;
        }
        return ans;

    }

    public boolean hasNext() {

        return !stack.isEmpty();

    }
}