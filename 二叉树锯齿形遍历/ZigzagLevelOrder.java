import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigzagLevelOrder {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Deque<TreeNode> zigzag = new ArrayDeque<TreeNode>();
        int f = 1;
        zigzag.addLast(root);
        while (!zigzag.isEmpty()) {
            int n = zigzag.size();
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < n; ++i) {
                if (f == 1) {
                    TreeNode node = zigzag.pollFirst();
                    tmp.add(node.val);
                    if (node.left != null) {
                        zigzag.addLast(node.left);
                    }
                    if (node.right != null) {
                        zigzag.addLast(node.right);
                    }

                } else {
                    TreeNode node = zigzag.pollLast();
                    tmp.add(node.val);

                    if (node.right != null) {
                        zigzag.addLast(node.right);
                    }
                    if (node.left != null) {
                        zigzag.addLast(node.left);
                    }

                }

            }
            f = -f;
            answer.add(tmp);

        }

        return answer;

    }
}
