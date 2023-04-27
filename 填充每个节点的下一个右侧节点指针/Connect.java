import java.util.LinkedList;
import java.util.Queue;

public class Connect {
    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            // System.out.println(n);
            for (int i = 0; i < n; i++) {
                Node tmp = queue.poll();
                if (i < n - 1) {
                    tmp.next = queue.peek();
                }
                if (tmp.left != null) {
                    queue.add(tmp.left);

                }
                if (tmp.right != null) {
                    queue.add(tmp.right);

                }

            }
        }
        return root;

    }
}